package db

import javax.inject.{Inject, Singleton}
import models.Keystroke
import slick.driver.MySQLDriver.api._

class Keystrokes (tag: Tag) extends Table[Keystroke](tag, "KEYSTROKES") {
  def id = column[Long]("KEYSTROKE_ID", O.PrimaryKey, O.AutoInc)
  def pressTime = column[Long]("PRESS_TIME")
  def releaseTime = column[Long]("RELEASE_TIME")
  def keycode = column[Int]("KEYCODE")
  def letter = column[String]("LETTER")
  def testSectionId = column[Int]("TEST_SECTION_ID")

  def testSectionFk = foreignKey("TEST_SECTION_FK", testSectionId, TestSections.testSections)(_.id, onDelete = ForeignKeyAction.Cascade)

  def * = (id, pressTime, releaseTime, keycode, letter, testSectionId) <> (Keystroke.tupled, Keystroke.unapply)
}

object Keystrokes {
  implicit val keystrokes = TableQuery[Keystrokes]
}
