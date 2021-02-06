package puzzles.p09

class XmasParser(private val data: List<Long>) {
    private var cursor: Int = 0
    private val upperBound: Int
        get() = if (this.cursor + 25 >= data.lastIndex) data.lastIndex else this.cursor + 25
    private val window: List<Long>
        get() = this.data.slice(this.cursor..this.upperBound)
    val target: Long
        get() = this.data[this.upperBound + 1]

    fun step() {
        cursor++;
    }

    fun isCurrentTargetValid(): Boolean {
        for (i in cursor..upperBound - 1) {
            for (k in i + 1..upperBound) {
                if (this.data[i] + this.data[k] == target) return true;
            }
        }
        return false
    }
}