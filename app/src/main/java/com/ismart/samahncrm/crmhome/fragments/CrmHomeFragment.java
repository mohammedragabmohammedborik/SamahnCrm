package com.ismart.samahncrm.crmhome.fragments;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.ismart.samahncrm.R;
import com.ismart.samahncrm.databinding.CrmFragmentBinding;

import java.util.Date;
import java.util.HashSet;


public class CrmHomeFragment extends Fragment {
   private CrmFragmentBinding crmFragmentBinding;
    private NavController navController;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        crmFragmentBinding= DataBindingUtil.inflate(
                inflater, R.layout.crm_fragment, container, false);
        View view = crmFragmentBinding.getRoot();
        navController = Navigation.findNavController(getActivity(), R.id.fragment2_second);

        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        HashSet<Date> events = new HashSet<>();
        events.add(new Date());


        //   CalendarView cv = ((CalendarView)findViewById(R.id.calendar_view));
      crmFragmentBinding.customClander.updateCalendar(events);
       // crmFragmentBinding.customClander.setEventHandler
       // crmFragmentBinding.scrollView.setHorizontalScrollBarEnabled(false);
      //  crmFragmentBinding.scrollView.computeScroll();
      //  crmFragmentBinding.scrollView.fullScroll(0);


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
