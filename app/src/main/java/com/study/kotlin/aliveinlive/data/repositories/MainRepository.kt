package com.study.kotlin.aliveinlive.data.repositories


import com.study.kotlin.aliveinlive.data.api.RetrofitService
import com.study.kotlin.aliveinlive.interfaces.Repository

class MainRepository
    constructor(private val retrofitService: RetrofitService)
    : Repository {

     override fun getAllLives() = retrofitService.getAllLives()
}