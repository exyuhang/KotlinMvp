package com.example.administrator.okhttpmvpdemo.net

import com.example.administrator.okhttpmvpdemo.App
import okhttp3.*
import java.io.IOException
import com.google.gson.Gson
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type


class OkHttpUtils :IHttp{
    private var okHttpClient :OkHttpClient?=null
    private constructor(){
        okHttpClient=OkHttpClient()
    }

    companion object {
        private var okHttpUtils :OkHttpUtils?=null
        val instance :OkHttpUtils
        @Synchronized get (){
            if (okHttpUtils==null){
                okHttpUtils=OkHttpUtils()
            }
            return okHttpUtils!!
        }
    }

    override fun <T> get(url: String, params: Map<String, String>?, myCallBack: MyCallBack<T>) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        var request : Request =Request.Builder().url(url).build()
        okHttpClient!!.newCall(request).enqueue(object :Callback{
            override fun onFailure(call: Call?, e: IOException?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                App.mActivity!!.runOnUiThread(object :Runnable{
                    override fun run() {
//                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                        myCallBack.Error(e.toString())
                    }

                })
            }

            override fun onResponse(call: Call?, response: Response?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                var jsonData :String = response!!.body().string()
                App.mActivity!!.runOnUiThread(object :Runnable{
                    override fun run() {
//                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                        myCallBack.Success(getGeneric(jsonData,myCallBack))
                    }

                })
            }

        })

    }

    override fun <T> post(url: String, params: Map<String, String>,myCallBack: MyCallBack<T>) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        var formBody : FormBody.Builder =FormBody.Builder()
        if (params!=null&&params.size>0){

        }
//        var request :Request.Builder =Request.Builder().url(url).post()
    }

    override fun downLoad() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

   private fun <T> getGeneric(jsonData :String,myCallBack: MyCallBack<T>) :T{
       var gson :Gson =Gson()
       val types : Array<out Type>? = myCallBack.javaClass.genericInterfaces
       val actualTypeArguments = (types!![0] as ParameterizedType).actualTypeArguments
       val type = actualTypeArguments[0]
       val t = gson.fromJson<T>(jsonData, type)
       return t;
   }

}