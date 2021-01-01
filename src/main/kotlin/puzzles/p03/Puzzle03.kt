package puzzles.p03

import lib.input.InputReader
import lib.runner.PuzzleId
import lib.runner.PuzzleRunner

@PuzzleId("03")
class Puzzle03(input: InputReader) : PuzzleRunner(input) {
    override fun run() {
        val a = calculateCollisionsForSlope(3, 1)
        println("Part 1: Collisions \n\tA [ $a ]")
        val b = calculateCollisionsForSlope(1, 1)
        val c = calculateCollisionsForSlope(5, 1)
        val d = calculateCollisionsForSlope(7, 1)
        val e = calculateCollisionsForSlope(1, 2)
        println("Part 2: Collisions \n\tB [ $b ]\n\tC [ $c ]\n\tD [ $d ]\n\tE [ $e ]")
        val product = a * b * c * d * e
        println("Part 2: Collisions Product [ $product ]")
    }

    private fun calculateCollisionsForSlope(x: Int, y: Int): Long {
        val map = createSlopeMap(input.toStringList())
        var collisions = 0
        do {
            if (map.getCurrentLocationType() == SlopeMapCell.TREE) collisions++
            map.navigate(x, y)
        } while (!map.isOutOfBounds())
        return collisions.toLong()
    }
}