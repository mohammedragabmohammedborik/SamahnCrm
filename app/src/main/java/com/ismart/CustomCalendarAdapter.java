package com.ismart;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ismart.samahncrm.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

public class CustomCalendarAdapter extends ArrayAdapter<Date> {
    private HashSet<Date> eventDays;


    // for view inflation
    private LayoutInflater inflater;
    public CustomCalendarAdapter(Context context, ArrayList<Date> days, HashSet<Date> eventDays)
    {
        super(context, R.layout.calendar_item, days);
        this.eventDays = eventDays;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public View getView(int position, View view, ViewGroup parent)
    {
        // day in question
        Calendar calendar = Calendar.getInstance();
        Date date = getItem(position);
        calendar.setTime(date);
        int day = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        // today
        Date today = new Date();
        Calendar calendarToday = Calendar.getInstance();
        calendarToday.setTime(today);

        // inflate item if it does not exist yet
        if (view == null)
            view = inflater.inflate(R.layout.calendar_item, parent, false);
        // clear styling
        ((TextView)view).setTypeface(null, Typeface.NORMAL);
        ((TextView)view).setTextColor(Color.BLACK);

        if (month != calendarToday.get(Calendar.MONTH) || year != calendarToday.get(Calendar.YEAR)) {
            // if this day is outside current month, grey it out
            ((TextView) view).setTextColor(Color.parseColor("#000000"));
        } else if (day == calendarToday.get(Calendar.DATE)) {
            // if it is today, set it to blue/bold
            ((TextView)view).setTextColor(Color.WHITE);
            ((TextView) view).setGravity(Gravity.CENTER);
            view.setBackgroundResource(R.drawable.circle_view_brown);
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setBackgroundResource(R.drawable.circle_view_brown);

            }
        });

        // set text
        ((TextView)view).setText(String.valueOf(calendar.get(Calendar.DATE)));

        return view;
    }


}
