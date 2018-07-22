package jibit.pay.sdk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;

import jibit.pay.sdk.views.MyButton;
import jibit.pay.sdk.views.MyTextView;


public class BaseDialog {
    private final View dialogView;
    private AlertDialog dialog;

    @SuppressLint("InflateParams")
    public BaseDialog(final Context mContext) {
        Activity mActivity = (Activity) mContext;

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(new ContextThemeWrapper(mContext, R.style.AppTheme));
        LayoutInflater inflater = mActivity.getLayoutInflater();
        dialogView = inflater.inflate(R.layout.dialog_layout, null);

        MyTextView titleV = dialogView.findViewById(R.id.title);
        MyTextView msgV = dialogView.findViewById(R.id.msg);
        MyButton install = dialogView.findViewById(R.id.install);

        dialogBuilder.setView(dialogView);
        dialog = dialogBuilder.create();

        dialogView.findViewById(R.id.install).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGooglePlay(mContext);
            }
        });

    }

    private void openGooglePlay(Context mContext) {
        try {
            mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + Cons.jibitAppID)));
        } catch (android.content.ActivityNotFoundException anfe) {
            mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + Cons.jibitAppID)));
        }
        dismiss();
    }


    public void show() {
        dialog.show();
    }

    public void dismiss() {
        dialog.dismiss();
    }


}
