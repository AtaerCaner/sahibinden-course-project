package com.sahibindencourseproject.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Ataer Caner on 2019-12-02.
 * Copyright (c) 2019 sahibinden. All rights reserved.
 */

public class DetailItemsAdapter extends RecyclerView.Adapter<DetailItemsAdapter.DetailsHolder> {


    @NonNull
    @Override
    public DetailsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class DetailsHolder extends RecyclerView.ViewHolder {

        public DetailsHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}

