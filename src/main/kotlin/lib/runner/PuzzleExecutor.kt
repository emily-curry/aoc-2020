package lib.runner

import lib.input.InputReader
import lib.input.InputReaderImpl
import org.reflections.Reflections

class PuzzleExecutor {
    private val ref = Reflections("puzzles")

    fun run(puzzleId: String): Unit {
        val runnerClass = this.getRunner(puzzleId)
        val input = InputReaderImpl(puzzleId)
        val runner = runnerClass.getDeclaredConstructor(InputReader::class.java).newInstance(input)
        runner.run()
    }

    private fun getRunner(puzzleId: String): Class<out PuzzleRunner> {
        return ref.getSubTypesOf(PuzzleRunner::class.java)
            .firstOrNull { x -> x.getAnnotation(PuzzleId::class.java).id == puzzleId }
            ?: throw IllegalArgumentException("No puzzle runner could be resolved with id [ $puzzleId ]. Might be missing a @PuzzleId annotation.")
    }
}