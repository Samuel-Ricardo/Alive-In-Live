package com.study.kotlin.aliveinlive.data.model

import retrofit2.Call

data class Response<T>(
    val data: T?,
    val message: String,
    val code: String,
    val isSuccessful: Boolean
)
