package com.sahibindencourseproject.util;

import java.util.Calendar;

/**
 * Created by Ataer Caner on 2019-12-02.
 * Copyright (c) 2019 sahibinden. All rights reserved.
 */

public class DateUtil {
    private static String[] days = {"Pazartesi", "Salı","Carsamba","Persembe","Cuma","Cumartesi","Pazar"};

    public static int getTodaysDayOfWeekAsIndex() {
        final Calendar c = Calendar.getInstance();
        return c.get(Calendar.DAY_OF_WEEK) - 1;
    }

    public static String getTodaysDayOfWeekAsName() {
        return getGivenDayOfWeekAsName(getTodaysDayOfWeekAsIndex());
    }

    public static String getGivenDayOfWeekAsName(int index) {
        return days[index];
    }
}
