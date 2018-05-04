package db

import javax.inject.{Inject, Singleton}

import models.Participant
import slick.driver.MySQLDriver.api._

object Participants {
  def participants = TableQuery[Participants]
}


class Participants(tag: Tag) extends Table[Participant](tag, "PARTICIPANTS") {
  def id = column[Int]("PARTICIPANT_ID", O.PrimaryKey, O.AutoInc)
  def ipAddress = column[Option[String]]("IP_ADDRESS")
  def age = column[Option[Int]]("AGE")
  def gender = column[Option[String]]("GENDER")
  def hasTakenTypingCourse = column[Option[Boolean]]("HAS_TAKEN_TYPING_COURSE")
  def os = column[Option[String]]("OS")
  def osVersion = column[Option[String]]("OS_VERSION")
  def browser = column[Option[String]]("BROWSER")
  def browserVersion = column[Option[String]]("BROWSER_VERSION")
  def browserLanguage = column[Option[String]]("BROWSER_LANGUAGE")
  def detectedCountry = column[Option[String]]("DETECTED_COUNTRY")
  def detectedRegion = column[Option[String]]("DETECTED_REGION")
  def country = column[Option[String]]("COUNTRY")
  def region = column[Option[String]]("REGION")
  def layout = column[Option[String]]("LAYOUT")
  def wpm = column[Option[Double]]("WPM")
  def errorRate = column[Option[Double]]("ERROR_RATE")
  def nativeLanguage = column[Option[String]]("NATIVE_LANGUAGE")
  def fingers = column[Option[String]]("FINGERS")
  def timeSpentTyping = column[Option[Int]]("TIME_SPENT_TYPING")
  def keyboardType = column[Option[String]]("KEYBOARD_TYPE")

  def * = (
      id,
      ipAddress,
      age,
      gender,
      hasTakenTypingCourse,
      os,
      osVersion,
      browser,
      browserVersion,
      browserLanguage,
      detectedCountry,
      detectedRegion,
      country,
      region,
      layout,
      wpm,
      errorRate,
      nativeLanguage,
      fingers,
      timeSpentTyping,
      keyboardType
    ) <> (Participant.tupled, Participant.unapply)
}
