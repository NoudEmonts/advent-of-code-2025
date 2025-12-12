package day2

import java.io.File

class AnomalyDetection {
  fun solve(path: String): Long {
    val ranges = File(path).readText().split(",")
    var sum: Long = 0
    for (range in ranges) {
      val (from, to) = range.split("-").map(String::toLong)

      sum += sumRepeatingIDs(from, to)
    }

    print("Total: $sum")
    return sum
  }

  fun sumRepeatingIDs(
      from: Long,
      to: Long,
  ): Long {
    val regex = Regex("""^(\d*)\1+$""")
    var sum: Long = 0

    for (id in from..to) {
      if (id.toString().matches(regex)) {
        sum += id
      }
    }

    return sum
  }
}
