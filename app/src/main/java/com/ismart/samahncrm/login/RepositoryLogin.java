package com.ismart.samahncrm.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ismart.samahncrm.APIClient;
import com.ismart.samahncrm.ApiInterface;
import com.ismart.samahncrm.GeneralModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepositoryLogin {
    private static final String TAG = "RepositoryLogin";
    private ApiInterface apiInterface= APIClient.getInstance().apiInterface();
    private MutableLiveData<GeneralModel> loginMutableLiveData;

    public LiveData<GeneralModel> getModels(String mobile, String password, String token, String jsonToken, String lang) {
        if (loginMutableLiveData == null) {
            loginMutableLiveData = new MutableLiveData<>();
        }
        apiInterface.login(mobile,password,token,jsonToken,lang)
                .enqueue(new Callback<GeneralModel>() {
                    @Override
                    public void onResponse(Call<GeneralModel> call, Response<GeneralModel> response) {
                        if (response.body() != null && response.isSuccessful() && (response.body().getStatus()==1) ){

                            loginMutableLiveData.setValue(response.body());
                        }else {
                            loginMutableLiveData.setValue(null);
                        }
                    }

                    @Override
                    public void onFailure( Call<GeneralModel> call, Throwable t) {
                        loginMutableLiveData.setValue(null);
                        //  Log.e(TAG, "on fetch models: " + t.getLocalizedMessage());
                    }
                });
        return loginMutableLiveData;
    }
}
