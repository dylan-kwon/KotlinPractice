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