package lib.input

import assertk.assertThat
import assertk.assertions.containsExactly
import assertk.assertions.isEqualTo
import assertk.assertions.isNotNull
import kotlin.test.Test

class InputReaderTest {
    private val puzzleId = "test-input"

    @Test
    fun inputReader_initializesWithoutError() {
        val reader = InputReaderImpl(puzzleId)
        assertThat(reader).isNotNull()
    }

    @Test
    fun inputReader_rawInputMatchesExactly() {
        val reader = InputReaderImpl(puzzleId)
        assertThat(reader.rawText).isEqualTo(
            """
            1706
            1466
            1427
            1744
            1684
            """.trimIndent()
        )
    }

    @Test
    fun inputReader_readInputToString_returnsStringList() {
        val reader = InputReaderImpl(puzzleId)
        val input = reader.toStringList()
        assertThat(input).containsExactly("1706", "1466", "1427", "1744", "1684")
    }

    @Test
    fun inputReader_readInputToInt_returnsIntList() {
        val reader = InputReaderImpl(puzzleId)
        val input = reader.toIntList()
        assertThat(input).containsExactly(1706, 1466, 1427, 1744, 1684)
    }
}