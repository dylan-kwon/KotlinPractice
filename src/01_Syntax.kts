/**
 * var: 변수
 * val: 상수
 * fun: 함수
 * for: 반복문 (for-in)
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
 * 1. naming: type 에서 콜론 뒤의 타입은 변수든 함수든 생략 가능하다.
 */

/**
 * 변수
 */
var strVariable: String = "strVariable";

/**
 * 상수
 */
val strValue: String = "strValue";


/**
 * 함수
 */
fun getVar(): String {
    return strVariable;
}


/**
 * 함수 리턴 축약형
 */
fun getVal(): String = strValue;


/**
 * 반복문
 */
for (item in getVar()) {
    print("charAp($item)");
}

