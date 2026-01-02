package day4

import java.io.File

class PaperGrid(filePath: String) {
  var maxRows: Int = 0
  var maxCols: Int = 0
  lateinit var lines: List<String>
  val zeroGrid: Array<IntArray>

  private val directions = listOf(
    -1 to 0, //left
    -1 to -1, //leftup
    0 to -1, //up
    1 to -1, //rightup
    1 to 0, //right
    1 to 1, //rightdown
    0 to 1, //down
    -1 to 1, //leftdown
    )

  init {
    zeroGrid = createZeroGrid(filePath)
  }

  private fun createZeroGrid(filePath: String): Array<IntArray> {
    lines = File(filePath).readLines()

    maxRows = lines.size
    maxCols = lines.first().length

    return Array(maxRows) { IntArray(maxCols) }
  }

  fun increment(x: Int, y: Int) {
    if (x !in 0 until maxCols || y !in 0 until maxRows) return

    if (zeroGrid[y][x] < 0) return

    zeroGrid[y][x]++
  }

  fun decrement(x: Int, y: Int) {
    if (x !in 0 until maxCols || y !in 0 until maxRows) return

    if (zeroGrid[y][x] < 0) return

    zeroGrid[y][x]--
  }

  fun solve(): Int {
    for (y in 0 until lines.size) {
      for (x in 0 until lines[y].length) {

        if (lines[y][x] == '@') {
          directions.forEach { (dx, dy) ->
            increment(x + dx, y + dy)
          }
        } else {
          zeroGrid[y][x] = -1
        }
      }
    }

    var hasPaperMoved = true
    var count = 0
    while (hasPaperMoved) {
      hasPaperMoved = false
      for (y in 0 until zeroGrid.size) {
        for (x in 0 until zeroGrid[y].size) {
          if (zeroGrid[y][x] in 0 .. 3) {
            zeroGrid[y][x] = -1
            count++
            hasPaperMoved = true

            directions.forEach { (dx, dy) ->
              decrement(x + dx, y + dy)
            }



          }
        }
      }
    }

    return count
  }
}
