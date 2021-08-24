package com.study.kotlin.aliveinlive.presenter.main

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
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
            adapter?.setLiveList(lives)
        })

        viewModel.errorMessage.observe(
            this,
            Observer {message ->
                Toast.makeText(
                    this,
                    message,
                    Toast.LENGTH_LONG
                )
            }
        )
    }

    override fun onResume() {
        super.onResume()

        viewModel.getAllLives()
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

    private fun onClickItem(live: Live) {

        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(live.link))
        startActivity(browserIntent);
    }
}
