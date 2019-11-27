package com.sahibindencourseproject.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.sahibindencourseproject.BaseActivity;
import com.sahibindencourseproject.R;
import com.sahibindencourseproject.adapter.WeatherItemRecyclerAdapter;
import com.sahibindencourseproject.api.APIClient;
import com.sahibindencourseproject.api.APIInterface;
import com.sahibindencourseproject.api.model.DailyForecastResponse;
import com.sahibindencourseproject.manager.NetworkManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {
    private RecyclerView rcvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcvItems = findViewById(R.id.rcvItems);
        rcvItems.setLayoutManager(new LinearLayoutManager(this));

        NetworkManager.getDailyForecast("istanbul").enqueue(new Callback<DailyForecastResponse>() {
            @Override
            public void onResponse(Call<DailyForecastResponse> call, Response<DailyForecastResponse> response) {
                rcvItems.setAdapter(new WeatherItemRecyclerAdapter(response.body().getList()));
            }

            @Override
            public void onFailure(Call<DailyForecastResponse> call, Throwable t) {
                Log.e("","");

            }
        });
    }
}
