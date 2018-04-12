/**
 * 함수 확장
 * 주의사항
 *  1. 확장된 함수보다 기존에 존재한 함수의 우선순위가 높다.
 */

fun functionA(): Int {
    return 10;
}

fun functionB(): Int = 100;

fun functionC() = 1_000;

fun functionD() {
    println("return type = Unit")
    return;
}

fun functionE(age: Int = 21, name: String = "seokchan.kwon", email: String) {
    println(age);
    println(name);
    println(email);
}

fun Int.increase(): Int = this + 1;
fun Int.sum(value: Int): Int = this + value;
infix fun Int.minus(value: Int): Int = this - value;

println(functionA());
println(functionB());
println(functionC());

functionD();

functionE(email = "chan4147@gmail.com");
functionE(18, email = "seokchan.dev@gmail.com", name = "seokchan.kwon");

println(100.sum(50));
println(100 minus 50 minus 25);
println(200.increase());


