package com.example.administrator.okhttpmvpdemo.net

class OkHttpFactroy{
    companion object {
        fun create():IHttp{
            return OkHttpUtils.instance
        }
    }
}