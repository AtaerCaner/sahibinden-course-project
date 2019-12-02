package com.sahibindencourseproject.ui;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.sahibindencourseproject.BaseActivity;
import com.sahibindencourseproject.R;
import com.sahibindencourseproject.adapter.WeatherItemRecyclerAdapter;
import com.sahibindencourseproject.api.model.DailyForecastResponse;
import com.sahibindencourseproject.api.model.WeatherItem;
import com.sahibindencourseproject.manager.NetworkManager;
import com.sahibindencourseproject.util.TemperatureUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {
    private RecyclerView rcvItems;
    private TextView txtCurrentTemp, txtCurrentStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        rcvItems.setLayoutManager(new LinearLayoutManager(this));
        WeatherItemRecyclerAdapter adapter = new WeatherItemRecyclerAdapter(weatherItem -> {

        });
        rcvItems.setAdapter(adapter);

        NetworkManager.getDailyForecast("istanbul").enqueue(new Callback<DailyForecastResponse>() {
            @Override
            public void onResponse(Call<DailyForecastResponse> call, Response<DailyForecastResponse> response) {
                DailyForecastResponse body = response.body();
                adapter.setItemWeatherItem(body.getWeatherItem());
                txtCurrentTemp.setText(TemperatureUtil.getCelcius(body.getWeatherItem().get(0).getTemp().getDay()));
                txtCurrentStatus.setText(body.getWeatherItem().get(0).getWeather().get(0).getMain());
            }

            @Override
            public void onFailure(Call<DailyForecastResponse> call, Throwable t) {


            }
        });
    }

    private void initViews() {
        rcvItems = findViewById(R.id.rcvItems);
        txtCurrentTemp = findViewById(R.id.txtCurrentTemp);
        txtCurrentStatus = findViewById(R.id.txtCurrentStatus);
    }
}
