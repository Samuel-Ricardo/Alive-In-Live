package com.study.kotlin.aliveinlive.presenter.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.study.kotlin.aliveinlive.interfaces.Repository

class MainViewModelFactory
    constructor(private val repository: Repository)
    : ViewModelProvider.Factory
{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            MainViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found <MyApp>")
        }
    }
}