package com.sahibindencourseproject.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.sahibindencourseproject.R;
import com.sahibindencourseproject.api.model.WeatherItem;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Ataer Caner on 2019-11-27.
 * Copyright (c) 2019 sahibinden. All rights reserved.
 */

public class WeatherItemRecyclerAdapter extends RecyclerView.Adapter<WeatherItemRecyclerAdapter.ViewHolder> {
    private ArrayList<WeatherItem> itemWeatherItem;
    private ItemClickListener itemClickListener;
    private String[] days = {"Pazartesi", "Salı","Carsamba","Persembe","Cuma","Cumartesi","Pazar"};

    public interface ItemClickListener {
        void onItemClick(WeatherItem weatherItem);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtDayName;
        public TextView txtTemp;


        public ViewHolder(View view) {
            super(view);

            txtDayName = view.findViewById(R.id.txtDayName);
            txtTemp = view.findViewById(R.id.txtTemp);

        }
    }


    public WeatherItemRecyclerAdapter(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
        itemWeatherItem = new ArrayList<>();
    }


    @Override
    public WeatherItemRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather, parent, false);


        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        WeatherItem item = itemWeatherItem.get(position);
        String dayName = days[(position  + getTodaysDayOfWeek()) % 7];

        holder.txtDayName.setText(dayName);
        holder.txtTemp.setText(item.getTemp().getDay() + " °C");
        itemClickListener.onItemClick(item);
    }

    @Override
    public int getItemCount() {
        return itemWeatherItem.size();
    }

    public void setItemWeatherItem(ArrayList<WeatherItem> itemWeatherItem) {
        this.itemWeatherItem = itemWeatherItem;
        notifyDataSetChanged();
    }

    public int getTodaysDayOfWeek() {
        final Calendar c = Calendar.getInstance();
        return c.get(Calendar.DAY_OF_WEEK) - 1;
    }
}
