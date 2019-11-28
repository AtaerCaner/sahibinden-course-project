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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {
    private RecyclerView rcvItems;
    private TextView txtCurrent;

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
                adapter.setItemWeatherItem(response.body().getWeatherItem());
                txtCurrent.setText(response.body().getWeatherItem().get(0).getTemp().getDay() + " °C");
            }

            @Override
            public void onFailure(Call<DailyForecastResponse> call, Throwable t) {


            }
        });
    }

    private void initViews() {
        rcvItems = findViewById(R.id.rcvItems);
        txtCurrent = findViewById(R.id.txtCurrent);
    }
}
