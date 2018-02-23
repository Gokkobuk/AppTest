package com.onethefull.apptest.retrofitService;


import com.onethefull.apptest.model.AppData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {



    // 인기앱
    @GET("top-app/all")
    Call<AppData> getTop();


    @GET("new-app/all")
    Call<AppData> getNew();

    @GET("top-grossing/all")
    Call<AppData> getTop_grossing();



}
