package puzzles.p08

data class ConsoleInstruction(var instructionType: ConsoleInstructionType, val instructionValue: Int) {
}

fun CharSequence.toConsoleInstruction(): ConsoleInstruction {
    val (typeStr, valStr) = this.split(' ');
    return ConsoleInstruction(typeStr.toConsoleInstructionType(), valStr.toInt());
}

fun List<String>.toConsoleInstructions(): Array<ConsoleInstruction> {
    val instructions = this.map { i -> i.toConsoleInstruction() }
    return instructions.toTypedArray()
}