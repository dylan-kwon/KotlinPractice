//import java.Button


// 아래는 Interface와 그 setter가 코틀린으로만 구현한 예제다.
class ImageButton {

    private var clickCount: Int = 0;
    private var onClickListener: OnClickListener? = null;

    public fun onClick() {
        this.onClickListener?.onClick(++clickCount);
    }

    public fun setOnClickListener(listener: OnClickListener?) {
        this.onClickListener = listener;
    }

    public interface OnClickListener {
        fun onClick(clickCount: Int);
    }

}

val imageButton: ImageButton = ImageButton();

// SAM Interface와 setter가 모두 Kotlin이므로 (정확히는 Java가 아니므로) 아래와 같은 선언은 불가능하다.
// 하지만 HightOrderFunction을 사용하면 가능하다.

//imageButton.setOnClickListener {
//    ...
//}

// 따라서 아래와 같이 정의한다.
imageButton.setOnClickListener(object : ImageButton.OnClickListener {

    override fun onClick(clickCount: Int) {
        println("imageButton clickCount = $clickCount")
    }

})

imageButton.onClick();
imageButton.onClick();
imageButton.onClick();
imageButton.onClick();



println("\n")


// 아래는 SAM Interface와 그 setter가 Java로 구현된 예제이다.
//val button: Button = Button();
//
//button.setOnClickListener { clickCount ->
//    println("button clickCount = $clickCount")
//}
//
//button.onClick();
//button.onClick();
//button.onClick();
//button.onClick();
//
//
//println("\n")


// 아래는 HighOrderFunction을 사용한 예제이다.
class ToggleButton {

    private var clickCount: Int = 0;
    private var longClickCount: Int = 0;

    private var onClickListener: ((Int) -> Unit)? = null;
    private var onLongClickListener: ((Int) -> Unit)? = null;

    public fun onClick() {
        this.onClickListener?.let {
            it(++clickCount);
        }
    }

    public fun onLongClick() {
        this.onLongClickListener?.let {
            it(++longClickCount);
        }
    }

    public fun setOnClickListener(onClick: ((Int) -> Unit)?, onLongClick: ((Int) -> Unit)?) {
        this.onClickListener = onClick;
        this.onLongClickListener = onLongClick;
    }

}

val toggleButton: ToggleButton = ToggleButton();

toggleButton.setOnClickListener(
        { clickCount ->
            println("toggle clickCount = $clickCount")
        },

        { longClickCount ->
            println("toggle clickCount = $longClickCount")
        }
)

toggleButton.onClick();
toggleButton.onClick();
toggleButton.onClick();
toggleButton.onClick();

println();

toggleButton.onLongClick();
toggleButton.onLongClick();
toggleButton.onLongClick();
toggleButton.onLongClick();










