package jibit.pay.sdk.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import jibit.pay.sdk.R;

public class PayButtonWide extends RelativeLayout {

    Context mContext;
    String TAG = "btn_";

    public PayButtonWide(Context context) {
        super(context);
        mContext = context;
        init(null);
    }

    public PayButtonWide(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init(attrs);
    }

    public PayButtonWide(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.PayButtonWide);
            Boolean status = a.getBoolean(R.styleable.PayButtonWide_enabled, true);
            setEnable(status);
            a.recycle();
        } else {
            setEnable(true);
        }
    }

    public void setEnable(boolean enabled) {
        View v = inflate(getContext(), R.layout.wide_button, this);
        ImageView btn = v.findViewById(R.id.btn);
        int btnBG = R.drawable.wide_enable;
        if (!enabled)
            btnBG = R.drawable.wide_disable;
        btn.setImageDrawable(ContextCompat.getDrawable(mContext, btnBG));
    }
}

