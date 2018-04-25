/**
 * 상속
 * abstract와 interface는 기본적으로 public이며, 그 외에는 전부 private다.
 * private이기 때문에 일반적으로는 override가 불가능 하며, open 키워드를 통해 public으로 정의할 수 있다.
 */
abstract class AbstractBase(var age: Int) {

    open lateinit var strValue: String;

    abstract val abstractValue: String;

    abstract fun moreThan10YearsOld(): Boolean;
    open fun moreThan20YearsOld(): Boolean = this.age > 20

    open fun testMethod(): Boolean = true;
}

interface InterfaceBase {
    val thisYear: Int;

    fun moreThan30YearsOld(): Boolean;

    fun getThisYear(): Int {
        return thisYear;
    }

    fun testMethod(): Boolean = false;
}

open class Customer(age: Int) : AbstractBase(age), InterfaceBase {

    override val thisYear: Int = 2014;
    override var strValue: String = "strVariable";
    override val abstractValue: String = "abstractValue";

    val testValue: Int;

    init {
        val intValue: Int = 10;
        testValue = if (intValue % 2 == 0) {
            0
        } else {
            1
        }
    }

    override fun moreThan10YearsOld(): Boolean = this.age > 10;
    override fun moreThan20YearsOld(): Boolean = !super.moreThan20YearsOld();
    override fun moreThan30YearsOld(): Boolean = this.age > 30;
    open fun moreThan40YearsOld(): Boolean = this.age > 40;

    override fun getThisYear(): Int {
        val thisYear: Int = super.getThisYear();
        println(thisYear);
        return thisYear;
    }

    override fun testMethod(): Boolean {
        return super<InterfaceBase>.testMethod();
    }
}

class User(age: Int) : Customer(age) {
    override fun moreThan40YearsOld(): Boolean = !super.moreThan40YearsOld();
}

val useBase: User = User(21);
println(useBase.age);
println(useBase.moreThan10YearsOld());
println(useBase.moreThan20YearsOld());
println(useBase.moreThan30YearsOld());
println(useBase.moreThan40YearsOld());
println(useBase.getThisYear());