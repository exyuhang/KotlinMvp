package com.example.administrator.okhttpmvpdemo.model.zip

import com.example.administrator.okhttpmvpdemo.fragment.OkHttpFragment
import com.example.administrator.okhttpmvpdemo.model.entity.InfoBean
import com.example.administrator.okhttpmvpdemo.net.MyCallBack
import com.example.administrator.okhttpmvpdemo.net.Urls

class OkHttpFragmentImpl :IOkhttpFragmentModel{
    override fun getInfo(myCallBack: MyCallBack<InfoBean>) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        iHttp().get(Urls.INFO_URL,OkHttpFragment.mapInfo,myCallBack)
    }
}