package puzzles.p07

val containerRegex = Regex("""(.*?) bags?.*""")
val containedRegex = Regex("""(\d) ([a-z\s]+) bags?\.?""")

fun CharSequence.toBagTypeRelationship(): Collection<BagTypeRelationship> {
    if (this.contains("no other")) return HashSet()
    val containerType =
        containerRegex.matchEntire(this)?.groupValues?.get(1) ?: throw IllegalArgumentException(this.toString())
    val containedTypes = this.split("contain ")[1].split(", ")
        .map { s ->
            val m = containedRegex.matchEntire(s)?.groupValues ?: throw IllegalArgumentException(s)
            Pair(m[1].toInt(), m[2])
        }
    return containedTypes.map { p -> BagTypeRelationship(containerType, p.second, p.first) }
}