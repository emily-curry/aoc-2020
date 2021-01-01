package puzzles.p02

import lib.input.InputReader
import lib.runner.PuzzleId
import lib.runner.PuzzleRunner

@PuzzleId("02")
class Puzzle02(input: InputReader) : PuzzleRunner(input) {
    private val lines = input.toStringList()

    override fun run() {
        val validFreqPasswords = getValidCharacterFrequencyPasswords()
        println("Part 1: [ $validFreqPasswords ]")
        val validPosPasswords = getValidCharacterPositionPasswords()
        println("Part 2: [ $validPosPasswords ]")
    }

    private fun getValidCharacterFrequencyPasswords(): Int {
        var validPasswords = 0
        for (l in lines) {
            val policy = CharacterFrequencyPasswordPolicy(l)
            val password = PasswordUtils.parsePassword(l)
            if (policy.test(password)) validPasswords++;
        }
        return validPasswords
    }

    private fun getValidCharacterPositionPasswords(): Int {
        var validPasswords = 0
        for (l in lines) {
            val policy = CharacterPositionPasswordPolicy(l)
            val password = PasswordUtils.parsePassword(l)
            if (policy.test(password)) validPasswords++;
        }
        return validPasswords
    }
}