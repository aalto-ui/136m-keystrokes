package db

import javax.inject.{Inject, Singleton}
import slick.driver.MySQLDriver.api._
import models.Sentence

object Sentences {
  def sentences = TableQuery[Sentences]
}

class Sentences(tag: Tag) extends Table[Sentence](tag, "SENTENCES") {
  def id = column[Int]("SENTENCE_ID", O.PrimaryKey, O.AutoInc)
  def sentence = column[String]("SENTENCE")

  def * = (id, sentence) <> (Sentence.tupled, Sentence.unapply)
}