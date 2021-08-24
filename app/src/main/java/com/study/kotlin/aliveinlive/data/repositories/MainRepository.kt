package com.study.kotlin.aliveinlive.data.repositories


import com.study.kotlin.aliveinlive.data.api.RetrofitService
import com.study.kotlin.aliveinlive.data.model.Response
import com.study.kotlin.aliveinlive.domain.model.Live
import com.study.kotlin.aliveinlive.interfaces.Repository

class MainRepository
    constructor(private val retrofitService: RetrofitService)
    : Repository {

    override fun getAllLives() = retrofitService.getAllLives()

    /*
     override fun getAllLives(): Response<List<Live>> {

         val allLives = retrofitService.getAllLives().execute()

         return Response(
             allLives.body(),
             allLives.message(),
             allLives.code().toString(),
             allLives.isSuccessful,
         );
     }
    */
}