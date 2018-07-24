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
    EditText amount, merchantid;
    PayButtonWide btnWide;
    PayButtonSmall btnSmall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind();


        btnSmall.setOnClickListener(V -> {
            btnSmall.setEnable(false);
        });

        btnWide.setOnClickListener(V -> {
            btnWide.setEnable(true);

            //just order id
            //remove other fields
            JibitPayment.
                    with(mContext).
                    amount(Integer.parseInt((amount.getText().length() > 0 ? amount.getText().toString() : "0"))).
                    merchantID((merchantid.getText().length() > 0 ? merchantid.getText().toString() : "")).
                    transActionID("fc330523").
                    callBackkURL("jibitpay://payed").
                    response((responseCode, message) -> Log.d(TAG, "response: " + responseCode + " " + message)).
                    build();

        });


        findViewById(R.id.openDeep).setOnClickListener(V -> {
            String address = "https://pay.jibit.mobi/pd?m=7751&n=%D9%85%D8%B4%D8%A7%DB%8C%D8%AE&a=1000&u=null&p=null&d=null";
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(address));
            startActivity(intent);

        });
    }

    void bind() {
        amount = findViewById(R.id.amount);
        merchantid = findViewById(R.id.merchantid);
        btnWide = findViewById(R.id.btnWide);
        btnSmall = findViewById(R.id.btnSmall);
    }
}
