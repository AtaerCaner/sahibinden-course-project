package com.sahibindencourseproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

import com.bumptech.glide.Glide
import com.sahibindencourseproject.BaseActivity
import com.sahibindencourseproject.R
import com.sahibindencourseproject.api.model.WeatherItem
import com.sahibindencourseproject.util.ResourceUtil
import com.sahibindencourseproject.util.TemperatureUtil

/**
 * Created by Ataer Caner on 2019-12-02.
 * Copyright (c) 2019 sahibinden. All rights reserved.
 */

class DetailFragment : Fragment() {
    private var weatherItem: WeatherItem? = null
    private var txtSelectedStatus: TextView? = null
    private var txtSelectedTemp: TextView? = null
    private var txtDayTemp: TextView? = null
    private var txtMornTemp: TextView? = null
    private var txtNightTemp: TextView? = null
    private var txtEveTemp: TextView? = null
    private var imgSelected: ImageView? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        initViews(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getDatas()
        setContents()
    }

    private fun setContents() {
        Glide.with(this).load(ResourceUtil.getImageUrl(weatherItem!!.weather!![0].icon!!)).into(imgSelected!!)
        txtSelectedStatus!!.text = weatherItem!!.weather!![0].description
        txtSelectedTemp!!.text = TemperatureUtil.getCelcius(weatherItem!!.temp!!.day)

        txtDayTemp!!.text = TemperatureUtil.getCelcius(weatherItem!!.temp!!.day)
        txtMornTemp!!.text = TemperatureUtil.getCelcius(weatherItem!!.temp!!.eve)
        txtNightTemp!!.text = TemperatureUtil.getCelcius(weatherItem!!.temp!!.night)
        txtEveTemp!!.text = TemperatureUtil.getCelcius(weatherItem!!.temp!!.morn)
    }

    private fun initViews(view: View) {
        txtSelectedStatus = view.findViewById(R.id.txtSelectedStatus)
        txtSelectedTemp = view.findViewById(R.id.txtSelectedTemp)
        imgSelected = view.findViewById(R.id.imgSelected)

        txtDayTemp = view.findViewById(R.id.txtDayTemp)
        txtMornTemp = view.findViewById(R.id.txtMornTemp)
        txtNightTemp = view.findViewById(R.id.txtNightTemp)
        txtEveTemp = view.findViewById(R.id.txtEveTemp)
    }

    private fun getDatas() {
        weatherItem = arguments!!.getParcelable(BUNDLE_WEATHER_ITEM)
    }

    companion object {

        val TAG = "DetailFragment"
        val BUNDLE_WEATHER_ITEM = "BUNDLE_WEATHER_ITEM"
    }

}
