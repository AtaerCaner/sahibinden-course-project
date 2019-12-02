package com.sahibindencourseproject.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.sahibindencourseproject.R;
import com.sahibindencourseproject.api.model.WeatherItem;
import com.sahibindencourseproject.util.DateUtil;
import com.sahibindencourseproject.util.TemperatureUtil;

import java.util.ArrayList;

/**
 * Created by Ataer Caner on 2019-11-27.
 * Copyright (c) 2019 sahibinden. All rights reserved.
 */

public class WeatherItemAdapter extends RecyclerView.Adapter<WeatherItemAdapter.WeatherItemsViewHolder> {
    private ArrayList<WeatherItem> itemWeatherItem;
    private ItemClickListener itemClickListener;

    public interface ItemClickListener {
        void onItemClick(WeatherItem weatherItem);
    }

    class WeatherItemsViewHolder extends RecyclerView.ViewHolder {

        TextView txtDayName;
        TextView txtTemp;


        WeatherItemsViewHolder(View view) {
            super(view);

            txtDayName = view.findViewById(R.id.txtDayName);
            txtTemp = view.findViewById(R.id.txtTemp);

        }
    }


    public WeatherItemAdapter(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
        itemWeatherItem = new ArrayList<>();
    }


    @Override
    public WeatherItemsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather, parent, false);


        return new WeatherItemsViewHolder(v);
    }


    @Override
    public void onBindViewHolder(WeatherItemsViewHolder holder, int position) {
        WeatherItem item = itemWeatherItem.get(position);
        String dayName = DateUtil.getGivenDayOfWeekAsName((position + DateUtil.getTodaysDayOfWeekAsIndex()) % 7);

        holder.txtDayName.setText(dayName);
        holder.txtTemp.setText(TemperatureUtil.getCelcius(item.getTemp().getDay()));
        holder.itemView.setOnClickListener(view -> itemClickListener.onItemClick(item));
    }

    @Override
    public int getItemCount() {
        return itemWeatherItem.size();
    }

    public void setItemWeatherItem(ArrayList<WeatherItem> itemWeatherItem) {
        this.itemWeatherItem = itemWeatherItem;
        notifyDataSetChanged();
    }

}
