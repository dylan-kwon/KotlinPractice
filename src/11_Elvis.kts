fun getSizeA(string: String?): Int? = string?.length;
fun getSizeB(string: String?): Int = string?.length ?: 0;

println(getSizeA(null) ?: "getSizeA('null') is null");
println(getSizeB(null));

open class Sample(val id: Int?, val name: String?, val age: Int?);

val sampleA: Sample? = null;
val sampleB: Sample? = Sample(0, null, 20);
val sampleC: Sample? = Sample(1, "seokchan.kwon", 21);

sampleA?.let {
    println("id = " + it.id);
    println("name = " + it.name);
    println("age = " + it.age);

} ?: let {
    println("sampleA is null!!");
}

sampleB?.let {
    println("sampleB.id = " + it.id);
    println("sampleB.name = " + (it.name ?: "name is null!!"));
    println("sampleB.age = " + it.age);

} ?: let {
    println("sampleB is null!!");
}