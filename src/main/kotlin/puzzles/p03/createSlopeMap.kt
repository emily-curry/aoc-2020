package puzzles.p03

fun createSlopeMap(lines: List<String>): SlopeMap {
    val width = lines[0].length
    val grid = Array(width) { x ->
        Array(lines.size) { y -> SlopeMapCell.getByChar(lines[y][x]) }
    }
    return SlopeMap(grid)
}