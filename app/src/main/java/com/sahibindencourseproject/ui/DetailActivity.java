package com.sahibindencourseproject.ui;

import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sahibindencourseproject.BaseActivity;
import com.sahibindencourseproject.R;
import com.sahibindencourseproject.api.model.WeatherItem;
import com.sahibindencourseproject.util.ResourceUtil;
import com.sahibindencourseproject.util.TemperatureUtil;

/**
 * Created by Ataer Caner on 2019-12-02.
 * Copyright (c) 2019 sahibinden. All rights reserved.
 */

public class DetailActivity extends BaseActivity {

    public static final String BUNDLE_WEATHER_ITEM = "BUNDLE_WEATHER_ITEM";
    private WeatherItem weatherItem;
    private TextView txtSelectedStatus;
    private TextView txtSelectedTemp;
    private ImageView imgSelected;
    private RecyclerView rcvDaysTemp;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getDatas();
        initViews();
        setContents();
    }

    private void setContents() {
        Glide.with(this).load(ResourceUtil.getImageUrl(weatherItem.getWeather().get(0).getIcon())).into(imgSelected);
        txtSelectedStatus.setText(weatherItem.getWeather().get(0).getDescription());
        txtSelectedTemp.setText(TemperatureUtil.getCelcius(weatherItem.getTemp().getDay()));
    }

    private void initViews() {
        txtSelectedStatus = findViewById(R.id.txtSelectedStatus);
        txtSelectedTemp = findViewById(R.id.txtSelectedTemp);
        imgSelected = findViewById(R.id.imgSelected);
        rcvDaysTemp = findViewById(R.id.rcvDaysTemp);
    }

    private void getDatas() {
        weatherItem = getIntent().getParcelableExtra(BUNDLE_WEATHER_ITEM);
    }

}
