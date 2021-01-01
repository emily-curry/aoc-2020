package puzzles.p01

import lib.input.InputReader
import lib.runner.PuzzleId
import lib.runner.PuzzleRunner

@PuzzleId("01")
class Puzzle01(input: InputReader) : PuzzleRunner(input) {
    private val lines = input.toIntList()

    override fun run() {
        val sumPair = findSumPair(2020)
        println("Part 1: [ ${sumPair.first * sumPair.second} ]")
        val sumTriple = findSumTriple(2020)
        println("Part 2: [ ${sumTriple.first * sumTriple.second * sumTriple.third} ]")
    }

    // TODO: Make recursive?
    private fun findSumPair(target: Int): Pair<Int, Int> {
        for (i in lines.indices) {
            val ks = i + 1;
            for (k in ks until lines.size) {
                if (lines[i] + lines[k] == target) return Pair(lines[i], lines[k])
            }
        }
        throw IllegalArgumentException("No values in input that sum to [ $target ]")
    }

    private fun findSumTriple(target: Int): Triple<Int, Int, Int> {
        for (i in lines.indices) {
            val ks = i + 1;
            for (k in ks until lines.size) {
                val js = k + 1;
                for (j in js until lines.size) {
                    if (lines[i] + lines[k] + lines[j] == target) return Triple(lines[i], lines[k], lines[j])
                }
            }
        }
        throw IllegalArgumentException("No values in input that sum to [ $target ]")
    }
}