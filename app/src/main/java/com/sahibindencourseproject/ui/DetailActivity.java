package com.sahibindencourseproject.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

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
    private TextView txtDayTemp;
    private TextView txtMornTemp;
    private TextView txtNightTemp;
    private TextView txtEveTemp;
    private ImageView imgSelected;


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
        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 0 :
                    txtDayTemp.setText(TemperatureUtil.getCelcius(weatherItem.getTemp().getDay()));
                    break;
                case 1 :
                    txtMornTemp.setText(TemperatureUtil.getCelcius(weatherItem.getTemp().getEve()));
                    break;
                case 2 :
                    txtNightTemp.setText(TemperatureUtil.getCelcius(weatherItem.getTemp().getNight()));
                    break;
                case 3 :
                    txtEveTemp.setText(TemperatureUtil.getCelcius(weatherItem.getTemp().getMorn()));
                    break;

            }
        }
    }

    private void initViews() {
        txtSelectedStatus = findViewById(R.id.txtSelectedStatus);
        txtSelectedTemp = findViewById(R.id.txtSelectedTemp);
        imgSelected = findViewById(R.id.imgSelected);

        txtDayTemp = findViewById(R.id.txtDayTemp);
        txtMornTemp = findViewById(R.id.txtMornTemp);
        txtNightTemp = findViewById(R.id.txtNightTemp);
        txtEveTemp = findViewById(R.id.txtEveTemp);
    }

    private void getDatas() {
        weatherItem = getIntent().getParcelableExtra(BUNDLE_WEATHER_ITEM);
    }

}
