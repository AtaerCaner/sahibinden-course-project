package com.sahibindencourseproject.ui

import android.database.DatabaseUtils
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment

import com.bumptech.glide.Glide
import com.sahibindencourseproject.BaseActivity
import com.sahibindencourseproject.R
import com.sahibindencourseproject.api.model.WeatherItem
import com.sahibindencourseproject.databinding.FragmentDetailBinding
import com.sahibindencourseproject.util.ResourceUtil
import com.sahibindencourseproject.util.TemperatureUtil
import kotlinx.android.synthetic.main.fragment_detail.*

/**
 * Created by Ataer Caner on 2019-12-02.
 * Copyright (c) 2019 sahibinden. All rights reserved.
 */

class DetailFragment : Fragment() {
    val weatherItem by lazy {arguments?.getParcelable<WeatherItem>(BUNDLE_WEATHER_ITEM)!! }

    private lateinit var detailBinding: FragmentDetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        detailBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setContents()
    }

    private fun setContents() {
        Glide.with(this).load(ResourceUtil.getImageUrl(weatherItem!!.weather!![0].icon!!)).into(imgSelected!!)
    }




    companion object {
        const val TAG = "DetailFragment"
        const val BUNDLE_WEATHER_ITEM = "BUNDLE_WEATHER_ITEM"
    }

}
