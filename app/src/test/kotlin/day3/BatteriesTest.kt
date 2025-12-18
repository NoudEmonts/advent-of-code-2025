package day3

import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class BatteriesTest {
  @Test
  fun determineMaximumJoltage() {
    val bank1 = intArrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 1, 1, 1, 1, 1)
    val bank2 = intArrayOf(8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 9)
    val bank3 = intArrayOf(2, 3, 4, 2, 3, 4, 2, 3, 4, 2, 3, 4, 2, 7, 8)
    val bank4 = intArrayOf(8, 1, 8, 1, 8, 1, 9, 1, 1, 1, 1, 2, 1, 1, 1)

    val result1 = Batteries.determineMaximumJoltage(bank1, 12)
    val result2 = Batteries.determineMaximumJoltage(bank2, 12)
    val result3 = Batteries.determineMaximumJoltage(bank3, 12)
    val result4 = Batteries.determineMaximumJoltage(bank4, 12)

    assertEquals(987654321111, result1)
    assertEquals(811111111119, result2)
    assertEquals(434234234278, result3)
    assertEquals(888911112111, result4)
  }

  @Test
  fun solve() {
    val batteries = Batteries("./src/test/kotlin/day3/input-test.txt")

    val solution = batteries.solve(12)

    assertEquals(3121910778619, solution)
  }
}
