package day2

import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class AnomalyDetectionTest {
  @Test
  fun sumRepeatingIDs() {
    val day2 = AnomalyDetection()

    val tc1 = day2.sumRepeatingIDs(11, 22)
    val tc2 = day2.sumRepeatingIDs(95, 115)
    val tc3 = day2.sumRepeatingIDs(998, 1012)
    val tc4 = day2.sumRepeatingIDs(1188511880, 1188511890)

    assertEquals(33, tc1)
    assertEquals(210, tc2)
    assertEquals(2009, tc3)
    assertEquals(1188511885, tc4)
  }

  @Test
  fun solve() {
    val day2 = AnomalyDetection()

    val tc1 = day2.solve("./src/test/kotlin/day2/input-demo.txt")

    assertEquals(4174379265, tc1)
  }
}
