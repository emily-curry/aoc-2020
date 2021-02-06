package puzzles.p08

import lib.input.InputReader
import lib.runner.PuzzleId
import lib.runner.PuzzleRunner

@PuzzleId("08")
class Puzzle08(input: InputReader) : PuzzleRunner(input) {

    override fun run() {
        val console = input.toStringList().toConsole()
        while (!console.isLooping()) {
            console.step()
        }
        val accumulatorAtLoopPoint = console.accumulator;
        println("Part 1: Value of accumulator at loop point was [ $accumulatorAtLoopPoint ]")

        val debugger = ConsoleDebugger(input.toStringList())
        val workingConsole = debugger.createWorkingConsole()
        val workingAccumulatorValue = workingConsole.accumulator
        println("Part 2: Value of accumulator at bootloader completion was [ $workingAccumulatorValue ]")
    }
}