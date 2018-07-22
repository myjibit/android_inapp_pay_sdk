package jibit.pay.sdk.views;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.TextView;

import jibit.pay.sdk.Cons;

/**
 * Created by Navid on 9/18/16.
 */
public class MyTextView extends AppCompatTextView {
    public MyTextView(Context context) {
        super(context);
        init();
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        if (!isInEditMode())
            setTypeface(Typeface.createFromAsset(getContext().getAssets(),  Cons.typeFace));
    }
}
