package com.ismart.samahncrm.crmhome.models;

import com.google.gson.annotations.SerializedName;

public class SpinnerModule {
    @SerializedName("id")

    int  id ;
    @SerializedName("name")
    String name ;

    public SpinnerModule(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
