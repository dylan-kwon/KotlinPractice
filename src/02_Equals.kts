/**
 * (=): 대입
 * (==): 값 비교
 * (===): 메모리 비교
 */

val intValueA: Int = 10_000;
val intValueB: Int? = intValueA;
val intValueC: Int? = intValueA;

println(intValueA == 10_000);

println(intValueA == intValueA);
println(intValueA === intValueA);

println(intValueA == intValueB);
println(intValueA === intValueB);

println(intValueA == intValueC);
println(intValueA === intValueC);

println(intValueB == intValueC);
println(intValueB === intValueC);