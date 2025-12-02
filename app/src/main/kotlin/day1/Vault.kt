package day1

import java.io.File
import kotlin.math.abs

data class VaultState(
    val dialVal: Int,
    val zeroCounter: Int,
)

class Vault {
    var globalZeroCounter = 0;
    var vaultState = VaultState(50, 0);

    fun solve(): Int {
        val actions = File("./src/main/kotlin/day1/input.txt")

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

        println("Vault cracked! \nWe hit zero - $globalZeroCounter times")

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
            println(nextDialPos)
            if(curDialPos == 0) {
                zeroCounter++
            }
            println("increasing zero counter with ${(velocity - curDialPos)/100 + 1}")
            zeroCounter+=(velocity-curDialPos)/100 + 1
        }
        return VaultState(abs(nextDialPos % 100), zeroCounter);
    }
//
//    fun determineZeroHits(currentDialVal: Int, nextDialVal: Int): Int {
//        val havePassedZero =
//            (currentDialVal > 0 && nextDialVal < 0) ||
//                    (currentDialVal < 0 && nextDialVal > 0)
//
//        var hits = 0;
//        if (havePassedZero) {
//            hits = 1 + abs(currentDialVal / 100) + abs(nextDialVal / 100)
//            if (currentDialVal % 100 == 0) {
//                hits--;
//            }
//        } else {
//            if (nextDialVal == 0) {
//                abs(currentDialVal / 100) + 1
//            } else {
//                abs(nextDialVal / 100 - currentDialVal / 100)
//            }
//
//        }
//        if (currentDialVal % 100 == 0) {
//            hits--;
//        }
//
//        return hits
//    }
}