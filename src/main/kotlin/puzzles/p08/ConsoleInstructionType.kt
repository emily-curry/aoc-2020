package puzzles.p08

enum class ConsoleInstructionType {
    ACC,
    JMP,
    NOP
}

fun CharSequence.toConsoleInstructionType(): ConsoleInstructionType {
    return when (this.toString().toLowerCase()) {
        ("acc") -> ConsoleInstructionType.ACC
        ("jmp") -> ConsoleInstructionType.JMP
        ("nop") -> ConsoleInstructionType.NOP
        else -> throw IllegalArgumentException("Invalid string [ $this ] provided")
    }
}