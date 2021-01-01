package puzzles.p02

class CharacterFrequencyPasswordPolicy(private val validFrequency: IntRange, private val character: Char) :
    PasswordPolicy {
    constructor(raw: String) : this(PasswordUtils.parseRange(raw), PasswordUtils.parseChar(raw))

    override fun test(password: String): Boolean {
        val filtered = password.toCharArray().filter { c -> c == character }
        return validFrequency.contains(filtered.size)
    }
}