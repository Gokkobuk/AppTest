package com.onethefull.apptest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

// AppDat의 Item 별 데이터

public class AppItem {

    @SerializedName("APP_NAME")
    @Expose
    private String APP_NAME;

    @SerializedName("APP_CATEGORY_NAME")
    @Expose
    private String APP_CATEGORY_NAME;

    @SerializedName("REVIEW_TOTAL_SCORE")
    @Expose
    private String REVIEW_TOTAL_SCORE;

    @SerializedName("FILE1_DOWNLOAD_URL")
    @Expose
    private String FILE1_DOWNLOAD_URL;

    public String getAPP_NAME() {
        return APP_NAME;
    }

    public void setAPP_NAME(String APP_NAME) {
        this.APP_NAME = APP_NAME;
    }

    public String getAPP_CATEGORY_NAME() {
        return APP_CATEGORY_NAME;
    }

    public void setAPP_CATEGORY_NAME(String APP_CATEGORY_NAME) {
        this.APP_CATEGORY_NAME = APP_CATEGORY_NAME;
    }

    public String getREVIEW_TOTAL_SCORE() {
        return REVIEW_TOTAL_SCORE;
    }

    public void setREVIEW_TOTAL_SCORE(String REVIEW_TOTAL_SCORE) {
        this.REVIEW_TOTAL_SCORE = REVIEW_TOTAL_SCORE;
    }

    public String getFILE1_DOWNLOAD_URL() {
        return FILE1_DOWNLOAD_URL;
    }

    public void setFILE1_DOWNLOAD_URL(String FILE1_DOWNLOAD_URL) {
        this.FILE1_DOWNLOAD_URL = FILE1_DOWNLOAD_URL;
    }
}
