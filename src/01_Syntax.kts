/**
 * var: 변수
 * val: 상수
 *
 * fun: 함수
 *      함수 선언 시, 기본값을 선언할 수 있다.
 *      기본값이 선언된 매개변수의 경우 인자값을 생략할 수 있다.
 *      첫 번째 매개변수는 기본값이 선언되었고, 두 번째 매개변수에는 기본값이 선언되지 않은 경우,
 *          함수를 호출할 때 첫번째 인자를 생략하고 두번째 인자만 넣은 경우 에러를 발생한다. (코틀린에서 인자와 매개변수의 순서는 같아야 하기 때문이다.)
 *          해결 방법은 (매개변수명 = 인자) 문법을 사용해서 직접 매개변수를 지정하는 것이다.
 *
 * for: 반복문 (for-in)
 *
 * $ or ${}: 스트링 템플릿
 *      val str: String = "A";
 *      print("char($str)");
 *      위 코드의 실행 결과는 "char(A)" 이다.
 *      {}가 없는 경우는 변수명 까지만 허용한다.
 *      {}를 사용하는 경우 중괄호 내 스코프에서 kotlin 구문을 실행할 수 있다.
 *          (ex) ${str.length}
 *      $ 그 자체를 출력하고 싶은 경우
 *          1. 뒤에 변수가 붙지 않는 경우 그냥 사용한다.
 *          2.수가 붙는 경우 $를 한번 더 사용한다.
 *
 * !!: non-null을 의미
 *
 * ?:   변수 타입 뒤에 사용한 경우 => 해당 변수는 Nullable하다는 것을 명시.
 *      변수명 뒤에 사용한 경우 => null safety 체크
 *
 * Any: 변수 타입 중 하나로써 어떠한 타입도 허용한다는 의미를 갖는다.
 *      Java의 Object 타입에 해당
 *      String으로 초기화된 변수에 Int값을 넣는 등
 *
 * Nothing: 변수 타입 중 하나로써 어떠한 타입도 허용하지 않는다는 의미를 갖는다.
 *      Java의 Void 타입에 해당
 *
 * lazy: 늦은 초기화 (호출 시점에 초기회가 이루어진다.)
 *      val과 같이 사용된다.
 *      var은 불가능. (lateInit을 사용해야 한다.)
 *      getter/setter 사용이 불가능하다.
 *
 * lateinit: lazy와 마찬가지로 늦은 초기화 키워드다.
 *      var과 같이 사용된다.
 *      val은 불가능 (lazy를 사용해야 한다.)
 *      null을 허용하지 않는다.
 *      getter/setter 사용이 불가능하다.
 *
 * constructor: Class의 생성자 키워드이다.
 *      Default 생성자의 경우 생략 가능하다.
 *      Overload 생성장의 경우 생략이 불가능하며 리턴으로 디폴트 생성자를 호출해야 한다.
 *      생성자의 인자로 넘긴 값은 전역 변수로 사용 가능하다. (이곳에서만 변수에 접근제한자(public, private 등)과 var, val 등을 지정할 수 있다.)
 *
 * init { ... }: Class의 생성자 호출 이후 초기화 작업이 진행되는 곳이다.
 *               디폴트 생성자 메소드는 기본적으로 { ... } 구문이 없다. (뒤의 { ... }는 Class의 몸체다.)
 *               따라서 init { ... }은 디폴트 생성자의 메소드 바디 역할을 한다.
 *               오버로드 생성자 바디와의 우선순위는 init { ... } 호출 후 오버라이드 생성자
 *               하지만 init{ ... } 에서 한번에 처리하는게 좋음
 *
 * open: Kotlin에서 Abstract와 Interface를 제외한 모든 클래스는 기본적으로 Final이다.
 *       open 키워드를 사용해서 final 하지 않게 만들 수 있다.
 *
 * 1. naming: type 에서 콜론 뒤의 타입은 변수든 함수든 생략 가능하다.
 */

/**
 * 변수
 */
var strVariable: String = "strVariable";

/**
 * 상수
 */
val strValuable: String = "strValuable";


/**
 * 함수
 */
fun getVar(): String {
    return strVariable;
}


/**
 * 함수 리턴 축약형
 */
fun getVal(): String = strValuable;


/**
 * 반복문
 */
for (item in getVar()) {
    println("char($item)");
}


/**
 * Nullable
 */
var nullableValue: String? = null;


/**
 * Non-Null
 */
nullableValue = "Non-Null"
println(nullableValue!!.length);


/**
 * Null-safety
 */
nullableValue = null;
println(nullableValue?.length);


/**
 * Nothing
 */
val nothingValue: Nothing? = null;
// nothingValue = "1"; ==> Error.


/**
 * Any
 */
var anyVariable: Any? = null;
anyVariable = "A";
anyVariable = 10;
println(anyVariable);


/**
 * lazy
 */
val lazyValue: String by lazy {
    "lazy value"
}
println(lazyValue);


/**
 * lateInit
 */
lateinit var lateInitVariable: String;
lateInitVariable = "lateInit variable"
println(lateInitVariable);



