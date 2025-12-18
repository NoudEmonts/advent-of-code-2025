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

  fun solve(nrBatteries: Int): Long {
    val maxJoltages = batteryBank.map { bank -> determineMaximumJoltage(bank, nrBatteries) }
    return maxJoltages.sum()
  }

  companion object {
    fun determineMaximumJoltage(
        bank: IntArray,
        nrBatteries: Int,
    ): Long {
      val maxJoltages = ArrayList<Int>(nrBatteries)
      var idxMin = 0
      for (idxMax in (bank.size - nrBatteries + 1) until bank.size + 1) {
        val subset = bank.sliceArray(idxMin until idxMax)

        val max = subset.withIndex().maxBy { it.value }

        maxJoltages.add(max.value)
        idxMin += max.index + 1
      }

      return maxJoltages.joinToString("").toLong()
    }
  }
}
