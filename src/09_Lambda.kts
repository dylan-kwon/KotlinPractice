class Button {

    private var mOnClickListener: OnClickListener? = null;

    public fun setOnClickListener(listener: OnClickListener?) {
        this.mOnClickListener = listener;
    }

    public fun onClick() {
        this.mOnClickListener?.onClick("onClick");
    }

    public interface OnClickListener {
        fun onClick(strValue: String);
    }

}


class Activity {

    val button: Button by lazy {
        Button();
    }

    init {
        onCreate();
    }

    private fun onCreate() {
        button.onClick();
    }

}

Activity();

val list: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

list.filter {
    it % 2 == 0;

}.map {
    it * 10;

}.forEachIndexed { index, value ->
    println("index = $index // value = $value");
}


val map: MutableMap<Int, String> = mutableMapOf(
        1 to "first",
        2 to "second",
        3 to "third"
);

map.forEach {
    println("key = ${it.key} // value = ${it.value}");
}