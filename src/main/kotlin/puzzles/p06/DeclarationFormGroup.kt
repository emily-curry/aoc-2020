package puzzles.p06

typealias DeclarationFormAggregator = Iterable<DeclarationForm>.((DeclarationForm) -> Boolean) -> Boolean

class DeclarationFormGroup(private val forms: Collection<DeclarationForm>) {
    private fun aggGroupAnswers(
        value: Boolean,
        aggFn: DeclarationFormAggregator
    ): Map<Char, Boolean> {
        return ('a'..'z')
            .map { c -> Pair(c, aggFn.invoke(forms) { f -> f.get(c) == value }) }
            .toMap()
    }

    private fun sumGroupAnswers(value: Boolean, aggFn: DeclarationFormAggregator): Int {
        return this.aggGroupAnswers(value, aggFn).filterValues { v -> v }.size
    }

    fun sumGroupAnswersAny(value: Boolean): Int {
        return this.sumGroupAnswers(value, Iterable<DeclarationForm>::any)
    }

    fun sumGroupAnswersEvery(value: Boolean): Int {
        return this.sumGroupAnswers(value, Iterable<DeclarationForm>::all)
    }
}