package puzzles.p02

class PasswordUtils {
    companion object {
        private const val pattern = """(\d+)-(\d+) (.): (.+)"""
        private val regex = Regex(pattern)

        fun parseRange(s: String): IntRange {
            val (_, first, second) = getMatches(s)
            return first.toInt()..second.toInt()
        }

        fun parseFirst(s: String): Int {
            return getMatch(s, 1).toInt()
        }

        fun parseSecond(s: String): Int {
            return getMatch(s, 2).toInt()
        }

        fun parseChar(s: String): Char {
            val third = getMatch(s, 3)
            return third.toCharArray()[0]
        }

        fun parsePassword(s: String): String {
            return getMatch(s, 4)
        }

        private fun getMatches(s: String): List<String> {
            return regex.matchEntire(s)?.groupValues
                ?: throw IllegalArgumentException("Provided value [ $s ] does not match pattern [ $pattern ]")
        }

        private fun getMatch(s: String, index: Int): String {
            return getMatches(s)[index]
        }
    }
}