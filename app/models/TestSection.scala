package models

case class TestSection(id: Int,
                       sentenceId: Int,
                       participantId: Int,
                       userInput: Option[String] = None,
                       inputTime: Option[Long] = None,
                       inputLength: Option[Int] = None,
                       errorRate: Option[Double] = None,
                       editDistance: Option[Int] = None,
                       wpm: Option[Double] = None,
                       errorLen: Option[Int] = None,
                       potentialWpm: Option[Double] = None,
                       potentialLength: Option[Int] = None)