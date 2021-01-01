package puzzles.p03

enum class SlopeMapCell(val char: Char) {
    OPEN('.'),
    TREE('#');

    companion object {
        fun getByChar(c: Char): SlopeMapCell {
            for (e in values()) {
                if (e.char == c) return e
            }
            throw IllegalArgumentException("No SlopeMapCell for char [ $c ]")
        }
    }
}