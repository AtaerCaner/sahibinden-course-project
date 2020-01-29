package com.sahibindencourseproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

import com.sahibindencourseproject.R
import com.sahibindencourseproject.api.model.WeatherItem
import com.sahibindencourseproject.databinding.ItemWeatherBinding
import com.sahibindencourseproject.util.DateUtil
import com.sahibindencourseproject.util.TemperatureUtil

import java.util.ArrayList

/**
 * Created by Ataer Caner on 2019-11-27.
 * Copyright (c) 2019 sahibinden. All rights reserved.
 */

class WeatherItemAdapter(private val itemClickListener: (WeatherItem) -> Unit) : RecyclerView.Adapter<WeatherItemAdapter.WeatherItemsViewHolder>() {
    private var itemWeatherItem: ArrayList<WeatherItem>? = null

    class WeatherItemsViewHolder(private val binding: ItemWeatherBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(position: Int, item:WeatherItem, itemClickListener: (WeatherItem) -> Unit) {
            binding.position = position
            binding.weatherItem = item
            binding.root.setOnClickListener { itemClickListener.invoke(item) }
            binding.executePendingBindings()
        }
    }

    init {
        itemWeatherItem = ArrayList()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherItemsViewHolder {
        var binding = ItemWeatherBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return WeatherItemsViewHolder(binding)
    }


    override fun onBindViewHolder(holder: WeatherItemsViewHolder, position: Int) {
        val item = itemWeatherItem!![position]
        holder.bind(position,item,itemClickListener)
/*
        holder.tempBinding.position = position
        holder.tempBinding.weatherItem = item
        holder.tempBinding.root.setOnClickListener { itemClickListener.invoke(item) }
        holder.tempBinding.executePendingBindings()

 */
    }

    override fun getItemCount(): Int {
        return itemWeatherItem!!.size
    }

    fun setItemWeatherItem(itemWeatherItem: ArrayList<WeatherItem>) {
        this.itemWeatherItem = itemWeatherItem
        notifyDataSetChanged()
    }

}
