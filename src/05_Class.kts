/**
 * 생성자를 통해 값을 입력받는것과 동시에 전역변수로 할당된다.
 * 생성자 오버로드 메소드를 정의할 수 있으며, 이 경우 메소드의 리턴 타입으로 this(최상위 생성자)를 호출해야 한다.
 * 디폴트 생성자에는 메소드 바디가 없기 때문에 init {...} 구문을 통해 정의한다.
 * 오버로드 생성자는 메소드 바디를 가질 수 있으며, init {...} 구문 이후 실행된다. (다만 init에서 한번에 초기화 하는게 좋다는 의견)
 */
class ClassName (private var strValue: String = "strValue", private var intValue: Int = 0) {

    public constructor(strValue: String) : this(strValue, 0);
    public constructor(intValue: Int) : this("strValue", intValue);

    init {
        testFun();

        testFun(strValue);
        testFun(strValue, intValue);

        testFun(strValue = strValue);
        testFun(intValue = intValue);
    }

    public fun testFun(strValue: String = this.strValue, intValue: Int = this.intValue) {
        println(strValue);
        println(intValue);
    }

}

//val classA = ClassName();
//val classB = ClassName("seokchan.kwon");
val classC = ClassName("seokchan.kwon", 21);