fun test(a: Int, b: Int) {
    val max: Int;
    val min: Int;

    if (a > b) {
        max = a;
        min = b;
    } else {
        max = b;
        min = a;
    }

    println(a);
    println(b);
    println(max);
    println(min);
}

fun whenTest(value: Any) {
    when (value) {
        is Int -> {
            when (value) {
                in 0..100 -> {
                    println("${value}는 0~100 사이의 숫자다.")
                }
                else -> {
                    println("${value}는 0~100 사이의 숫자가 아니다.")
                }
            }
        }
        is String -> {
            println("${value}는 String이다.")
        }
        else -> {
            println("${value}의 타입이 String과 Int 모두 아니다.")
        }
    }
}

fun isString(value: Any): Boolean = when (value) {
    is Int -> false
    is String -> true
    else -> false
}

test(10, 20);

whenTest(100);
whenTest(1000);
whenTest("가나다라마바사");
whenTest(100L);

println("10 isString: ${isString(10)}");
println("\"동해물과 백두산이\" isString: ${isString("동해물과 백두산이")}");

val strValue: String = "ABC";

for (item in strValue) {
    println("item = $item")
}

for (indices in strValue.indices) {
    println("indices = $indices")
}

for ((indices, item) in strValue.withIndex()) {
    println("indices = $indices // item = $item")
}

for (value in 0..10 step 2) {
    print("$value")
    if (value == 10) {
        break;
    }
    print(", ")
}

val map: MutableMap<Int, String> = mutableMapOf(
        1 to "first",
        2 to "second",
        3 to "third"
);

for (value in map.keys) {
    println("value = $value");
}

for (value in map.values) {
    println("value = $value");
}

for ((key, value) in map) {
    println("key = $key // value = $value");
}