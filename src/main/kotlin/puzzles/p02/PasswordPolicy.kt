package puzzles.p02

interface PasswordPolicy {
    fun test(password: String): Boolean
}