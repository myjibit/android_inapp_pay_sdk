package jibit.pay.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.net.URLEncoder;

public class JibitPayment {

    private JibitPayment(Builder builder) {
        Context mContext = builder.mContext;
        String merchantID = builder.merchantID;
        int amount = builder.amount;
        JibitResponse response = builder.response;
        String transActionID = builder.transActionID;
        String callBackURL = builder.callBackURL;
    }

    public static Builder with(Context val) {
        return new Builder(val);
    }


    public static final class Builder {
        private Context mContext;
        private String merchantID;
        private JibitResponse response;
        private String transActionID;
        private int amount = 0;
        private String callBackURL;

        private Builder(Context val) {
            mContext = val;
        }

        public Builder with(Context val) {
            mContext = val;
            return this;
        }

        public Builder merchantID(String val) {
            merchantID = val;
            return this;
        }

        public Builder transActionID(String val) {
            transActionID = val;
            return this;
        }

        public Builder amount(int val) {
            amount = val;
            return this;
        }

        public Builder response(JibitResponse val) {
            response = val;
            return this;
        }

        public Builder callBackkURL(String val) {
            callBackURL = val;
            return this;
        }

        public JibitPayment build() {

            if (this.response != null) {
                if (this.mContext == null) {
                    response.onResponse(400, "Context is null");
                    return null;
                }
                if (this.amount == 0) {
                    response.onResponse(401, "Amount is null");
                    return null;
                }
                if (this.merchantID == null || this.merchantID.length() == 0) {
                    response.onResponse(402, "Merchant ID is null");
                    return null;
                }
                if (this.transActionID == null) {
                    response.onResponse(403, "TransAction ID is null");
                    return null;
                }
            }

            if (mContext != null)
                if (!Utils.isJibitInstalled(mContext)) {
                    BaseDialog dialog = new BaseDialog(mContext);
                    dialog.show();
                } else {
                    String address = "https://pay.jibit.mobi/pd?m=" + merchantID + "&n=&a=" + amount + "&u=null&p=null&d=null";

                    if (callBackURL.length() > 0)
                        try {
                            String query = URLEncoder.encode(callBackURL, "utf-8");
                            address += "&callback=" + query;
                        } catch (Exception e) {
                            //
                        }

                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(address));

                    mContext.startActivity(intent);
                }
            else
                return null;

            return new JibitPayment(this);
        }
    }

    public interface JibitResponse {
        void onResponse(int responseCode, String message);
    }
}
