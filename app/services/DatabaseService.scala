package services

import javax.inject.{Inject, Singleton}

import db.Sentences.sentences
import db.TestSections.testSections
import db.Participants.participants
import db.Keystrokes.keystrokes
import models.{Keystroke, Participant, Sentence, TestSection}
import play.api.db.slick.DatabaseConfigProvider

import scala.concurrent.{Future, Promise}
import slick.driver.JdbcProfile
import slick.driver.MySQLDriver.api._

import scala.concurrent.ExecutionContext.Implicits.global

trait DatabaseService {
  def getRandomSentence(id: Int): Future[Seq[Sentence]]

  def updateUserInput(testSectionId: Int, userInput: String): Future[Int]
  def updateInputTime(testSectionId: Int, time: Long, wpm: Double, inputLength: Int, potentialWpm: Double, potentialLen: Int): Future[Int]
  def updateErrorRate(testSectionId: Int, editDistance: Int, errorRate: Double, errorLen: Int): Future[Int]
  def updateBrowserData(participantId: Int, ipAddress: String, os: String, osVersion: Option[String], browser: String,
                        browserVersion: Option[String], browserLanguage: Option[String], country: Option[String], region: Option[String])
  def updatePersonalData(participantId: Int, age: Int, gender: String, hasTakenTypingCourse: Boolean, fingers: String,
                         timeSpentTyping: Int, layout: String, keyboardType: String, nativeLanguage: String, country: String, region: String)

  def updateUserStats(participantId: Int, wpm: Double, errorRate: Double)

  def getTestSections(participantId: Int): Future[Seq[TestSection]]
  def getKeystrokes(testSectionId: Int): Future[Seq[Keystroke]]
  def getFirstKeystroke(testSectionId: Int): Future[Seq[Keystroke]]
  def getDataForError(testSectionId: Int): Future[Seq[(Option[String], String)]]
  def getSentence(testSectionId: Int): Future[Seq[Sentence]]

  def getBiggestError(participantId: Int): Future[Seq[(Option[String], String, Option[Int], Option[Double])]]
  def getFastestSentence(participantId: Int): Future[Seq[(Option[String], Option[Int], Option[Double])]]
  def getSlowestSentence(participantId: Int): Future[Seq[(Option[String], Option[Int], Option[Double])]]

  def addParticipant(p: Participant): Future[Int]
  def addTestSection(ts: TestSection): Future[Int]
  def addKeystroke(ks: Keystroke)
  def addKeystrokes(ks: Seq[Keystroke]): Future[Option[Int]]
}

@Singleton
class DatabaseServiceImpl @Inject()(dbConfigProvider: DatabaseConfigProvider) extends DatabaseService {
  val dbConfig = dbConfigProvider.get[JdbcProfile]
  val rand = SimpleFunction.nullary[Double]("rand")

  def getRandomSentence(id: Int): Future[Seq[Sentence]] = {
    val participantSentenceIds = for {
        (t, s) <- testSections join sentences on (_.sentenceId === _.id) if t.participantId === id
      } yield s.id
    val unusedSentences = sentences.filterNot(_.id in participantSentenceIds)

    val rand = SimpleFunction.nullary[Double]("rand")
    dbConfig.db.run(unusedSentences.sortBy(x => rand).take(1).result)
  }

  def updateUserInput(testSectionId: Int, userInput: String): Future[Int] = {
    val q = for { ts <- testSections if ts.id === testSectionId} yield ts.userInput
    dbConfig.db.run(q.update(Some(userInput)))
  }

  def updateInputTime(testSectionId: Int, time: Long, wpm: Double, inputLength: Int, potentialWpm: Double, potentialLen: Int): Future[Int] = {
    val q = for { ts <- testSections if ts.id === testSectionId} yield (ts.inputTime, ts.wpm, ts.inputLength, ts.potentialWpm, ts.potentialLength)
    dbConfig.db.run(q.update(Some(time), Some(wpm), Some(inputLength), Some(potentialWpm), Some(potentialLen)))
  }

  def updateErrorRate(testSectionId: Int, editDistance: Int, errorRate: Double, errorLen: Int): Future[Int] = {
    val q = for { ts <- testSections if ts.id === testSectionId} yield (ts.errorRate, ts.editDistance, ts.errorLen)
    dbConfig.db.run(q.update(Some(errorRate), Some(editDistance), Some(errorLen)))
  }

