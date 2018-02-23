package com.onethefull.apptest.retrofitService;

import com.onethefull.apptest.retrofitService.ApiService;
import com.onethefull.apptest.retrofitService.RetrofitClient;

// Retrofit 셋팅
public class ApiUtils {
    public static final String BASE_URL = "http://35.194.217.85:8080";

    public ApiService getApiService(){
        return RetrofitClient.getClient(BASE_URL).create(ApiService.class);
    }
}
