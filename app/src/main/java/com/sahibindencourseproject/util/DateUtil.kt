package com.sahibindencourseproject.util

import java.util.Calendar

/**
 * Created by Ataer Caner on 2019-12-02.
 * Copyright (c) 2019 sahibinden. All rights reserved.
 */

object DateUtil {
    private val days = arrayOf("Pazartesi", "Salı", "Carsamba", "Persembe", "Cuma", "Cumartesi", "Pazar")

    val todaysDayOfWeekAsIndex: Int
        get() {
            val c = Calendar.getInstance()
            return c.get(Calendar.DAY_OF_WEEK) - 1
        }

    val todaysDayOfWeekAsName: String
        get() = getGivenDayOfWeekAsName(todaysDayOfWeekAsIndex)

    fun getGivenDayOfWeekAsName(index: Int): String {
        return days[index]
    }
}
