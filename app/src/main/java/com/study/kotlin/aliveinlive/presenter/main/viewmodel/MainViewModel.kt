package com.study.kotlin.aliveinlive.presenter.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.study.kotlin.aliveinlive.data.repositories.MainRepository
import com.study.kotlin.aliveinlive.domain.model.Live
import com.study.kotlin.aliveinlive.interfaces.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel
    constructor(
        private val repository: Repository
    )
    : ViewModel() {

    val liveList = MutableLiveData<List<Live>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllLives() {

        val request = repository.getAllLives()

        request.enqueue(object: Callback<List<Live>>{
            override fun onResponse(call: Call<List<Live>>, response: Response<List<Live>>) {

                liveList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Live>>, t: Throwable) {

                errorMessage.postValue(t.message)
            }
        })
    }
}