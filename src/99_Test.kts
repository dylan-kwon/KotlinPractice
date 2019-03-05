open class A(open var i: Int = 1)

data class B(
        override var i: Int,
        val s: String = ""


) : A()


val b1: B = B(0, "")
val b2: B = B(0, "")


println("b1 == b2: ${b1 == b2}")