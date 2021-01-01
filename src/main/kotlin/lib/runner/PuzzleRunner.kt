package lib.runner

import lib.input.InputReader

abstract class PuzzleRunner(protected val input: InputReader) {
    abstract fun run(): Unit
}