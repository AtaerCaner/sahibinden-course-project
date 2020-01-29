package com.sahibindencourseproject.ui

import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import android.os.Bundle
import android.widget.TextView

import com.sahibindencourseproject.BaseActivity
import com.sahibindencourseproject.R
import com.sahibindencourseproject.adapter.WeatherItemAdapter
import com.sahibindencourseproject.api.model.DailyForecastResponse
import com.sahibindencourseproject.manager.NetworkManager
import com.sahibindencourseproject.util.DateUtil
import com.sahibindencourseproject.util.TemperatureUtil

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : BaseActivity() {
    private var rcvItems: RecyclerView? = null
    private var txtCurrentTemp: TextView? = null
    private var txtCurrentDay: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()

        rcvItems!!.layoutManager = LinearLayoutManager(this)

        val adapter = WeatherItemAdapter{ weatherItem ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.BUNDLE_WEATHER_ITEM, weatherItem)
            startActivity(intent)
        }

        rcvItems!!.adapter = adapter

        NetworkManager.getDailyForecast("istanbul").enqueue(object : Callback<DailyForecastResponse> {
            override fun onResponse(call: Call<DailyForecastResponse>, response: Response<DailyForecastResponse>) {
                val body = response.body()

                adapter.setItemWeatherItem(body!!.weatherItem!!)
                txtCurrentDay!!.setText(DateUtil.todaysDayOfWeekAsName)
                txtCurrentTemp!!.text = TemperatureUtil.getCelcius(body.weatherItem!![0].temp!!.day)
            }

            override fun onFailure(call: Call<DailyForecastResponse>, t: Throwable) {


            }
        })
    }

    private fun initViews() {
        rcvItems = findViewById(R.id.rcvItems)
        txtCurrentTemp = findViewById(R.id.txtCurrentTemp)
        txtCurrentDay = findViewById(R.id.txtCurrentDay)
    }
}
