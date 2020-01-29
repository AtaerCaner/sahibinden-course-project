package com.sahibindencourseproject.util

/**
 * Created by Ataer Caner on 2019-12-02.
 * Copyright (c) 2019 sahibinden. All rights reserved.
 */

object ResourceUtil {
    fun getImageUrl(iconName: String): String {
        return "http://openweathermap.org/img/wn/$iconName@2x.png"
    }
}
