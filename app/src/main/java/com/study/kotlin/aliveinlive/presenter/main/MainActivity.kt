package com.study.kotlin.aliveinlive.presenter.main

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.study.kotlin.aliveinlive.R
import com.study.kotlin.aliveinlive.data.api.RetrofitService
import com.study.kotlin.aliveinlive.data.repositories.MainRepository
import com.study.kotlin.aliveinlive.domain.model.Live
import com.study.kotlin.aliveinlive.interfaces.API
import com.study.kotlin.aliveinlive.presenter.adapter.LiveItemAdapter
import com.study.kotlin.aliveinlive.presenter.main.viewmodel.MainViewModel
import com.study.kotlin.aliveinlive.presenter.main.viewmodel.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    lateinit var viewModel: MainViewModel
    private val api: API = RetrofitService.getInstance();
    private var adapter: LiveItemAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setup()
    }

    override fun onStart() {
        super.onStart()

        viewModel.liveList.observe(this, Observer { lives ->

            Log.d(TAG,"onCreate: $lives")
            adapter.setL
        })
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
        rcvLives.layoutManager = LinearLayoutManager(this);
        rcvLives.adapter = setupAdapter();
    }

    fun setupAdapter(): LiveItemAdapter{
        adapter = LiveItemAdapter(
            this,
            mutableListOf<Live>()
        ) {
            onClickItem(it)
        }

        return adapter as LiveItemAdapter;
    }

    private fun onClickItem(it: Live) {

    }
}
