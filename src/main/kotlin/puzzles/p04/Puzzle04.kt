package puzzles.p04

import lib.input.InputReader
import lib.runner.PuzzleId
import lib.runner.PuzzleRunner

@PuzzleId("04")
class Puzzle04(input: InputReader) : PuzzleRunner(input) {
    override fun run() {
        val blocks = input.toString().split(Regex("""\n\n"""))
        val passports = blocks.map { b -> Passport.parse(b) }
        val valid = passports.map { p -> p.isValid() }.fold(0) { acc, x -> if (x) acc + 1 else acc }
        println("Part 1: Valid Passports [ $valid ]")
        val validStrict = passports.map { p -> p.isValid(true) }.fold(0) { acc, x -> if (x) acc + 1 else acc }
        println("Part 2: Valid Passports (Strict) [ $validStrict ]")
    }
}