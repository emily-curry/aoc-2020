package puzzles.p05

data class Ticket(val row: Int, val column: Int) {
    val id = (row * 8) + column
}