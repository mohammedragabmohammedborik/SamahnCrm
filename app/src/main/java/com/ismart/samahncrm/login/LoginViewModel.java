package com.ismart.samahncrm.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.ismart.samahncrm.GeneralModel;

public class LoginViewModel  extends ViewModel {
    private LiveData<GeneralModel> loginViewmodel;
    private  RepositoryLogin repositoryLogin;

    public LoginViewModel() {
        repositoryLogin = new RepositoryLogin();
    }

    public LiveData<GeneralModel> fetchModel(String mobile, String password,String token,String jsonToken,String lang){
        loginViewmodel = repositoryLogin.getModels(mobile,password,token,jsonToken,lang);
        return loginViewmodel;
    }
}
