package day3

import java.io.File

class Batteries(
    filePath: String,
) {
  var batteryBank: Array<IntArray> =
      File(filePath)
          .readLines()
          .map { line -> line.map { char -> char.digitToInt() }.toIntArray() }
          .toTypedArray()

  fun solve(): Int {
    val maxJoltages = batteryBank.map { bank -> determineMaximumJoltage(bank) }
    return maxJoltages.sum()
  }

  companion object {
    fun determineMaximumJoltage(bank: IntArray): Int {
      var max1 = bank.withIndex().maxBy { it.value }
      var max2: Int

      if (max1.index >= bank.lastIndex) {
        max2 = max1.value

        val subset = bank.sliceArray(0 until bank.lastIndex)
        max1 = subset.withIndex().maxBy { it.value }
      } else {
        val subset = bank.sliceArray(max1.index + 1 until bank.lastIndex + 1)
        max2 = subset.max()
      }

      return "${max1.value}$max2".toInt()
    }
  }
}
