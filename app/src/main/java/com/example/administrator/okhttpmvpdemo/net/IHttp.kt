package com.example.administrator.okhttpmvpdemo.net

interface IHttp {
    fun <T> get(url:String, params: Map<String, String>?, myCallBack: MyCallBack<T>)
    fun <T> post(url :String,params :Map<String,String>,myCallBack: MyCallBack<T>)
    fun downLoad()
}