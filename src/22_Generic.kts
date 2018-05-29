interface Generic<T> {

    fun setItem(item: T);

    fun getItem(): T;

}

class Sample : Generic<String> {

    var strVariable: String? = null

    override fun getItem(): String {
        return this.strVariable ?: "";
    }

    override fun setItem(item: String) {
        strVariable = item
    }

    fun genericFunction(list: List<*>) {
        for ((index, item) in list.withIndex()) {
            println("index=$index, item=$item");
        }
    };

    fun <T> genericFunction(): MutableList<T> = mutableListOf();

    fun <T> genericFunction(item: T): T {
        return item;
    }

    fun <T, E> genericFunction(item1: T, item2: E) {
        println(item1);
        println(item2);
    }
}


val sample: Sample = Sample();

sample.setItem("generic test")

sample.genericFunction<Int>();

val g1: Int = sample.genericFunction(100);
println(g1);

sample.genericFunction(100, "String");

mutableListOf<String>().forEachIndexed { index, str ->
    println("$index $str")
}

val intList: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5);
val strList: MutableList<String> = mutableListOf("a", "b", "c");

sample.genericFunction(intList);
sample.genericFunction(strList);


