package day1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class VaultTest {
  @Test
  fun handleRightDial() {
    val vault = Vault()
    val tc1 = vault.handleRightDial(0, 50)
    val tc2 = vault.handleRightDial(0, 100)
    val tc3 = vault.handleRightDial(0, 203)

    val tc4 = vault.handleRightDial(3, 99)
    val tc5 = vault.handleRightDial(99, 100)
    val tc6 = vault.handleRightDial(99, 101)

    assertEquals(VaultState(50, 0), tc1)
    assertEquals(VaultState(0, 1), tc2)
    assertEquals(VaultState(3, 2), tc3)

    assertEquals(VaultState(2, 1), tc4)
    assertEquals(VaultState(99, 1), tc5)
    assertEquals(VaultState(0, 2), tc6)
  }

  @Test
  fun handleLeftDial() {
    val vault = Vault()
    val tc1 = vault.handleLeftDial(0, 50)
    val tc2 = vault.handleLeftDial(0, 100)
    val tc3 = vault.handleLeftDial(0, 203)

    val tc4 = vault.handleLeftDial(1, 2)
    val tc5 = vault.handleLeftDial(99, 100)
    val tc6 = vault.handleLeftDial(99, 101)

    assertEquals(VaultState(50, 0), tc1)
    assertEquals(VaultState(0, 1), tc2)
    assertEquals(VaultState(97, 2), tc3)

    assertEquals(VaultState(99, 1), tc4)
    assertEquals(VaultState(99, 1), tc5)
    assertEquals(VaultState(98, 1), tc6)
  }

  @Test
  fun solve() {
    val vault = Vault()
    val tc1 = vault.solve("./src/test/kotlin/day1/tc1.txt")
    val tc2 = vault.solve("./src/test/kotlin/day1/tc2.txt")

    assertEquals(4, tc1)
    assertEquals(12, tc2)
  }
}
