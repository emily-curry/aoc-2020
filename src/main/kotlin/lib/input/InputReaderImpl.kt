package lib.input

import java.io.File

internal class InputReaderImpl(puzzleId: String) : InputReader {
    val rawText: String;

    init {
        val f = File(ClassLoader.getSystemResource("input/${puzzleId}.txt").file)
        rawText = f.readText()
    }

    override fun toString(): String {
        return rawText
    }

    override fun toStringList(): List<String> {
        return rawText.split("\n")
    }

    override fun toIntList(): List<Int> {
        return toStringList().map { x -> x.toInt() }
    }

    override fun toLongList(): List<Long> {
        return toStringList().map { x -> x.toLong() }
    }
}