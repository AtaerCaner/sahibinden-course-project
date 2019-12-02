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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        WeatherItem weatherItem = getIntent().getParcelableExtra(BUNDLE_WEATHER_ITEM);

        Bundle bundle = new Bundle();
        bundle.putParcelable(DetailFragment.BUNDLE_WEATHER_ITEM, weatherItem);

        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().add(R.id.frameDetail, detailFragment, DetailFragment.TAG).commit();
    }




}
