package com.example.administrator.okhttpmvpdemo.net

interface MyCallBack<T> {
    fun Success(t :T)
    fun Error(error :String)
}