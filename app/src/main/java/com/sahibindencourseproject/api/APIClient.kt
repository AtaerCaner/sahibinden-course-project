package com.sahibindencourseproject.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Ataer Caner on 2019-11-22.
 * Copyright (c) 2019 sahibinden. All rights reserved.
 */

object APIClient {
    private var retrofit: Retrofit? = null

    val client: Retrofit
        get() {
            val client = OkHttpClient.Builder().build()


            retrofit = Retrofit.Builder()
                    .baseUrl("https://api.openweathermap.org/data/2.5/forecast/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build()

            return retrofit!!
        }
}
