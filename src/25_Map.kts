val readOnlyMap: Map<String, Int> = mapOf(
        "first" to 1,
        "second" to 2,
        "third" to 3
);

readOnlyMap["first"]

readOnlyMap.get("two")

readOnlyMap.getOrDefault("four", 0)

readOnlyMap.getOrElse("five", {
    10
})




val mutableMap: MutableMap<String, Int> = mutableMapOf(
        "first" to 1,
        "second" to 2,
        "third" to 3
);

mutableMap["first"]
mutableMap.get("two")

mutableMap["key"] = 100
mutableMap.put("key", 100)

mutableMap.remove("key")

//mutableMap["four"] ?: 10

mutableMap.getOrElse("five", {
    10
})

mutableMap.getOrDefault("six", 10)


mutableMap -= "first"
mutableMap += "five" to 5

mutableMap.forEach { k, v ->
    println("$k = $v")
}

