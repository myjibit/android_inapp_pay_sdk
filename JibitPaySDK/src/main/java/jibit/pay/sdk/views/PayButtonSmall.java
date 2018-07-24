package jibit.pay.sdk.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import jibit.pay.sdk.R;

public class PayButtonSmall extends RelativeLayout {
    Context mContext;
    public PayButtonSmall(Context context) {
        super(context);
        mContext = context;
        init(null);
    }

    public PayButtonSmall(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init(attrs);
    }

    public PayButtonSmall(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        if (attrs != null) {
            @SuppressLint("CustomViewStyleable") TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.PayButtonWide);
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
        int btnBG = R.drawable.small_enable;
        if (!enabled)
            btnBG = R.drawable.small_disable;
        btn.setImageDrawable(ContextCompat.getDrawable(mContext, btnBG));
    }
}

