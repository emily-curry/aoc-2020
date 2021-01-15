package puzzles.p07

import lib.input.InputReader
import lib.runner.PuzzleId
import lib.runner.PuzzleRunner

@PuzzleId("07")
class Puzzle07(input: InputReader) : PuzzleRunner(input) {
    private val organizer = BagOrganizer()

    override fun run() {
        val relationships = input.toStringList().flatMap { s -> s.toBagTypeRelationship() }
        relationships.forEach() { r -> organizer.add(r) }
        val containers = organizer.findContainers("shiny gold")
        println("Part 1: Containers that could hold shiny gold bag: [ ${containers.size} ]")
        val contains = organizer.calculateInnerBags("shiny gold")
        println("Part 2: Shiny gold bag contains: [ $contains ]")
    }
}