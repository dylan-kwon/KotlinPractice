open class Button {

    private var mOnClickListener: OnClickListener? = null;

    fun setOnClickListener(l: OnClickListener?) {
        this.mOnClickListener = l;
    }

    fun onClick() {
        mOnClickListener?.onClick();
    }

    interface OnClickListener {
        fun onClick()
    }

}

val button: Button = Button();

button.setOnClickListener(object : Button.OnClickListener {
    override fun onClick() {
        println("onClick!!");
    }
});

button.onClick();