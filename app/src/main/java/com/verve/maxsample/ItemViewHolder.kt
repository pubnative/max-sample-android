package com.verve.maxsample

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val titleView = itemView.findViewById<TextView>(R.id.view_title)

    fun bind(item: ContentItem) {
        titleView.text = item.name
    }
}