  def updateBrowserData(participantId: Int, ipAddress: String, os: String, osVersion: Option[String], browser: String,
                        browserVersion: Option[String], browserLanguage: Option[String], country: Option[String], region: Option[String]) = {
    val q = for { p <- participants if p.id === participantId} yield (p.ipAddress, p.os, p.osVersion, p.browser, p.browserVersion, p.browserLanguage, p.detectedCountry, p.detectedRegion)
    dbConfig.db.run(q.update(Some(ipAddress), Some(os), osVersion, Some(browser),  browserVersion, browserLanguage, country, region))
  }

  def updatePersonalData(participantId: Int, age: Int, gender: String, hasTakenTypingCourse: Boolean, fingers: String,
                         timeSpentTyping: Int, layout: String, keyboardType: String, nativeLanguage: String, country: String, region: String) = {
    val q = for { p <- participants if p.id === participantId} yield (p.age, p.gender, p.hasTakenTypingCourse, p.fingers, p.timeSpentTyping,
                                                                      p.layout, p.keyboardType, p.nativeLanguage, p.country, p.region)
    dbConfig.db.run(q.update(Some(age), Some(gender), Some(hasTakenTypingCourse), Some(fingers), Some(timeSpentTyping), Some(layout),
                                        Some(keyboardType), Some(nativeLanguage), Some(country), Some(region)))
  }

  def updateUserStats(participantId: Int, wpm: Double, errorRate: Double) = {
    val q = for { p <- participants if p.id === participantId } yield (p.wpm, p.errorRate)
    dbConfig.db.run(q.update(Some(wpm), Some(errorRate)))
  }

  def getTestSections(participantId: Int): Future[Seq[TestSection]] = {
    dbConfig.db.run(testSections.filter(_.participantId === participantId).filter(_.userInput.isDefined).result)
  }

  def getKeystrokes(testSectionId: Int): Future[Seq[Keystroke]] = {
    dbConfig.db.run(keystrokes.filter(_.testSectionId === testSectionId).result)
  }

  def getFirstKeystroke(testSectionId: Int): Future[Seq[Keystroke]] = {
    dbConfig.db.run(keystrokes.filter(_.testSectionId === testSectionId).sortBy(_.pressTime).take(1).result)
  }

  def getSentence(testSectionId: Int): Future[Seq[Sentence]] = {
    val q = for {
      (ts, s) <- testSections join sentences on (_.sentenceId === _.id) if ts.id === testSectionId
    } yield s
    dbConfig.db.run(q.result)
  }

  def getBiggestError(participantId: Int): Future[Seq[(Option[String], String, Option[Int], Option[Double])]] = {
    val q = for {
      max_ts <- testSections.filter(_.participantId === participantId).sortBy(_.errorRate.desc).take(1)
      s <- sentences.filter(_.id === max_ts.sentenceId)
    } yield (max_ts.userInput, s.sentence, max_ts.editDistance, max_ts.wpm)
    dbConfig.db.run(q.result)
  }

  def getFastestSentence(participantId: Int): Future[Seq[(Option[String], Option[Int], Option[Double])]] = {
    val q = for {
      max_ts <-testSections.filter(_.participantId === participantId).sortBy(_.wpm.desc).take(1)
    } yield (max_ts.userInput, max_ts.editDistance, max_ts.wpm)
    dbConfig.db.run(q.result)
  }

  def getSlowestSentence(participantId: Int): Future[Seq[(Option[String], Option[Int], Option[Double])]] = {
    val q = for {
      max_ts <-testSections.filter(_.participantId === participantId).sortBy(_.wpm.asc).take(1)
    } yield (max_ts.userInput, max_ts.editDistance, max_ts.wpm)
    dbConfig.db.run(q.result)
  }

  def addParticipant(p: Participant) = {
    dbConfig.db.run(participants returning participants.map(_.id) += p)
  }

  def addTestSection(ts: TestSection) = {
    dbConfig.db.run(testSections returning testSections.map(_.id) += ts)
  }

  def addKeystroke(ks: Keystroke) = {
     dbConfig.db.run(keystrokes += ks)
  }

  def addKeystrokes(ks: Seq[Keystroke]): Future[Option[Int]] = {
    dbConfig.db.run(keystrokes ++= ks)
  }

  def getDataForError(testSectionId: Int): Future[Seq[(Option[String], String)]] = {
    val q = for {
      (ts, s) <- testSections join sentences on(_.sentenceId === _.id) if ts.id === testSectionId
    } yield (ts.userInput, s.sentence)
    dbConfig.db.run(q.result)
  }

}