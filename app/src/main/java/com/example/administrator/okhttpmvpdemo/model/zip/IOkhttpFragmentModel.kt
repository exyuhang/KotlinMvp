package com.example.administrator.okhttpmvpdemo.model.zip

import com.example.administrator.okhttpmvpdemo.model.entity.InfoBean
import com.example.administrator.okhttpmvpdemo.net.MyCallBack

interface IOkhttpFragmentModel :BaseModel{
    fun getInfo(myCallBack: MyCallBack<InfoBean>)
}