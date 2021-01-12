package puzzles.p06

import lib.input.InputReader
import lib.runner.PuzzleId
import lib.runner.PuzzleRunner

@PuzzleId("06")
class Puzzle06(input: InputReader) : PuzzleRunner(input) {
    override fun run() {
        val blocks = input.toString().split(Regex("""\n\n"""))
        val formGroups = blocks.map { b -> b.toDeclarationFormGroup() }
        val answersAnySum = formGroups.map { f -> f.sumGroupAnswersAny(true) }.sum()
        println("Part 1: Sum of true answers by ANY member of a group: [ $answersAnySum ]")
        val answersEverySum = formGroups.map { f -> f.sumGroupAnswersEvery(true) }.sum()
        println("Part 1: Sum of true answers by EVERY member of a group: [ $answersEverySum ]")
    }
}