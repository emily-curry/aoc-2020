package puzzles.p07

class Bag(val type: String) {
    val contains = HashMap<Bag, Int>()
    val containedBy = HashSet<Bag>()

    fun addContains(bag: Bag, qty: Int) {
        contains[bag] = qty
        bag.containedBy.add(this)
    }
}