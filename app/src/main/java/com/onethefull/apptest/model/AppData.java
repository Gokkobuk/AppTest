package com.onethefull.apptest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

// 전체 AppData 리스트

public class AppData {
    @SerializedName("data")
    @Expose
    private List<AppItem> data;

    public List<AppItem> getData() {
        return data;
    }
}
