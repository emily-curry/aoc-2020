package puzzles.p06

class DeclarationForm(private val formAnswers: Map<Char, Boolean>) {
    fun get(answer: Char): Boolean {
        return formAnswers.getOrDefault(answer, false);
    }
}