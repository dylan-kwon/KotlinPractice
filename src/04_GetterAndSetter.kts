class Sample<T> {

    var list: List<T> = mutableListOf()
        set(value) {
            if (value.isNotEmpty()) {
                field = value;
            }
        }

    val isEmpty: Boolean
        get() = this.list.isEmpty();

}

val sample: Sample<String> = Sample();

