import com.sun.org.apache.bcel.internal.classfile.InnerClass

class OuterClass {

    val outerValue: Int = 10;
    val innerClass: InnerClass = InnerClass();
    val staticInnerClass: StaticInnerClass = StaticInnerClass();

    private fun callFromInner() {
        println("call from inner class");
    }

    fun printOuterValue() {
        println(outerValue);
        innerClass.printInnerClassValue();
        staticInnerClass.printStaticInnerValue();
    }

    class StaticInnerClass {
        val staticInnerValue: Int = 100;

        fun printStaticInnerValue() {
            println(staticInnerValue);
        }
    }

    inner class InnerClass {
        val innerClassValue: Int = 10000;

        fun printInnerClassValue() {
            callFromInner();
            println(innerClassValue);
        }
    }

}

val outerClass: OuterClass = OuterClass();
val staticInnerClass: OuterClass.StaticInnerClass = OuterClass.StaticInnerClass();

outerClass.printOuterValue();

println("");

outerClass.innerClass.printInnerClassValue();

println("");
outerClass.staticInnerClass.printStaticInnerValue();

println("");

staticInnerClass.printStaticInnerValue();

println();

