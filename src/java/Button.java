package java;

import org.jetbrains.annotations.Nullable;

public class Button {

    private int mClickCount;
    private OnClickListener mOnClickListener;

    public Button() {
        mClickCount = 0;
    }

    public void setOnClickListener(@Nullable OnClickListener l) {
        this.mOnClickListener = l;
    }

    public void onClick() {
        mClickCount++;
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(mClickCount);
        }
    }

    public interface OnClickListener {
        void onClick(int clickCount);
    }

}
