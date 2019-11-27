package com.sahibindencourseproject.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.sahibindencourseproject.R;
import com.sahibindencourseproject.api.model.List;

import java.util.ArrayList;

/**
 * Created by Ataer Caner on 2019-11-27.
 * Copyright (c) 2019 sahibinden. All rights reserved.
 */

public class WeatherItemRecyclerAdapter extends RecyclerView.Adapter<WeatherItemRecyclerAdapter.ViewHolder> {
    ArrayList<List> itemList;


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtDayName;
        public TextView txtTemp;


        public ViewHolder(View view) {
            super(view);

            txtDayName = view.findViewById(R.id.txtDayName);
            txtTemp = view.findViewById(R.id.txtTemp);

        }
    }


    public WeatherItemRecyclerAdapter(ArrayList<List> itemList) {
        this.itemList = itemList;
    }


    @Override
    public WeatherItemRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather, parent, false);


        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        List item = itemList.get(position);
        holder.txtDayName.setText("Pazartesi");
        holder.txtTemp.setText(item.getTemp().getDay() + " °C");

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


}
