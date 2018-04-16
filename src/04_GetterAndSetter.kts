/**
 * 코틀린은 자동으로 var 혹은 val에 대한 getter/setter가 생성된다.
 * 자동으로 생성되는 getter/setter를 수정할 수 있다.
 * getter/setter 함수 내부에선 field 키워드로 값에 접근할 수 있다.
 *
 */
class Sample<T> {

    var list: List<T> = mutableListOf()
        set(value) {
            if (value.isNotEmpty()) {
                field = value;
            }
        }
        get() = field

    val isEmpty: Boolean
        get() = this.list.isEmpty();

}

val sample: Sample<String> = Sample();

