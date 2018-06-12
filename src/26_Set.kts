val readOnlySet: Set<Int> = setOf(0, 1, 2)

val mutableSet: MutableSet<Int> = mutableSetOf(0, 1, 2)


mutableSet.add(3)
mutableSet.remove(0)


mutableSet.forEach {
    println(it)
}