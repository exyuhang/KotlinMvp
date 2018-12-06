package com.example.administrator.okhttpmvpdemo.model.zip

import com.example.administrator.okhttpmvpdemo.net.IHttp
import com.example.administrator.okhttpmvpdemo.net.OkHttpFactroy

interface BaseModel{
    fun iHttp():IHttp=OkHttpFactroy.create()
}