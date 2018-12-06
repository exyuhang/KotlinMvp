package com.example.administrator.okhttpmvpdemo

import android.app.Activity
import android.app.Application
import android.support.v4.app.FragmentActivity
import com.example.administrator.okhttpmvpdemo.base.BaseFragment

class App : Application() {

    companion object {
        var mActivity :Activity?=null
        var mFragment:BaseFragment?=null
        var mFragmentActivity: FragmentActivity?=null
    }

    override fun onCreate() {
        super.onCreate()
    }
}