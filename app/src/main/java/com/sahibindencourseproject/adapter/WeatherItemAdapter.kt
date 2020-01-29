package com.sahibindencourseproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

import com.sahibindencourseproject.R
import com.sahibindencourseproject.api.model.WeatherItem
import com.sahibindencourseproject.databinding.ItemWeatherBindingImpl
import com.sahibindencourseproject.util.DateUtil
import com.sahibindencourseproject.util.TemperatureUtil

import java.util.ArrayList

/**
 * Created by Ataer Caner on 2019-11-27.
 * Copyright (c) 2019 sahibinden. All rights reserved.
 */

class WeatherItemAdapter(private val itemClickListener: (WeatherItem) -> Unit) : RecyclerView.Adapter<WeatherItemAdapter.WeatherItemsViewHolder>() {
    private var itemWeatherItem: ArrayList<WeatherItem>? = null


    class WeatherItemsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtDayName: TextView = view.findViewById(R.id.txtDayName)
        val txtTemp: TextView = view.findViewById(R.id.txtTemp)
    }


    init {
        itemWeatherItem = ArrayList()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherItemsViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_weather, parent, false)
        ItemWeatherBindingImpl


        return WeatherItemsViewHolder(v)
    }


    override fun onBindViewHolder(holder: WeatherItemsViewHolder, position: Int) {
        val item = itemWeatherItem!![position]
        val dayName = DateUtil.getGivenDayOfWeekAsName((position + DateUtil.todaysDayOfWeekAsIndex) % 7)

        holder.txtDayName.text = dayName
        holder.txtTemp.text = TemperatureUtil.getCelcius(item.temp!!.day)
        holder.itemView.setOnClickListener { itemClickListener.invoke(item) }
    }

    override fun getItemCount(): Int {
        return itemWeatherItem!!.size
    }

    fun setItemWeatherItem(itemWeatherItem: ArrayList<WeatherItem>) {
        this.itemWeatherItem = itemWeatherItem
        notifyDataSetChanged()
    }

}
