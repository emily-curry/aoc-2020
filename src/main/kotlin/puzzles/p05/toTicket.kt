package puzzles.p05

fun String.toTicket(): Ticket {
    if (this.length != 10) throw IllegalArgumentException("Ticket length must be exactly 10")
    val row = this.subSequence(0..6).toBinarySpaceInt()
    val column = this.subSequence(7..9).toBinarySpaceInt()
    return Ticket(row, column)
}