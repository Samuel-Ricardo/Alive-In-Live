package com.study.kotlin.aliveinlive.presenter.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.study.kotlin.aliveinlive.R
import com.study.kotlin.aliveinlive.data.api.RetrofitService
import com.study.kotlin.aliveinlive.data.repositories.MainRepository
import com.study.kotlin.aliveinlive.interfaces.API
import com.study.kotlin.aliveinlive.presenter.adapter.LiveItemAdapter
import com.study.kotlin.aliveinlive.presenter.main.viewmodel.MainViewModel
import com.study.kotlin.aliveinlive.presenter.main.viewmodel.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    private val api: API = RetrofitService.getInstance();
    private val adapter: LiveItemAdapter{

    };

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setup()
    }

    fun setup(){
        setupViewModel()
        setupRecyvlerView()
    }

    fun setupViewModel(){
        viewModel = ViewModelProvider(
            this,
            MainViewModelFactory(
                MainRepository(
                    api as RetrofitService
                )
            )
        ).get(MainViewModel::class.java)
    }

    fun setupRecyvlerView(){
        rcvLives.layoutManager = LinearLayoutManager(this)
    }
}
