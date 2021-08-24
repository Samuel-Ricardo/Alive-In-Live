package com.study.kotlin.aliveinlive.interfaces

import com.study.kotlin.aliveinlive.domain.model.Live
import retrofit2.Call

interface API {

    fun getAllLives(): Call<List<Live>>

    fun getInstance(): API
}