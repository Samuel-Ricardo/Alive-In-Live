package com.study.kotlin.aliveinlive.presenter.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.study.kotlin.aliveinlive.R
import com.study.kotlin.aliveinlive.domain.model.Live
import kotlinx.android.synthetic.main.live_item.view.*

class LiveItemAdapter(
    private val context: Context,
    private val liveList: List<Live>,
    private val onItemClicked: (Live) -> Unit
): RecyclerView.Adapter<LiveItemViewHodler>() {

    private var lives = mutableListOf<Live>()

    fun setLiveList(lives: List<Live>) {

        this.lives = lives.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LiveItemViewHodler {

        val view = LayoutInflater.from(context).inflate(R.layout.live_item, parent, false)
        return LiveItemViewHodler(view);
    }

    override fun onBindViewHolder(holder: LiveItemViewHodler, position: Int) {

        holder.bind(
            position,
            liveList,
            onItemClicked
        );
    }

    override fun getItemCount(): Int = liveList.size;
}

class LiveItemViewHodler (itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bind(
        position: Int,
        liveList: List<Live>,
        onItemClicked: (Live) -> Unit
    ) {

        val live = liveList[position]

        with(this.itemView) {

            txtLiveTitle.text = live.title
            txtLiveAuthor.text = live.author

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(context)
                .applyDefaultRequestOptions(requestOptions)
                .load(live.thumbnailURL)
                .into(imgLiveThumbnail)

            this.setOnClickListener {
                onItemClicked(live)
            }
        }
    }
}