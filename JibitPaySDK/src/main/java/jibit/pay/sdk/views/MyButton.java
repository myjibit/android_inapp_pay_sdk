package jibit.pay.sdk.views;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import jibit.pay.sdk.Cons;

/**
 * Created by AmirHossein
 */
public class MyButton extends AppCompatButton {
    public MyButton(Context context) {
        super(context);
        init();
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        if (!isInEditMode())
            setTypeface(Typeface.createFromAsset(getContext().getAssets(), Cons.typeFace));
    }
}
