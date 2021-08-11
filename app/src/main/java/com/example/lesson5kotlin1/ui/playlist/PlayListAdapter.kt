package com.example.lesson5kotlin1.ui.playlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lesson5kotlin1.R
import com.example.lesson5kotlin1.model.Items
import com.example.lesson5kotlin1.model.PlayList
import kotlinx.android.synthetic.main.item_list.view.*

class PlayListAdapter : RecyclerView.Adapter<PlayListAdapter.ViewHolder>() {

    private var list: List<Items> = listOf()
    private lateinit var listener: PlayListClickListener

    fun addListener(listener: PlayListClickListener){
        this.listener= listener

    }

    fun addItems(playList: PlayList){
        list = playList.items
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list.get(position),listener)
    }

    override fun getItemCount(): Int {
        return list.size
    }


    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        fun onBind(get: Items, listener: PlayListClickListener) {
            Glide.with(itemView.play_list_image.context)
                .load(get.snippet.thumbnails.medium.url)
                .into(itemView.play_list_image)

            itemView.title.setText(get.snippet.title)
            itemView.quantity.setText(get.snippet.publishedAt)
            itemView.setOnClickListener {
                listener.itemClick(get.id)
            }
        }
    }

    interface PlayListClickListener{
        fun itemClick(id: String)

    }

}