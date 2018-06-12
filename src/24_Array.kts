val strArrayOf: Array<String> = arrayOf("a", "b", "c")

val intArrayOf: IntArray = intArrayOf(0, 1, 2)

val booleanArrayOf: BooleanArray = booleanArrayOf(true, false);


println("strArrayOf[0] = ${strArrayOf[0]}")
println("intArrayOf[1] = ${strArrayOf[1]}")
println("booleanArrayOf[1] = ${booleanArrayOf[1]}")



val mutableList: MutableList<Int> = mutableListOf(0, 1, 2);

mutableList[0]
mutableList.get(0)

mutableList[1] = 20
mutableList.set(1, 20)

mutableList += 100
mutableList.add(100)


mutableList.remove(200)

mutableList.size


mutableList.forEach {
    println(it);
}



val readOnlyList: List<Int> = listOf(0, 1, 2);

// 아이템 접근
readOnlyList[0]
readOnlyList.get(0)

// 배열의 사이즈 가져오기
readOnlyList.size