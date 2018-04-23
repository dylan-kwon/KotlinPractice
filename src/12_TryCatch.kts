val temp: String? = null;

try {
    println(temp!!.length);
} catch (e: NullPointerException) {
    println(e);
}

val size: Int = try {
    temp!!.length;
} catch (e: NullPointerException) {
    999
}

println(size);