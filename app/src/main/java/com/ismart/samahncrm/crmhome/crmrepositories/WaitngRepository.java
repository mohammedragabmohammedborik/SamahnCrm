package com.ismart.samahncrm.crmhome.crmrepositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ismart.samahncrm.APIClient;
import com.ismart.samahncrm.ApiInterface;
import com.ismart.samahncrm.GeneralModel;

public class WaitngRepository {
    private static final String TAG = "WaitngRepository";
    private ApiInterface apiInterface= APIClient.getInstance().apiInterface();
    private MutableLiveData<GeneralModel> waitingModule;
     public LiveData<GeneralModel> getWaitingModel(String date,String apiToke){
         if (waitingModule == null) {
             waitingModule = new MutableLiveData<>();
         }
         waitingModule.setValue(null);
         return  waitingModule;
     }


}
