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
    private val live:Live,
    private val onItemClicked: (Live) -> Unit
): RecyclerView.Adapter<LiveItemViewHodler>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LiveItemViewHodler {

        val view = LayoutInflater.from(context).inflate(R.layout.live_item, parent, false)
        return LiveItemViewHodler(view);

    }

    override fun onBindViewHolder(holder: LiveItemViewHodler, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}

class LiveItemViewHodler (itemView: View): RecyclerView.ViewHolder(itemView)