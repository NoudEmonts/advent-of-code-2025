package day3

import java.io.File

class Batteries {
  lateinit var batteryBank: Array<IntArray>

  init {
    batteryBank =
        File("input.txt")
            .readLines()
            .map { line -> line.map { char -> char.digitToInt() }.toIntArray() }
            .toTypedArray()
  }

  fun determineMaximumJoltage(): Int = 0
}
