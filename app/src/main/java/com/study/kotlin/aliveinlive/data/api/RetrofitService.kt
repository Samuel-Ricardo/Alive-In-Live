package com.study.kotlin.aliveinlive.data.api

import com.study.kotlin.aliveinlive.domain.model.Live
import com.study.kotlin.aliveinlive.interfaces.API
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService: API {

    @GET("lista-live.json")
    override fun getAllLives(): Call<List<Live>>

    companion object {
        private val instance: RetrofitService by lazy {

            val retrofit = Retrofit.Builder()
                .baseUrl("https://d3c0cr0sze1oo6.cloudfront.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofit.create(RetrofitService::class.java)
        }
    }

    override fun getInstance(): API {

        return instance;
    }
}