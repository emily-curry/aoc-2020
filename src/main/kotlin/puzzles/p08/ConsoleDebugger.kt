package puzzles.p08

class ConsoleDebugger(private val instructions: List<String>) {
    fun createWorkingConsole(): Console {
        for (point in this.determinePossibleFailurePoints()) {
            val console = this.createTestConsole(point)
            if (this.isConsoleValid(console)) return console
        }
        throw IllegalStateException("No working consoles could be constructed")
    }

    private fun createTestConsole(testCursor: Int): Console {
        val instructionSet = this.instructions.toConsoleInstructions()
        instructionSet[testCursor].instructionType = when (instructionSet[testCursor].instructionType) {
            ConsoleInstructionType.JMP -> ConsoleInstructionType.NOP
            ConsoleInstructionType.NOP -> ConsoleInstructionType.JMP
            else -> throw IllegalArgumentException()
        }
        return Console(instructionSet)
    }

    private fun determinePossibleFailurePoints(): Array<Int> {
        return this.instructions.toConsoleInstructions()
            .mapIndexed() { idx, i -> Pair(idx, i) }
            .filter { i -> i.second.instructionType == ConsoleInstructionType.JMP || i.second.instructionType == ConsoleInstructionType.NOP }
            .map { i -> i.first }
            .toTypedArray()
    }

    // FIXME: Possible out of bounds exception in console
    private fun isConsoleValid(console: Console): Boolean {
        while (!console.isLooping()) {
            console.step()
            if (console.isBootloaderComplete()) return true
        }
        return false
    }
}