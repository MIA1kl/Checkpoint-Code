package com.android.checkpoint.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.checkpoint.R
import com.android.checkpoint.model.ItemModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item.view.*
import java.util.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private var data: List<ItemModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item, parent, false)
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(data[position])

    fun swapData(data: List<ItemModel>) {
        this.data = data
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: ItemModel) = with(itemView) {
        Glide.with(this).load(item.image).into(itemView.image_IV)
        itemView.title_TV.text = item.title
    }
    }
}