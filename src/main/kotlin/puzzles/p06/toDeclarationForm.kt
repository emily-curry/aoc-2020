package puzzles.p06

fun CharSequence.toDeclarationForm(): DeclarationForm {
    val map = HashMap<Char, Boolean>();
    for (char in 'a'..'z') {
        map[char] = this.contains(char, true)
    }
    return DeclarationForm(map);
}