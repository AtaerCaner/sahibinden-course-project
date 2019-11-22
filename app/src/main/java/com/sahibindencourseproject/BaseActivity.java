package com.sahibindencourseproject;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sahibindencourseproject.api.APIClient;
import com.sahibindencourseproject.api.APIInterface;

/**
 * Created by Ataer Caner on 2019-11-22.
 * Copyright (c) 2019 sahibinden. All rights reserved.
 */

public class BaseActivity extends AppCompatActivity {
    public APIInterface apiInterface;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
}
