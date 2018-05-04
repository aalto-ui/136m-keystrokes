package models

case class Keystroke(id: Long, pressTime: Long, releaseTime: Long, keycode: Int, letter: String, testSectionId: Int)
