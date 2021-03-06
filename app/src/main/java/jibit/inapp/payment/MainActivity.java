package jibit.inapp.payment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import jibit.pay.sdk.JibitPayment;
import jibit.pay.sdk.Utils;
import jibit.pay.sdk.views.PayButtonSmall;
import jibit.pay.sdk.views.PayButtonWide;

public class MainActivity extends AppCompatActivity {
    Context mContext = this;
    String TAG = "pay_";
    EditText amount, orderid;
    PayButtonWide btnWide;
    PayButtonSmall btnSmall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind();

        btnSmall.setOnClickListener(V -> {
            start();
        });

        btnWide.setOnClickListener(V -> {
            start();
        });
    }

    void start() {
        JibitPayment.
                with(mContext).
                orderID(orderid.getText().toString()).
                response((responseCode, message) -> Log.d(TAG, "response: " + responseCode + " " + message)).
                build();
    }

    void bind() {
        amount = findViewById(R.id.amount);
        orderid = findViewById(R.id.orderid);
        btnWide = findViewById(R.id.btnWide);
        btnSmall = findViewById(R.id.btnSmall);
    }
}
