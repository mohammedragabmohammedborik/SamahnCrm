package com.ismart.samahncrm.crmhome.fragments;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ismart.samahncrm.GeneralModel;
import com.ismart.samahncrm.R;
import com.ismart.samahncrm.crmhome.adapters.WaitingAdapter;
import com.ismart.samahncrm.crmhome.models.WaitingModuleAdapter;
import com.ismart.samahncrm.crmhome.waitingviewmodel.WaitingViewModel;
import com.ismart.samahncrm.databinding.CrmFragmentBinding;
import com.ismart.samahncrm.databinding.WaitFragmentBinding;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;


public class WaitingFragment extends Fragment {
   private WaitFragmentBinding waitingFragment;
   // private NavController navController;
    private WaitingViewModel waitingViewModel;
    LinearLayoutManager linearLayoutManager;
private  WaitingAdapter  waitingAdapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        waitingFragment= DataBindingUtil.inflate(
                inflater, R.layout.wait_fragment, container, false);
        View view = waitingFragment.getRoot();

        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        intiateUi();
        waitingViewModel=  ViewModelProviders.of(this).get(WaitingViewModel.class);
//        List<WaitingModuleAdapter> waitingModuleAdapters=new ArrayList<>();
//        waitingModuleAdapters.add(new WaitingModuleAdapter("22-4-2019","22-6-2020","2","3","7",
//                " it new task","title",""));
//        waitingModuleAdapters.add(new WaitingModuleAdapter("22-4-2019","22-6-2020","2","3","7",
//                " it new task","title",""));
//
//        waitingAdapter.setModelsList(waitingModuleAdapters);

        waitingViewModel.getWaitingViewmodel("apiToken","date").observe(getViewLifecycleOwner(),generalModel->{

                List<WaitingModuleAdapter> waitingModuleAdapters=new ArrayList<>();
                waitingModuleAdapters.add(new WaitingModuleAdapter("22-4-2019","22-6-2020","2","3","7",
                        " it new task","title",""));
                waitingModuleAdapters.add(new WaitingModuleAdapter("22-4-2019","22-6-2020","2","3","7",
                        " it new task","title",""));
                waitingAdapter.setModelsList(waitingModuleAdapters);
            }

        );


    }
public  void  intiateUi(){
        linearLayoutManager=new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
    waitingFragment.recycleWaiting.setLayoutManager(linearLayoutManager);
      waitingAdapter=new WaitingAdapter(waitingModuleAdapter -> {

    },waitingModuleAdapter -> {

    });
    waitingFragment.recycleWaiting.setAdapter(waitingAdapter);

}

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        switch (item.getItemId()){
//
//            case android.R.id.home:
//                onBackPressed();
//
//        }
//        return true;
//
//
//    }


    @Override
    public void onStart() {
        super.onStart();
        // EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        //EventBus.getDefault().unregister(this);
    }

}
