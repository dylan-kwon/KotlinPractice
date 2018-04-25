class CompanionObject {

    val mName: String = "name";

    companion object {

        const val type: Int = 0;

        fun getType(): Int = type;

        fun isTypeZero(): Boolean = type == 0;


    }
}

println(CompanionObject.getType());
println(CompanionObject.isTypeZero());