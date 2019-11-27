package com.sahibindencourseproject.api;

import com.sahibindencourseproject.api.model.DailyForecastResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Ataer Caner on 2019-11-22.
 * Copyright (c) 2019 saihinbden. All rights reserved.
 */

public interface APIInterface {

    @GET("daily")
    Call<DailyForecastResponse> getDailyForecast(@Query("q") String cityName, @Query("units") String unit, @Query("cnt") int count, @Query("appid") String appid);
}
