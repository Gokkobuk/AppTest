package com.onethefull.apptest.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.onethefull.apptest.R;
import com.onethefull.apptest.adapter.GridRecyclerViewAdapter;
import com.onethefull.apptest.model.AppData;
import com.onethefull.apptest.model.AppItem;
import com.onethefull.apptest.retrofitService.ApiUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// Fragment 안에서 RecyclerView 호출
public class FragmentApp extends android.support.v4.app.Fragment{
    MainActivity activity;
    private ApiUtils apiUtils = new ApiUtils();
    private RecyclerView recyclerView;
    private GridRecyclerViewAdapter gridRecyclerViewAdapter;
    private List<AppItem> appItem = new ArrayList<>();
    private Call<AppData> call = null;

    public void onCategory(int category){
            switch (category){
                case 1:
                    call = apiUtils.getApiService().getTop();
                    break;
                case 2:
                    call = apiUtils.getApiService().getNew();
                    break;
                case 3:
                    call = apiUtils.getApiService().getTop_grossing();
                    break;
                default:
                    call = apiUtils.getApiService().getTop();
                    break;
        }
        request();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //fragment 불러오기
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_app,container,false);

        //fragment 안에 있는 recyclerview 불러오기
        recyclerView = view.findViewById(R.id.recyclerView);
        //recyclerview Grid 셋팅
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.HORIZONTAL));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),5));

        call = apiUtils.getApiService().getTop();
        return view;
    }

    private void request(){
        call.enqueue(new Callback<AppData>() {
            @Override
            public void onResponse(Call<AppData> call, Response<AppData> response) {
                appItem.clear();
                AppData appData = response.body();
                List<AppItem> appList = appData.getData();
                Log.v("AppItem", String.valueOf(appList.size()));
                appItem.addAll(appList);
                //GridRecyclerView 호출
                gridRecyclerViewAdapter = new GridRecyclerViewAdapter(appItem, getActivity());
                // recyclerview 와 Gridrecyclerview 연동
                recyclerView.setAdapter(gridRecyclerViewAdapter);
                Log.d("setAdapter","ok" );
            }
            @Override
            public void onFailure(Call<AppData> call, Throwable t) {

            }
        });
    }
    @Override
    public void onResume() {
        super.onResume();
        request();
    }
}
