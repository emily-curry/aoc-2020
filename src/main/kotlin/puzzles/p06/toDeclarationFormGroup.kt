package puzzles.p06

fun CharSequence.toDeclarationFormGroup(): DeclarationFormGroup {
    val forms = this.lines().map { line -> line.toDeclarationForm() }
    return DeclarationFormGroup(forms);
}