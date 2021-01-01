package puzzles.p03

class SlopeMap(val map: Array<Array<SlopeMapCell>>) {
    var position = Pair(0, 0); private set
    val width = map.size
    val height = map[0].size

    fun navigate(x: Int, y: Int) {
        position = Pair(position.first + x, position.second + y)
    }

    fun getCurrentLocationType(): SlopeMapCell {
        val x = position.first % width
        val y = position.second // clamp?
        return map[x][y]
    }

    fun isOutOfBounds(): Boolean {
        return position.second >= height
    }
}