package com.sahibindencourseproject.ui

import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.sahibindencourseproject.BaseActivity
import com.sahibindencourseproject.R
import com.sahibindencourseproject.adapter.WeatherItemAdapter
import com.sahibindencourseproject.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private lateinit var adapter: WeatherItemAdapter

    private val mainActivityViewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        rcvItems!!.layoutManager = LinearLayoutManager(this)

        adapter = WeatherItemAdapter{ weatherItem ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.BUNDLE_WEATHER_ITEM, weatherItem)
            startActivity(intent)
        }

        rcvItems!!.adapter = adapter


        mainActivityViewModel.getWeatherItem().observe(this, Observer {
            print(it)
            adapter.setItemWeatherItem(it.weatherItem!!)
            binding.dailyWeather = it
        })

        mainActivityViewModel.fetchDatas()

    }




}
