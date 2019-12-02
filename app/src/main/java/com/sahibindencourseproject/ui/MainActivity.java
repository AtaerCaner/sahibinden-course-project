package com.sahibindencourseproject.ui;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.sahibindencourseproject.BaseActivity;
import com.sahibindencourseproject.R;
import com.sahibindencourseproject.adapter.WeatherItemAdapter;
import com.sahibindencourseproject.api.model.DailyForecastResponse;
import com.sahibindencourseproject.manager.NetworkManager;
import com.sahibindencourseproject.util.DateUtil;
import com.sahibindencourseproject.util.TemperatureUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {
    private RecyclerView rcvItems;
    private TextView txtCurrentTemp, txtCurrentDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        rcvItems.setLayoutManager(new LinearLayoutManager(this));

        WeatherItemAdapter adapter = new WeatherItemAdapter(weatherItem -> {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.BUNDLE_WEATHER_ITEM, weatherItem);
            startActivity(intent);
        });

        rcvItems.setAdapter(adapter);

        NetworkManager.getDailyForecast("istanbul").enqueue(new Callback<DailyForecastResponse>() {
            @Override
            public void onResponse(Call<DailyForecastResponse> call, Response<DailyForecastResponse> response) {
                DailyForecastResponse body = response.body();

                adapter.setItemWeatherItem(body.getWeatherItem());
                txtCurrentDay.setText(DateUtil.getTodaysDayOfWeekAsName());
                txtCurrentTemp.setText(TemperatureUtil.getCelcius(body.getWeatherItem().get(0).getTemp().getDay()));
            }

            @Override
            public void onFailure(Call<DailyForecastResponse> call, Throwable t) {


            }
        });
    }

    private void initViews() {
        rcvItems = findViewById(R.id.rcvItems);
        txtCurrentTemp = findViewById(R.id.txtCurrentTemp);
        txtCurrentDay = findViewById(R.id.txtCurrentDay);
    }
}
