package com.study.kotlin.aliveinlive.presenter.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.study.kotlin.aliveinlive.R
import com.study.kotlin.aliveinlive.domain.model.Live

class LiveItemAdapte(
    private val context: Context,
    private val liveList: List<Live>,
    private val onItemClicked: (Live) -> Unit
): RecyclerView.Adapter<LiveItemViewHodler>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LiveItemViewHodler {

        val view = LayoutInflater.from(context).inflate(R.layout.live_item, parent, false)
        return LiveItemViewHodler(view);
    }

    override fun onBindViewHolder(holder: LiveItemViewHodler, position: Int) {

    }

    override fun getItemCount(): Int = liveList.size;
}

class LiveItemViewHodler (itemView: View): RecyclerView.ViewHolder(itemView)