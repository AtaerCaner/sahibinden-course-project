package com.sahibindencourseproject.util

/**
 * Created by Ataer Caner on 2019-12-02.
 * Copyright (c) 2019 sahibinden. All rights reserved.
 */

object TemperatureUtil {

    fun getCelcius(temp: Double?): String {
        return Math.round(temp!!).toString() + "°"
    }
}
