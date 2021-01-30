package puzzles.p08

class Console(private val instructions: Array<ConsoleInstruction>) {
    var cursor: Int = 0
        private set

    var accumulator: Int = 0
        private set

    val instruction: ConsoleInstruction
        get() = this.instructions[cursor]

    private val visitedInstructions: MutableSet<Int> = HashSet()

    fun isLooping(): Boolean {
        return this.visitedInstructions.contains(this.cursor)
    }

    fun isBootloaderComplete(): Boolean {
        return this.cursor == this.instructions.size
    }

    fun step() {
        this.visitedInstructions.add(this.cursor)
        when (this.instruction.instructionType) {
            ConsoleInstructionType.NOP -> {
                cursor++
            }
            ConsoleInstructionType.ACC -> {
                accumulator += instruction.instructionValue
                cursor++
            }
            ConsoleInstructionType.JMP -> {
                cursor += instruction.instructionValue
            }
        }
    }
}

fun List<String>.toConsole(): Console {
    return Console(this.toConsoleInstructions())
}