package puzzles.p05

import lib.input.InputReader
import lib.runner.PuzzleId
import lib.runner.PuzzleRunner

@PuzzleId("05")
class Puzzle05(input: InputReader) : PuzzleRunner(input) {
    override fun run() {
        val tickets = input.toStringList().map { x -> x.toTicket() }
        val maxTicketId = tickets.maxOf { x -> x.id }
        println("Part 1: Max ticket id [ $maxTicketId ]")
        val sorted = tickets.sortedBy { t -> t.id }
        for (i in 0..sorted.lastIndex) {
            if (sorted[i].id == sorted[i + 1].id - 2) {
                println("Part 2: Ticket id [ ${sorted[i].id + 1} ]")
                break
            }
        }
    }
}