package com.study.kotlin.aliveinlive.presenter.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import com.study.kotlin.aliveinlive.R
import com.study.kotlin.aliveinlive.data.api.RetrofitService
import com.study.kotlin.aliveinlive.interfaces.API
import com.study.kotlin.aliveinlive.presenter.adapter.LiveItemAdapter
import com.study.kotlin.aliveinlive.presenter.main.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    private val api: API = RetrofitService.getInstance();
    private val adapter: LiveItemAdapter{

    };

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
