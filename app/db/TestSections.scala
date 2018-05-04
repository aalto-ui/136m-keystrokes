package db

import javax.inject.{Inject, Singleton}
import models.TestSection
import slick.driver.MySQLDriver.api._

object TestSections {
  implicit val testSections = TableQuery[TestSections]
}

class TestSections (tag: Tag) extends Table[TestSection](tag, "TEST_SECTIONS") {
  def id = column[Int]("TEST_SECTION_ID", O.PrimaryKey, O.AutoInc)
  def sentenceId = column[Int]("SENTENCE_ID")
  def participantId = column[Int]("PARTICIPANT_ID")
  def userInput = column[Option[String]]("USER_INPUT")
  def inputTime = column[Option[Long]]("INPUT_TIME")
  def inputLength = column[Option[Int]]("INPUT_LENGTH")
  def errorRate = column[Option[Double]]("ERROR_RATE")
  def editDistance = column[Option[Int]]("EDIT_DISTANCE")
  def wpm = column[Option[Double]]("WPM")
  def errorLen = column[Option[Int]]("ERROR_LEN")
  def potentialWpm = column[Option[Double]]("POTENTIAL_WPM")
  def potentialLength = column[Option[Int]]("POTENTIAL_LENGTH")

  def participantFk = foreignKey("PARTICIPANT_FK", participantId, Participants.participants)(_.id, onDelete =  ForeignKeyAction.Cascade)
  def sentenceFk = foreignKey("SENTENCE_FK", sentenceId, Sentences.sentences)(_.id)

  def * = (id, sentenceId, participantId, userInput, inputTime, inputLength, errorRate, editDistance, wpm, errorLen, potentialWpm, potentialLength) <> (TestSection.tupled, TestSection.unapply)
}