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
 * {?:} : strVariable?.length;을 실행한 경우 strVariable이 null인 경우 exception이 발생하지 않고 'null'이 출력된다.
 *        strVariable?.length ?: 0; 다음과 같이 ?: {value};를 추가한 경우 null 대신 {value}가 출력된다.
 *
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
 * infix: 해당 키워드가 정의된 확장 함수를 사용할 때, 축약해서 사용이 기능하다.
 *        예) 10.sum(5) --> 10 sum 5 (.이 사라졌다.)
 *        다만 확장 함수의 매개변수가 하나일 경우에만 사용할 수 있다.
 *
 * intA..intB: IntRange 정의 (intA ~ intB를 포함)
 *
 * when: Java의 Switch문에 해당한다. (kotlin에는 switch가 존재하지 않는다.)
 *       else가 반드시 추가되어야 한다.
 *       when(value) {
 *          is String -> {
 *              ...
 *          }
 *          0 -> {
 *              ...
 *          }
 *          1, 2 -> {
 *              ...
 *          }
 *          !in 0..100 -> {
 *              ...
 *          }
 *          else -> {
 *              ...
 *       }
 *
 * is or !is: if와 같이 사용함. if(10 is Int)
 *            when과 같이 사용함. when의 비교 조건에 변수 타입이 있는 경우 is String -> {..}와 같이 사용 가능.
 *
 * in or !in: if와 같이 사용함. if(10 in 0..10)
 *            for와 같이 사용함 for(i in "name")
 *            when과 같이 사용함. when의 비교 조건에 IntRange가 있는 경우 in 1..10 -> {..}와 같이 사용 가능.
 *
 * it: Lambda식에서 single parameter를 대체하는 키워드.
 *
 * {naming}@ or @{naming}: 왼쪽이 선언, 오른쪽이 사용이다.
 *            this, return, break, continue 등을 사용할 때, 대상을 명시하는 것
 *            예를들어 이중포문이 있는데 이너 포문 i, j 중 j에서 break를 한 경우 Java는 j를 중단하고 다음 i를 실행하지만 loopI@를 정의하고 break@loopI를 선언한 경우 i를 break;한다.
 *
 * this: Java에서 사용하던 this와 같다. 다만 확장 함수의 경우 확장하는 객체를 가르킨다.
 *       func Int.foo() { this } Java의 경우 함수 내부의 this는 클래스를 가르키지만 Kotlin의 경우 Int를 가르킨다.
 *       람다식 안에서의 this는 인터페이스가 아닌 클래스를 가르킨다.
 *
 * try-catch: Java의 try-catch와 같다.
 *       다만 val value:any = { value } catch(exception) { value}; 로 변수 초기화가 가능하다. (if, when도 마찬가지로 가능하다.)
 *
 * as or as?: 형변환 키워드
 *     val object: Any = "string"
 *     val int: Int = object as Int;
 *     val string: String = object as String;
 *     위의 예시에서 int형 변환은 exception이 발생하게 된다. 따라서 아래와 같이 as?를 사용하여 안전한 형변환을 시도한다.
 *     val int: Int = object as? Int ?: 0;
 *
 * .let: null check 방법 중 하나. elvis 문법과 함께 사용하여 null일 경우를 처리할 수 있다.
 *       variable?.let {
 *          println(variable?.member ?: 0)
 *       } ?: let {
 *          println("variable is null")
 *       }
 *
 * @JvmOverloads constructor + class default 생성자 매개변수의 기본값 설정
 *       세컨더리 생성자를 정의하지 않아도 Java에서 호출 시 overload된 생성자가 자동으로 생성됨.
 *
 * override: 클래스의 함수 및 변수를 오버라이드 할 수 있다.
 *       override val ...
 *       override var ...
 *       override fun ...
 *
 * companion object { ... }: Java static처럼 클래스 변수 및 함수에 직접 접근할 수 있게 하는 키워드
 *      ClassName.variable;
 *      ClassName.function();
 *
 * sealed class:
 *      sealed 클래스는 private 생성자를 가진다.
 *      sealed 클래스는 Abstract 클래스다.
 *      sealed 클래스와 이를 상속받는 클래스는 하나의 파일 안에 정의되어야 한다.
 *      abstract 메소드를 정의할 수 있다.
 *      when과 같이 사용할 경우 when의 else 구문이 필요하지 않다.
 *
 * data class:
 *      JAVA POJO 클래스와 동일하다.
 *      생성자에 변수만 선언하면 자동으로 getter 및 setter와 toString, hasocode 까지 자동으로 정의해준다.
 *
 * inner class:
 *      JAVA InnerClass와 동일하다.
 *      inner 키워드 없이 class만 사용하여 정의한 경우 static innerClass가 생성된다
 *          따라서 내부 클래스에서 외부 클래스로의 참조는 불가능하다.
 *      외부 클래스에서 내부 클래스에 접근하려면 인스턴스를 생성해야 한다.
 *
 * object class: Kotlin에서 Singleton을 구현할 때 사용한다.
 *      생성자를 가질 수 없다.
 *
 * AnonymousInnerClass: 익명 클래스
 *      object: interface를 통해 정의할 수 있다.
 *
 *
 *
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


/**
 * when
 */
val a: Int = 30;
val range: IntRange = 10..19;

when (a) {
    1, 9 -> {
        println("$a = 1 or 9");
    }
    in range -> {
        println("$a = 10 .. 19");
    }
    !in 20..29 -> {
        println("$a = not 20 .. 29");
    }
    else -> {
        println("$a = not found");
    }
}