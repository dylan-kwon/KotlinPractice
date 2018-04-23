val intValue: Int = 10;
val longValue: Long = intValue.toLong();
val strValue: String = longValue.toString();

println(intValue);
println(longValue);
println(strValue);

val a: Any = "ABC";
val b: String = a as String;
val c: Int? = a as? Int;
val d: Int = a as? Int ?: 0;

println("a = $a");
println("b = $b");
println("c = $c");
println("d = $d");


val e: Any = 10L;
val f: Any = when (e) {
    is Int -> {
        e as String
    }
    is Long -> {
        e
    }
    else -> {
        "nothing"
    }
}
println(f);

val test: String = when ("".length > 10) {
    is Boolean -> {
        "test"
    }
    else -> {
        ""
    }
}