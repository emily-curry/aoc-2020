package puzzles.p09

import lib.input.InputReader
import lib.runner.PuzzleId
import lib.runner.PuzzleRunner

@PuzzleId("09")
class Puzzle09(input: InputReader) : PuzzleRunner(input) {

    override fun run() {
        val parser = XmasParser(input.toLongList())
        while (parser.isCurrentTargetValid()) {
            parser.step()
        }
        val invalidTarget = parser.target
        println("Part 1: Value of first invalid target: [ $invalidTarget ]")
    }
}