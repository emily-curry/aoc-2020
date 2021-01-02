package lib.input

interface InputReader {
    override fun toString(): String

    fun toStringList(): List<String>

    fun toIntList(): List<Int>
}