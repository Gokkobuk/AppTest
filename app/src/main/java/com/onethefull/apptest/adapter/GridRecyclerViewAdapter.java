package com.onethefull.apptest.adapter;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.onethefull.apptest.model.AppItem;
import com.onethefull.apptest.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by kaykwon on 2018-02-22.
 */

public class GridRecyclerViewAdapter extends RecyclerView.Adapter<GridRecyclerViewAdapter.ViewHolder> {

    private List<AppItem> appItem;
    Context context;

    public GridRecyclerViewAdapter(List<AppItem> appItem, Context context) {
        this.appItem = appItem;
        this.context = context;
    }

    @Override
    public GridRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_app,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        AppItem item = appItem.get(position);


        holder.appName.setText(item.getAPP_NAME());
        holder.appCompany.setText(item.getAPP_CATEGORY_NAME());
        holder.appRating.setRating(Float.valueOf(item.getREVIEW_TOTAL_SCORE()));
        Picasso.with(context).load(item.getFILE1_DOWNLOAD_URL()).resize(120,80).into(holder.appImage);

    }

    @Override
    public int getItemCount() {
        return appItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView appImage;
        TextView appName;
        TextView appCompany;
        RatingBar appRating;


        public ViewHolder(View view) {
            super(view);
           appImage = view.findViewById(R.id.appImage);
            appName =view.findViewById(R.id.appName);
            appCompany = view.findViewById(R.id.appCompany);
           appRating = view.findViewById(R.id.appRating);

        }
    }
}
