
package com.ismart.samahncrm;

import android.content.Context;
import android.content.SharedPreferences;



/**
 * Created by Bakr on 25/02/2018.
 */


public class SharedPrefManager {



    //the constants
    private static final String SHARED_PREF_NAME = "com.ismart.saudiaqarSharedPreferance";


    // user Model
    private static final String KEY_name = "KEY_Name";
    private static final String KEY_UserEmail = "User_Email";
    private static final String KEY_Usermobile = "Usermobile";
    private static final String KEY_type = "type";
    private static final String KEY_personal_id = "personal_id";
    private static final String KEY_phone = "Phone";
    private static final String KEY_image= "image";
    private static final String KEY_fax= "fax";
    private static final String KEY_mobile_code= "KEY_mobile_code";
    private static final String KEY_UserID = "KEY_UserID";
    private static final String KEY_Adress= "KEY_Adress";
    private static final String KEY_Website = "KEY_Website";
    private static final String KEY_ZipCode = "KEY_ZipCode";



    // token Model
    private static final String KEY_Token = "KEY_Token";
    private static final String KEY_Token_type = "KEY_Type";
    private static final String KEY_expires_in = "KEY_expires_in";




    // about us model
    private static final   String      tax = "tax";
    private static final   String     delivery_cost= "delivery_cost" ;
    private static final   String      siteName = "siteName";
    private static final   String     header= "header" ;
    private static final   String     footer= "footer" ;
    private static final   String      address= "address" ;
    private static final   String      place = "place";
    private static final   String      email = "email";
    private static final   String      phone = "phone";
    private static final   String     facebook= "facebook";
    private static final   String      twitter = "twitter";
    private static final   String      instagram = "instagram";
    private static final   String      google = "google";
    private static final   String      tax_after_delivery= "tax_after_delivery";
    private static final   String      about_first_img= "about_first_img";
    private static final   String      about_first_text= "about_first_text";
    private static final   String      about_second_text= "about_second_text";
    private static final   String      about_second_img= "about_second_img";
    private static final   String      terms_text = "terms_text";

    private static SharedPrefManager mInstance;
    private static Context mCtx;



    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor editor;

