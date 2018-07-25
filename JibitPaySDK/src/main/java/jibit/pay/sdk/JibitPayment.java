package jibit.pay.sdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class JibitPayment {


    public static Builder with(Context val) {
        return new Builder(val);
    }


    public static final class Builder {
        private Context mContext;
        private JibitResponse response;
        private String orderID;

        private Builder(Context val) {
            mContext = val;
        }

        public Builder with(Context val) {
            mContext = val;
            return this;
        }

        public Builder orderID(String val) {
            orderID = val;
            return this;
        }

        public Builder response(JibitResponse val) {
            response = val;
            return this;
        }

        public void build() {
            if (this.response != null) {
                if (this.mContext == null) {
                    response.onResponse(400, "Context is null");
                    return;
                }
                if (this.orderID == null) {
                    response.onResponse(401, "orderID ID is null");
                    return;
                }
            }

            if (mContext != null)
                if (!Utils.isJibitInstalled(mContext)) {
                    BaseDialog dialog = new BaseDialog(mContext);
                    dialog.show();
                } else if (orderID.length() > 0) {
                    String address = "jibit://pay_sdk?orderid=" + orderID;
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(address));
                    try{
                        mContext.startActivity(intent);
                    }catch (Exception e){
                        response.onResponse(402, "Error in opening Jibit,Jibit Version is old");
                        //jibit app installed but not opened yet
                    }

                } else
                    return;

            new JibitPayment();
        }
    }

    public interface JibitResponse {
        void onResponse(int responseCode, String message);
    }
}
