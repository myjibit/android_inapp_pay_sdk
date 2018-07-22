package jibit.inapp.payment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import jibit.pay.sdk.JibitPayment;
import jibit.pay.sdk.Utils;

public class MainActivity extends AppCompatActivity {
    Context mContext = this;
    String TAG = "pay_";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        findViewById(R.id.show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                JibitPayment.builder().
                        with(mContext).
                        amount(3000).
                        merchantID("111").
                        transActionID("fc330523").
                        callBackDeepLinkURL("app://payed").
                        response(new JibitPayment.JibitResponse() {
                            @Override
                            public void onResponse(int responseCode, String message) {
                                Log.d(TAG, "response: " + responseCode + " " + message);
                            }
                        }).
                        build();
            }
        });
    }
}