    public static void putKey(Context context, String Key, String Value) {
        sharedPreferences = context.getSharedPreferences("Cache", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString(Key, Value);
        editor.commit();

    }

    public static String getKey(Context contextGetKey, String Key) {
        sharedPreferences = contextGetKey.getSharedPreferences("Cache", Context.MODE_PRIVATE);
        String Value = sharedPreferences.getString(Key, "");
        return Value;

    }

    private SharedPrefManager(Context context) {
        mCtx = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }


//        public String getToken() {
//        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
//        return sharedPreferences.getString(KEY_Token, null);
//         }
//
//
//         public void SetupUser(GeneralModel generalModel) {
//             SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
//             SharedPreferences.Editor editor = sharedPreferences.edit();
//             try
//             {
//                 // save user model
//                 User user = generalModel.getData().getUser();
//                 editor.putString(KEY_name, user.getName());
//                 editor.putString(KEY_UserEmail, user.getEmail());
//                 editor.putString(KEY_Usermobile, user.getMobile());
//                 editor.putString(KEY_type, user.getType());
//                 editor.putString(KEY_personal_id, user.getPersonal_id());
//                 editor.putString(KEY_phone, user.getPhone());
//                 editor.putString(KEY_image, user.getImage());
//                 editor.putString(KEY_fax, user.getFax());
//                 editor.putString(KEY_mobile_code, user.getMobile_code());
//                 editor.putString(KEY_UserID, user.getId());
//                 editor.putString(KEY_ZipCode, user.getZip_code());
//
//                 editor.putString(KEY_Adress, user.getAddress());
//                 editor.putString(KEY_Website, user.getWebsite());
//                 //save token
//                 editor.putString(KEY_Token, generalModel.getData().getToken().getAccess_token());
//                 editor.putString(KEY_Token_type, generalModel.getData().getToken().getToken_type());
//                 editor.putString(KEY_expires_in, generalModel.getData().getToken().getExpires_in());
//
//
//                 editor.commit();
//
//             }
//             catch (Exception ex )
//             {
//                 ex.printStackTrace();
//                 editor.commit();
//
//             }
//
//
//    }
//
//         public User getUser() {
//        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
//          return new User(
//                  sharedPreferences.getString(KEY_UserID, null),
//                  sharedPreferences.getString(KEY_name, null),
//                  sharedPreferences.getString(KEY_UserEmail, null),
//                  sharedPreferences.getString(KEY_Usermobile, null),
//                  sharedPreferences.getString(KEY_type, null),
//                  sharedPreferences.getString(KEY_personal_id, null),
//                  sharedPreferences.getString(KEY_phone, null),
//                  sharedPreferences.getString(KEY_image, null),
//                  sharedPreferences.getString(KEY_fax, null),
//                  sharedPreferences.getString(KEY_mobile_code, null)
//                  ,null,null
//                  ,   sharedPreferences.getString(KEY_Adress, null)
//                  ,sharedPreferences.getString(KEY_Website, null)
//                  ,  sharedPreferences.getString(KEY_ZipCode , null)
//
//          );
//    }
//
//    public void SetupToken(tokenResponse.data token)
//    {
//        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        //save token
//        editor.putString(KEY_Token, token.getAccess_token());
//        editor.putString(KEY_Token_type, token.getToken_type());
//        editor.putString(KEY_expires_in, token.getExpires_in());
//        editor.apply();
//
//    }
//
//
//
//
//
//
//    //this method will logout the user
//    public void logout() {
//        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.clear();
//        editor.apply();
//    }
//
//
//
//
//
//    //public data(int tax, int delivery_cost, String siteName, String header, String footer, String address, String place, String email, String phone, String facebook, String twitter, String instagram, String google, String tax_after_delivery, String about_first_img, String about_first_text, String about_second_text, String about_second_img, String terms_text) {
//
//
//    public void setAboutus(ContactUsResponse.data data) {
//
//        try
//        {
//            SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
//            SharedPreferences.Editor editor = sharedPreferences.edit();
//
//
//            // save contact us  model
//            editor.putInt(tax, data.getTax());
//            editor.putInt(delivery_cost, data.getDelivery_cost());
//            editor.putString(siteName, data.getSiteName());
//            editor.putString(header, data.getHeader());
//            editor.putString(footer, data.getFooter());
//            editor.putString(address, data.getAddress());
//            editor.putString(place, data.getPlace());
//            editor.putString(email, data.getEmail());
//            editor.putString(phone, data.getPhone());
//            editor.putString(facebook, data.getFacebook());
//            editor.putString(twitter, data.getTwitter());
//            editor.putString(instagram, data.getInstagram());
//            editor.putString(google, data.getGoogle());
//            editor.putString(tax_after_delivery, data.getTax_after_delivery());
//            editor.putString(about_first_img, data.getAbout_first_img());
//            editor.putString(about_first_text, data.getAbout_first_text());
//            editor.putString(about_second_text, data.getAbout_second_text());
//            editor.putString(about_second_img, data.getAbout_second_img());
//            editor.putString(terms_text, data.getTerms_text());
//
//            editor.apply();
//        }
//        catch (Exception ex )
//        {
//            ex.printStackTrace();
//        }
//
//
//    }
//
//
//    public ContactUsResponse.data getcontactUs() {
//        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
//        ContactUsResponse.data data =new ContactUsResponse(). new data( sharedPreferences.getInt(tax, 0),
//                sharedPreferences.getInt(delivery_cost, 0),
//                sharedPreferences.getString(siteName, null),
//                sharedPreferences.getString(header, null),
//                sharedPreferences.getString(footer, null),
//                sharedPreferences.getString(address, null),
//                sharedPreferences.getString(place, null),
//                sharedPreferences.getString(email, null),
//                sharedPreferences.getString(phone, null),
//                sharedPreferences.getString(facebook, null)
//                ,sharedPreferences.getString(twitter, null)
//                ,sharedPreferences.getString(instagram, null),
//                sharedPreferences.getString(google, null)
//                , sharedPreferences.getString(tax_after_delivery, null)
//                ,sharedPreferences.getString(about_first_img, null)
//                ,sharedPreferences.getString(about_first_text, null)
//                ,sharedPreferences.getString(about_second_text, null)
//                ,sharedPreferences.getString(about_second_img, null)
//                , sharedPreferences.getString(terms_text, null));
//        return  data;
//    }
//
//



}


