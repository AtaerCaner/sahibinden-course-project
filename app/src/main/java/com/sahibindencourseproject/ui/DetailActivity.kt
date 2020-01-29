package com.sahibindencourseproject.ui

import android.os.Bundle
import com.sahibindencourseproject.BaseActivity
import com.sahibindencourseproject.R
import com.sahibindencourseproject.api.model.WeatherItem
import com.sahibindencourseproject.extensions.commitToAdd

/**
 * Created by Ataer Caner on 2019-12-02.
 * Copyright (c) 2019 sahibinden. All rights reserved.
 */

class DetailActivity : BaseActivity() {
    private val weatherItem: WeatherItem by lazy { intent.getParcelableExtra<WeatherItem>(BUNDLE_WEATHER_ITEM) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val bundle = Bundle()
        bundle.putParcelable(DetailFragment.BUNDLE_WEATHER_ITEM, weatherItem)

        val detailFragment = DetailFragment()
        detailFragment.arguments = bundle

        supportFragmentManager.commitToAdd(R.id.frameDetail, detailFragment, DetailFragment.TAG)
    }

    companion object {
        const val BUNDLE_WEATHER_ITEM = "BUNDLE_WEATHER_ITEM"
    }


}
