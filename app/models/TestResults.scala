package models

case class TestResults(wpm: Int,
                       error: Double,
                       sMostErr: Option[String],
                       sMostErrCor: Option[String],
                       sMostErrDist: Option[Int],
                       sMostErrWpm: Option[Int],
                       sFastest: String,
                       sFastestError: Int,
                       sFastestWpm: Int,
                       sSlowest: String,
                       sSlowestError: Int,
                       sSlowestWpm: Int)
