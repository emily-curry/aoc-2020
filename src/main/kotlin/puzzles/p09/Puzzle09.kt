package puzzles.p09

import lib.input.InputReader
import lib.runner.PuzzleId
import lib.runner.PuzzleRunner

@PuzzleId("09")
class Puzzle09(input: InputReader) : PuzzleRunner(input) {

    override fun run() {
        val parser = XmasParser(input.toLongList())
        val invalidTarget = parser.findInvalidTarget()
        println("Part 1: Value of first invalid target: [ $invalidTarget ]")
        val targetSet = parser.findContiguousSetForTarget()
        val weakness = targetSet.minOrNull()!!.plus(targetSet.maxOrNull()!!)
        println("Part 1: Value of encryption weakness: [ $weakness ]")
    }
}