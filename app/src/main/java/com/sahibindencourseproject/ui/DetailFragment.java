package com.sahibindencourseproject.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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

public class DetailFragment extends Fragment {

    public static final String TAG = "DetailFragment";
    public static final String BUNDLE_WEATHER_ITEM = "BUNDLE_WEATHER_ITEM";
    private WeatherItem weatherItem;
    private TextView txtSelectedStatus;
    private TextView txtSelectedTemp;
    private TextView txtDayTemp;
    private TextView txtMornTemp;
    private TextView txtNightTemp;
    private TextView txtEveTemp;
    private ImageView imgSelected;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        initViews(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getDatas();
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

    private void initViews(View view) {
        txtSelectedStatus = view.findViewById(R.id.txtSelectedStatus);
        txtSelectedTemp = view.findViewById(R.id.txtSelectedTemp);
        imgSelected = view.findViewById(R.id.imgSelected);

        txtDayTemp = view.findViewById(R.id.txtDayTemp);
        txtMornTemp = view.findViewById(R.id.txtMornTemp);
        txtNightTemp = view.findViewById(R.id.txtNightTemp);
        txtEveTemp = view.findViewById(R.id.txtEveTemp);
    }

    private void getDatas() {
        weatherItem = getArguments().getParcelable(BUNDLE_WEATHER_ITEM);
    }

}
