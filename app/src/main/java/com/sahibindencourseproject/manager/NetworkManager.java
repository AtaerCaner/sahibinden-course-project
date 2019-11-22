package com.sahibindencourseproject.manager;

import com.sahibindencourseproject.BuildConfig;
import com.sahibindencourseproject.api.APIClient;
import com.sahibindencourseproject.api.APIInterface;
import com.sahibindencourseproject.api.model.DailyForecastResponse;

import retrofit2.Call;

/**
 * Created by Ataer Caner on 2019-11-22.
 * Copyright (c) 2019 sahibinden. All rights reserved.
 */

public class NetworkManager {

    private static APIInterface apiInterface;
    private static String API_KEY = BuildConfig.API_KEY;

    private static APIInterface getApiInterfaceInstance() {
        if (apiInterface == null) {
            apiInterface = APIClient.getClient().create(APIInterface.class);
        }
        return apiInterface;
    }

    public static Call<DailyForecastResponse> getDailyForecast(String city) {
        return getApiInterfaceInstance().getDailyForecast(city, 10, API_KEY);
    }
}
