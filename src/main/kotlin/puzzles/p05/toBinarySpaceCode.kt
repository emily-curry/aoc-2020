package puzzles.p05

fun Char.toBinarySpaceCode(): BinarySpaceCode {
    return when (this.toUpperCase()) {
        'F' -> BinarySpaceCode.LOWER
        'B' -> BinarySpaceCode.UPPER
        'L' -> BinarySpaceCode.LOWER
        'R' -> BinarySpaceCode.UPPER
        else -> throw IllegalArgumentException("Cannot parse [ $this ] as ticket code")
    }
}