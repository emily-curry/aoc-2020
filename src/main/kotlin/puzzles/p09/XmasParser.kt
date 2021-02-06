package puzzles.p09

class XmasParser(private val data: List<Long>) {
    private var cursor: Int = 0
    private val upperBound: Int
        get() = if (this.cursor + 25 >= data.lastIndex) data.lastIndex else this.cursor + 25
    private val window: List<Long>
        get() = this.data.slice(this.cursor..this.upperBound)
    private val target: Long
        get() = this.data[this.upperBound + 1]

    fun findInvalidTarget(): Long {
        while (this.isCurrentTargetValid()) {
            this.step()
        }
        return this.target
    }

    fun findContiguousSetForTarget(): List<Long> {
        for (startIndex in 0..upperBound) {
            for (endIndex in startIndex..upperBound) {
                val window = this.data.slice(startIndex..endIndex)
                val sum = window.sum()
                if (sum == target) return window
                else if (sum > target) break
            }
        }
        throw IllegalStateException("No contiguous set found for [ $target ]")
    }

    private fun step() {
        cursor++;
    }

    private fun isCurrentTargetValid(): Boolean {
        for (i in cursor until upperBound) {
            for (k in i + 1..upperBound) {
                if (this.data[i] + this.data[k] == target) return true;
            }
        }
        return false
    }
}