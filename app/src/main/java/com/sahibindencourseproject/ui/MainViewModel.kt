package com.sahibindencourseproject.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sahibindencourseproject.api.model.DailyForecastResponse
import com.sahibindencourseproject.api.model.WeatherItem
import com.sahibindencourseproject.manager.NetworkManager
import com.sahibindencourseproject.util.DateUtil
import com.sahibindencourseproject.util.TemperatureUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by Ataer Caner on 2020-01-29.
Copyright (c) 2020 asda. All rights reserved.
 *
 */

class MainViewModel(app: Application) : AndroidViewModel(app) {
    var weatherItem = MutableLiveData<DailyForecastResponse>()



    fun fetchDatas() {
        NetworkManager.getDailyForecast("istanbul").enqueue(object : Callback<DailyForecastResponse> {
            override fun onResponse(call: Call<DailyForecastResponse>, response: Response<DailyForecastResponse>) {
                val body = response.body()
                weatherItem.value = body!!
            }

            override fun onFailure(call: Call<DailyForecastResponse>, t: Throwable) {


            }
        })
    }

    fun getWeatherItem(): LiveData<DailyForecastResponse> {
        return weatherItem
    }





}