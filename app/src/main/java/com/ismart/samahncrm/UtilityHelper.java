package com.ismart.samahncrm;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;

import androidx.annotation.IntRange;

import com.irozon.sneaker.Sneaker;

public class UtilityHelper {



 
    public static final  String URLSERVER="https://saudiaqqar.com/";
 
    public  static  void showSnackbar(Activity context, String tite, String Messag){

        Sneaker.with(context) // Activity, Fragment or ViewGroup
                .setTitle(tite)
                .setMessage(Messag)
                .setDuration(6000)
                .sneak(R.color.colorAccent);
    }


    public  static  void showSuccessSnackbar(Activity context, String Message){
        Sneaker.with(context)
                .setMessage(Message)
                .setDuration(4000)
                .sneakSuccess() ;


    }
    public  static  void showErrorSnackbar(Activity context, String Message){
        Sneaker.with(context)
                .setMessage(Message)
                .setDuration(4000)
                .sneakError();


    }
    @IntRange(from = 0, to = 2)
    public static int getConnectionType(Context context) {
        int result = 0; // Returns connection type. 0: none; 1: mobile data; 2: wifi
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (cm != null) {
                NetworkCapabilities capabilities = cm.getNetworkCapabilities(cm.getActiveNetwork());
                if (capabilities != null) {
                    if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                        result = 2;
                    } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                        result = 1;
                    }
                }
            }
        } else {
            if (cm != null) {
                NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
                if (activeNetwork != null) {
                    // connected to the internet
                    if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                        result = 2;
                    } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                        result = 1;
                    }
                }
            }
        }
        return result;
    }
}
