package day1

import java.io.File

data class VaultState(
    val dialVal: Int,
    val zeroCounter: Int,
)

class Vault {
    var globalZeroCounter = 0;
    var vaultState = VaultState(50, 0);

    fun solve(path: String): Int {
        val actions = File(path)

        actions.useLines { lines ->
            lines.forEach { action ->
                val direction = action.take(1);
                val velocity = action.substring(1).toInt();

                vaultState = when (direction) {
                    "L" -> handleLeftDial(vaultState.dialVal, velocity)
                    "R" -> handleRightDial(vaultState.dialVal, velocity)
                    else -> throw IllegalArgumentException("Unknown direction: $direction")
                }

                globalZeroCounter += vaultState.zeroCounter
            }
        }
        return globalZeroCounter;
    }

    fun handleRightDial(curDialPos: Int, velocity: Int): VaultState {
        val nextDialPos = curDialPos + velocity;
        val zeroCounter = nextDialPos / 100;
        return VaultState(nextDialPos % 100, zeroCounter )
    }

    fun handleLeftDial(curDialPos: Int, velocity: Int): VaultState {
        val nextDialPos = curDialPos - velocity;
        var zeroCounter = 0;

        if (nextDialPos == 0) {
            zeroCounter++
        } else if (nextDialPos < 0) {
            zeroCounter+=(velocity-curDialPos)/100
            if(curDialPos != 0) {
                zeroCounter++
            }
        }

        val resetDialPos = ((nextDialPos % 100) + 100) % 100

        return VaultState(resetDialPos, zeroCounter);
    }
}