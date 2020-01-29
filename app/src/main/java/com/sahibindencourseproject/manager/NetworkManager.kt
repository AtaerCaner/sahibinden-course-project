package com.sahibindencourseproject.manager

import com.sahibindencourseproject.BuildConfig
import com.sahibindencourseproject.api.APIClient
import com.sahibindencourseproject.api.APIInterface
import com.sahibindencourseproject.api.model.DailyForecastResponse

import retrofit2.Call

/**
 * Created by Ataer Caner on 2019-11-22.
 * Copyright (c) 2019 sahibinden. All rights reserved.
 */

object NetworkManager {

    private var apiInterface: APIInterface? = null
    private val API_KEY = BuildConfig.API_KEY
    private val CELSIUS = "metric"


    private val apiInterfaceInstance: APIInterface
        get() {
            if (apiInterface == null) {
                apiInterface = APIClient.client.create(APIInterface::class.java)
            }
            return apiInterface!!
        }

    fun getDailyForecast(city: String): Call<DailyForecastResponse> {
        return apiInterfaceInstance.getDailyForecast(city, CELSIUS, 10, API_KEY)
    }
}
