package puzzles.p05

import java.math.BigInteger

fun CharSequence.toBinarySpaceInt(): Int {
    if (this.isEmpty()) return 0
    val codes = this.map { c -> c.toBinarySpaceCode() }
    var lower = 0
    var upper = BigInteger.valueOf(2).pow(this.length).toInt() - 1
    for ((i, c) in codes.withIndex()) {
        val step = BigInteger.valueOf(2).pow(this.length - i - 1).toInt()
        when (c) {
            BinarySpaceCode.LOWER -> upper -= step
            BinarySpaceCode.UPPER -> lower += step
        }
    }
    if (lower != upper) throw IllegalStateException("Bad math: Lower [ $lower ], Upper [ $upper ], should be equal")
    return lower
}