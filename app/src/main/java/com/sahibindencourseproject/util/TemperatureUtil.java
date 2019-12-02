package com.sahibindencourseproject.util;

/**
 * Created by Ataer Caner on 2019-12-02.
 * Copyright (c) 2019 sahibinden. All rights reserved.
 */

public class TemperatureUtil {

    public static String getCelcius(Double temp) {
        return Math.round(temp) + "°";
    }
}
