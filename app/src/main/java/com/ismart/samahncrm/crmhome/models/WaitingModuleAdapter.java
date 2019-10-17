package com.ismart.samahncrm.crmhome.models;

public class WaitingModuleAdapter {
    private String textDateFrom;
    private  String textDateTo;
    private  String day;
    private String hour;
    private  String minute;
    private  String description;
    private  String  title;

    public WaitingModuleAdapter(String textDateFrom, String textDateTo, String day, String hour, String minute, String description, String title) {
        this.textDateFrom = textDateFrom;
        this.textDateTo = textDateTo;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.description = description;
        this.title = title;
    }

    public String getTextDateFrom() {
        return textDateFrom;
    }

    public void setTextDateFrom(String textDateFrom) {
        this.textDateFrom = textDateFrom;
    }

    public String getTextDateTo() {
        return textDateTo;
    }

    public void setTextDateTo(String textDateTo) {
        this.textDateTo = textDateTo;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
