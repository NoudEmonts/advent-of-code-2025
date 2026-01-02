package day4

import kotlin.test.Test
import kotlin.test.assertEquals

class PaperGridTest {

  @Test
  fun determineNrOfAccessibleRolls() {
    val paperGrid = PaperGrid("./src/test/kotlin/day4/input-test.txt")

    val solution = paperGrid.solve()

    assertEquals(43, solution)
  }
}
