package puzzles.p07

class BagOrganizer {
    private val bagsByType = HashMap<String, Bag>()

    fun add(r: BagTypeRelationship) {
        val container = getBag(r.container)
        val contained = getBag(r.contained)
        container.addContains(contained, r.qty)
    }

    fun findContainers(type: String): Set<String> {
        val result = HashSet<String>()
        val containedBy = getBag(type).containedBy
        result.addAll(containedBy.map { x -> x.type })
        for (b in containedBy) {
            if (b.containedBy.map { x -> x.type }.containsAll(result)) continue // prevent infinite recursion
            result.addAll(findContainers(b.type))
        }
        return result
    }

    fun calculateInnerBags(type: String): Int {
        var result = 0
        val container = getBag(type)
        container.contains.forEach() { (b, qty) ->
            result += qty
            if (b.contains.size > 0) result += (calculateInnerBags(b.type) * qty)
        }
        return result
    }

    private fun getBag(type: String): Bag {
        return bagsByType.getOrPut(type) { -> Bag(type) }
    }
}