package jibit.pay.sdk;

import android.content.Context;
import android.content.pm.PackageManager;

public class Utils {

    public static  boolean isJibitInstalled(Context mContext) {
        PackageManager pm = mContext.getPackageManager();
        try {
            pm.getPackageInfo("mobi.jibit.customer", 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }


}
