sealed class Sample(val intValue: Int) {

    fun printIntValue() {
        println(this.intValue);
    }

    abstract fun printStrValue();

    class A(val strValue: String) : Sample(100) {

        fun sampleAFunction() {
            println("this is Sample.A!!");
        }

        override fun printStrValue() {
            println(this.strValue);
        }

    }

    data class B(val strValue: String) : Sample(1_000) {

        fun sampleBFunction() {
            println("this is Sample.B!!");
        }

        override fun printStrValue() {
            println(this.strValue);
        }

    }

    object C : Sample(1_000_000) {

        fun sampleCFunction() {
            println("this is Sample.C!!");
        }

        override fun printStrValue() {
            println("sampleC");
        }

    }

}

val sampleA: Sample.A = Sample.A("sampleA");
val sampleB: Sample.B = Sample.B("sampleB");
val sampleC: Sample.C = Sample.C;

val sample: Sample = sampleB;

when (sample) {
    is Sample.A -> {
        sample.sampleAFunction();
        sample.printIntValue();
        sample.printStrValue();
    }
    is Sample.B -> {
        sample.sampleBFunction();
        sample.printIntValue();
        sample.printStrValue();
    }
    is Sample.C -> {
        sample.sampleCFunction();
        sample.printIntValue();
        sample.printStrValue();
    }
}