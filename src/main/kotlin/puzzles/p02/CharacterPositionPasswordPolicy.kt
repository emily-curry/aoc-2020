package puzzles.p02

class CharacterPositionPasswordPolicy(private val positions: Collection<Int>, private val character: Char) :
    PasswordPolicy {
    constructor(raw: String) : this(
        List(
            2
        ) { i -> if (i == 0) PasswordUtils.parseFirst(raw) else PasswordUtils.parseSecond(raw) },
        PasswordUtils.parseChar(raw)
    )

    override fun test(password: String): Boolean {
        var atPosition = 0
        for (pos in positions) {
            val s = pos - 1;
            if ((0..password.lastIndex).contains(s) && password[s] == character) atPosition++
        }
        return atPosition == 1
    }
}