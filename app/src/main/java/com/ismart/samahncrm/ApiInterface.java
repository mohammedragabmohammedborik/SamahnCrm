package com.ismart.samahncrm;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

@POST("api/auth/login")
@FormUrlEncoded
    Call<GeneralModel>login(@Field("mobile") String mobile
        , @Field("password") String password, @Header("Authorization")
                                    String token, @Header("Content-Type") String h, @Header("Accept-Language") String lang);



//
//    @POST("api/auth/register")
//    @FormUrlEncoded
//    Call<GeneralModel>Register(@Field("name") String name
//            , @Field("email") String email,
//                               @Field("password") String password,
//                               @Field("password_confirmation") String password_confirmation
//            , @Field("mobile") String mobile
//            , @Field("mobile2") String mobile2
//            , @Field("type") String type
//            , @Field("image") String image
//            , @Field("personal_id") String personal_id
//            , @Field("phone") String phone
//            , @Field("phone2") String phone2
//            , @Field("fax") String fax
//            , @Field("zip_code") String zip_code
//            , @Field("description") String description
//            , @Field("city_id") Integer city_id
//            , @Field("address") String address
//            , @Field("website") String website
//            , @Header("Accept") String Accept, @Header("Accept-Language") String lang
//
//    );
//
//
//    @POST("api/buildings")
//    Call<ModuleShowAqar> getAqarList(@Header("Accept-Language") String lang);
//
//    @POST("api/building")
//    @FormUrlEncoded
//    Call<ModuleShowAqarDetails> getAqarListDetails(@Field("building_id") Integer buildingId, @Header("Accept-Language") String lang);
//
//
//
//
//    @POST("api/auth/sociallogin")
//    @FormUrlEncoded
//    Call<GeneralModel>SocialLogin(@Field("email") String email, @Header("Accept-Language") String lang);
//
//    @POST("api/auth/Verification")
//    @FormUrlEncoded
//    Call<GeneralModel> PhoneVerification(@Field("mobile") String mobile
//            , @Field("mobile_code") String mobile_code
//            , @Header("Authorization") String token
//            , @Header("Accept") String Accept, @Header("Accept-Language") String lang);
//
//
//    @POST("api/cities")
//    Call<CityResponse>GetCities(@Header("Accept-Language") String lang);
//
//
//    @POST("api/{cities}")
//    Call<SpinnerModule>getCustomCity(@Path("cities") String cites, @Header("Accept-Language") String lang);
//
//
//
//
//    @POST("api/buildings/favourite/update")
//    @FormUrlEncoded
//    Call<FavouritesResponse> FavouriteToglle(
//            @Header("Content-Type") String content_type
//            , @Header("Accept") String Accept
//            , @Header("Authorization") String token
//            , @Field("building_id") int building_id, @Header("Accept-Language") String lang
//    );
//
//    /**
//     * Get User Profile
//     */
//    @POST("api/profile")
//     Call<GeneralModel> GetProfile(
//            @Header("Content-Type") String content_type
//            , @Header("Accept") String Accept
//            , @Header("Authorization") String token, @Header("Accept-Language") String lang);
//
//
//    /**
//     * Update User Profile
//     */
//    @POST("api/profile")
//    @FormUrlEncoded
//    Call<GeneralModel> UpdateProfile(
//            @Header("Content-Type") String content_type
//            , @Header("Accept") String Accept
//            , @Header("Authorization") String token
//            , @Field("name") String name
//            , @Field("email") String email
//            , @Field("mobile") String mobile
//            , @Field("phone") String phone
//            , @Field("mobile2") String mobile2
//            , @Field("zip_code") String zip_code
//            , @Field("fax") String fax
//            , @Field("address") String address
//            , @Field("website") String website,
//            @Header("Accept-Language") String lang
//
//    );
//
//
//
//    /**
//     * Update User Profile
//     */
//    @POST("api/profile")
//    @FormUrlEncoded
//    Call<GeneralModel> UpdateProfileImage(
//            @Header("Content-Type") String content_type
//            , @Header("Accept") String Accept
//            , @Header("Authorization") String token
//            , @Field("image") String image
//    );
//
//
//    @POST("api/user/favs")
//    Call<ModuleShowAqar> getMyFavourite(
//            @Header("Content-Type") String content_type
//            , @Header("Accept") String Accept
//            , @Header("Authorization") String token, @Header("Accept-Language") String lang);
//
//
//
//
//
//
//    //my advertise apis
//
//    @POST("api/user/buildings")
//    Call<ModuleShowAqar> GetMyAdvertise(
//            @Header("Content-Type") String content_type
//            , @Header("Accept") String Accept
//            , @Header("Authorization") String token, @Header("Accept-Language") String lang);
//
//
//    @POST("api/building/delete")
//    @FormUrlEncoded
//    Call<GeneralModel> DeleteBuidling(
//            @Header("Content-Type") String content_type
//            , @Header("Accept") String Accept
//            , @Header("Authorization") String token
//            , @Field("building_id") int building_id
//    );
//
//
//    @POST("api/building/image/delete")
//    @FormUrlEncoded
//    Call<GeneralModel> deleteImage(
//            @Header("Accept") String Accept
//            , @Header("Authorization") String token
//            , @Field("image_id") Integer image_id, @Field("building_id") Integer building_id
//    );
//
//
//@POST("api/building/store")
//    Call<ModuleShowAqarDetails> addAqar(
//        @Header("Content-Type") String content_type
//        , @Header("Accept") String Accept
//        , @Header("Authorization") String token, @Header("Accept-Language") String lang
//        , @Body AddAqarObject addAqarObject
//);
//
//
//    @POST("api/building/update")
//    Call<ModuleShowAqarDetails> updateAqar(
//            @Header("Content-Type") String content_type
//            , @Header("Accept") String Accept
//            , @Header("Authorization") String token, @Header("Accept-Language") String lang
//            , @Body ModuleShowAqarDetails.ModuleShowAqarData addAqarObject
//    );
//
//
//    @POST("api/building/store")
//    Call<ModuleShowAqarDetails> upDate(
//            @Header("Content-Type") String content_type
//            , @Header("Accept") String Accept
//            , @Header("Authorization") String token
//            , @Body ModuleShowAqarDetails.ModuleShowAqarData addAqarObject
//    );
//
//    @POST("api/building/book")
//    @FormUrlEncoded
//    Call<GeneralModel> BookAppointment(
//            @Header("Content-Type") String content_type
//            , @Header("Accept") String Accept
//            , @Header("Authorization") String token
//            , @Field("booking_id") int building_id
//    );
//
//
//    @POST("api/auth/refresh")
//     Call<tokenResponse> RefreshToken(
//            @Header("Content-Type") String content_type
//            , @Header("Accept") String Accept
//            , @Header("Authorization") String token
//    );
//
//
//    @POST("api/buildings/filter")
//    @FormUrlEncoded
//    Call<ModuleShowAqar> FilterBuilding(
//            @Header("Content-Type") String content_type
//            , @Header("Accept") String Accept
//            , @Header("Authorization") String token
//            , @Field("city_id") String city_id
//            , @Field("category_id") String category_id
//            , @Field("price_from") String price_from
//            , @Field("price_to") String price_to
//            , @Field("rooms") String rooms
//            , @Field("bathrooms") String bathrooms
//            , @Field("furnitured") String furnitured
//            , @Field("area_from") String area_from
//            , @Field("area_to") String area_to
//            , @Field("section") String section
//            , @Field("address") String address, @Header("Accept-Language") String lang
//
//    );
//
//
//
//
//
//
//
//
//    @POST("api/buildings/sort")
//    @FormUrlEncoded
//    Call<ModuleShowAqar> SortBuilding(
//            @Header("Content-Type") String content_type
//            , @Header("Accept") String Accept
//            , @Header("Authorization") String token
//            , @Field("column") String column
//            , @Field("direction") String direction
//            , @Header("Accept-Language") String lang
//
//    );
//
//
//    @POST("api/buildings/search")
//    @FormUrlEncoded
//    Call<ModuleShowAqar> SearchBuilding(
//            @Header("Content-Type") String content_type
//            , @Header("Accept") String Accept
//            , @Header("Authorization") String token
//            , @Field("word") String Search_word,
//            @Header("Accept-Language") String lang
//
//    );
//
//
//
//    @POST("api/user/notifications")
//    @FormUrlEncoded
//    Call<NotifcationResponse> userNotifcation(
//            @Header("Content-Type") String content_type
//            , @Header("Accept") String Accept
//            , @Header("Authorization") String token
//            , @Field("user_id") int userId, @Header("Accept-Language") String lang
//
//    );
//
//    @POST("api/settings")
//     Call<ContactUsResponse> getSetting(
//            @Header("Content-Type") String content_type
//            , @Header("Accept") String Accept, @Header("Accept-Language") String lang
//
//    );
//
//    //  deleteImage
//
////    @POST("api/building/image/delete")
////    @FormUrlEncoded
////    Call<GeneralModel> deleteImage1(@Header("Content-Type")String content_type
////            , @Header("Accept") String Accept,
////            @Field("image_id") Integer image_id,@Field("building_id") Integer building_id);

}


