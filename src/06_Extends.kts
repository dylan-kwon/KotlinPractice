abstract class AbstractBase(var age: Int) {
    abstract fun moreThan10YearsOld(): Boolean;
}

interface InterfaceBase {
    fun moreThan20YearsOld(): Boolean;
}

open class Customer(age: Int) : AbstractBase(age), InterfaceBase {
    override fun moreThan10YearsOld(): Boolean = this.age > 10;
    override fun moreThan20YearsOld(): Boolean = this.age > 20;
    open fun moreThan30YearsOld(): Boolean = this.age > 30;
}

class User(age: Int) : Customer(age) {
    override fun moreThan30YearsOld(): Boolean = !super.moreThan30YearsOld()
}

val useBase: User = User(21);
println(useBase.age);
println(useBase.moreThan10YearsOld());
println(useBase.moreThan20YearsOld());
println(useBase.moreThan30YearsOld());