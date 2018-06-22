class CompanionObject {

    val mName: String = "name";

    companion object {

        const val type: Int = 0;

        fun getType(): Int = type;

        fun isTypeZero(): Boolean = type == 0;

    }

    class Extra {
        companion object {
            val ID = "Activity.Extra.id";
        }
    }
}

println(CompanionObject.getType());
println(CompanionObject.isTypeZero());
println(CompanionObject.Extra.ID);