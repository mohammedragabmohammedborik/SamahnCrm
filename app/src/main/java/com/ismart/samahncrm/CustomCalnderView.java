package com.ismart.samahncrm;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.ismart.CustomCalendarAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

public class CustomCalnderView extends LinearLayout {
    LinearLayout header;
    Button btnToday;
    ImageView btnPrev;
    ImageView btnNext;
    TextView txtDateDay;
    TextView txtDisplayDate;
    TextView txtDateYear;
    GridView gridView;

    // for logging
    private static final String LOGTAG = "Calendar View";

    // how many days to show, defaults to six weeks, 42 days
    private static final int DAYS_COUNT = 42;

    // default date format
    private static final String DATE_FORMAT = "MMM yyyy";

    // date format
    private String dateFormat;
    // current displayed month
    private Calendar currentDate = Calendar.getInstance();

    //event handling
    private EventHandler eventHandler = null;

    // current displayed month
    public CustomCalnderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initControl(context, attrs);

    }

    private void assignUiElements() {
        // layout is inflated, assign local variables to components
        header = findViewById(R.id.calendar_header);
        btnPrev = findViewById(R.id.calendar_prev_button);
        btnNext = findViewById(R.id.calendar_next_button);
        txtDateDay = findViewById(R.id.date_display_day);
        //txtDateYear = findViewById(R.id.date_display_year);
        txtDisplayDate = findViewById(R.id.date_display_date);
      //  btnToday = findViewById(R.id.date_display_today);
        gridView = findViewById(R.id.calendar_grid);

    }

    /**
     * Load control xml layout
     */
    private void initControl(Context context, AttributeSet attrs)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.custom_calendar_layout, this);
        assignUiElements();
        assignClickHandlers();

    }


    /**
     * Display dates correctly in grid
     */
    public void updateCalendar(HashSet<Date> events)
    {
        ArrayList<Date> cells = new ArrayList<>();
        Calendar calendar = (Calendar)currentDate.clone();

        // determine the cell for current month's beginning
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int monthBeginningCell = calendar.get(Calendar.DAY_OF_WEEK) - 2;

        // move calendar backwards to the beginning of the week
        calendar.add(Calendar.DAY_OF_MONTH, -monthBeginningCell);

        Log.w("TAG", "updateCalendar: 1 "+Calendar.DAY_OF_MONTH+" ... 2..."+-monthBeginningCell);

        // fill cells
        while (cells.size() < DAYS_COUNT)
        {
            cells.add(calendar.getTime());
            Log.w("TAG", "updateCalendar: Time "+calendar.getTime());

            calendar.add(Calendar.DAY_OF_MONTH, 1);
            Log.w("TAG", "updateCalendar: Month "+Calendar.DAY_OF_MONTH);

        }

        // update grid
        gridView.setAdapter(new CustomCalendarAdapter(getContext(), cells, events));

        // update title
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE,d MMM,yyyy");
        String[] dateToday = sdf.format(currentDate.getTime()).split(",");
        Log.w("TAG", "updateCalendar: ... .. "+ currentDate.getTime());
        txtDateDay.setText(dateToday[0]);
        txtDisplayDate.setText(dateToday[1]+dateToday[2]);
        //txtDateYear.setText(dateToday[2]);

    }

    /**
     * Assign event handler to be passed needed events
     */
    public void setEventHandler(EventHandler eventHandler)
    {
        this.eventHandler = eventHandler;
    }

    /**
     * This interface defines what events to be reported to
     * the outside world
     */
    public interface EventHandler
    {
        void onDayLongPress(Date date);
    }

    public void updateCalendar()
    {
        updateCalendar(null);
    }
    //
    private void assignClickHandlers()
    {
        // add one month and refresh UI
        btnNext.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                currentDate.add(Calendar.MONTH, 1);
                updateCalendar();
            }
        });

        // subtract one month and refresh UI
        btnPrev.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                currentDate.add(Calendar.MONTH, -1);
                updateCalendar();
            }
        });

        // long-pressing a day
        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {

            @Override
            public boolean onItemLongClick(AdapterView<?> view, View cell, int position, long id)
            {
                // handle long-press
                if (eventHandler == null)
                    return false;

                eventHandler.onDayLongPress((Date)view.getItemAtPosition(position));
                return true;
            }
        });
    }
}
