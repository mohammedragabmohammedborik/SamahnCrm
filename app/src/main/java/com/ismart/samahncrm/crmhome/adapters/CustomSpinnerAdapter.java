package com.ismart.samahncrm.crmhome.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.ismart.samahncrm.R;
import com.ismart.samahncrm.crmhome.models.SpinnerModule;

import java.util.List;

public class CustomSpinnerAdapter
    extends ArrayAdapter<SpinnerModule>

    {
        private Context context;

        LayoutInflater inflter;
        List<SpinnerModule> spinnerModelList;

    public CustomSpinnerAdapter(Context context, List<SpinnerModule> spinnerModelList ) {
        super(context, 0);
        this.context=context;
        this.spinnerModelList=spinnerModelList;
        inflter = (LayoutInflater.from(context));

    }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.spinner_item, null);
            SpinnerModule spinnerModel=spinnerModelList.get(i);
        Log.w("TAG",spinnerModel.getName());
        TextView names = (TextView) view.findViewById(R.id.spinner_textview);
        names.setText(spinnerModel.getName());
        return view;
    }
        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
        convertView = inflter.inflate(R.layout.spinner_item, null);
            SpinnerModule spinnerModel=spinnerModelList.get(position);

        TextView names = (TextView) convertView.findViewById(R.id.spinner_textview);
        names.setText(spinnerModel.getName());
        return convertView;

    }
        @Override
        public int getCount() {
        return spinnerModelList.size();
    }

    }


