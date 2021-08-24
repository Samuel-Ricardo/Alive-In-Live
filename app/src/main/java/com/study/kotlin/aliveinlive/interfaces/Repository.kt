package com.study.kotlin.aliveinlive.interfaces

import com.study.kotlin.aliveinlive.data.model.Response
import com.study.kotlin.aliveinlive.domain.model.Live
import retrofit2.Call

interface Repository {

    fun getAllLives(): Response<List<Live>>
}