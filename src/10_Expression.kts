loopI@ for (i in 1..10) {
    loopJ@ for (j in 1..100) {
        if (j == 10) {
            println();
            break@loopJ;
        }
        print("$j ");
    }
}

val mutableList: MutableList<Int> = mutableListOf(0, 1, 2, 3, 4, 5);
mutableList.forEach {
    if (it == 3) {
        return@forEach;
    }

    print(it);

    if (it == 5) {
        println();
    }
}

class SampleA {

    val mSampleB: SampleB by lazy {
        SampleB();
    }

    inner class SampleB {

        fun Int.foo() {
            val a = this@SampleA;
            val b = this@SampleB;
            val c = this;
            val d = this@foo;
            println("a.hashcode = ${a.hashCode()}");
            println("b.hashcode = ${b.hashCode()}");
            println("c.hashcode = ${c.hashCode()}");
            println("d.hashcode = ${d.hashCode()}");
        }

        fun test(a: Int) {
            a.foo();
            println("e.hashcode = ${this.hashCode()}")
        }
    }

    fun test() {
        mSampleB.test(0);
        println("f.hashcode = ${this.hashCode()}");

        val mutableList: MutableList<Int> = mutableListOf(1);
        mutableList.forEach {
            println("g.hashcode = ${this.hashCode()}");
        }
    }
}

val sampleA: SampleA = SampleA();
sampleA.test();