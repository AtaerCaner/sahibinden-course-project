package com.sahibindencourseproject.extensions

import androidx.annotation.IdRes
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager


/**
 * Created by Ataer Caner on 2020-01-29.
Copyright (c) 2020 sahibinden. All rights reserved.
 *
 */


    fun FragmentManager.commitToAdd(@IdRes containerViewId:Int,fragment: Fragment, tag: String) {
        this.beginTransaction().add(containerViewId, fragment, tag).commit()
    }