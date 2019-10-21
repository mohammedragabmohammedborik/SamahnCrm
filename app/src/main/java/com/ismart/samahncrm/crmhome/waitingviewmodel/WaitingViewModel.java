package com.ismart.samahncrm.crmhome.waitingviewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.ismart.samahncrm.GeneralModel;
import com.ismart.samahncrm.crmhome.crmrepositories.WaitngRepository;

public class WaitingViewModel  extends ViewModel {
    private LiveData<GeneralModel> waitingViewmodel;
    private WaitngRepository waitngRepository;

    public WaitingViewModel() {
        waitngRepository=new WaitngRepository();
    }

    public LiveData<GeneralModel> getWaitingViewmodel(String apiToken,String date) {
        waitingViewmodel= waitngRepository.getWaitingModel(apiToken,date);
        return  waitingViewmodel;

    }
}
