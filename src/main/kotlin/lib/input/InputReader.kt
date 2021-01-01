package lib.input

interface InputReader {
    fun toStringList(): List<String>

    fun toIntList(): List<Int>
}