package com.example.administrator.okhttpmvpdemo.model.entity


data class InfoBean(
    val resultcode: String,
    val reason: String,
    val result: Any,
    val error_code: Int
)