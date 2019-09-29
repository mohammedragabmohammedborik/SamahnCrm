package com.ismart.samahncrm;

import android.app.Activity;

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
                .sneakSuccess() ;


    }
}
