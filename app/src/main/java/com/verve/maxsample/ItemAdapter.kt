package com.verve.maxsample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ItemAdapter(private val items: List<ContentItem>, val mrectAdUnitId: String) :
    RecyclerView.Adapter<ViewHolder>() {
    companion object {
        const val TYPE_ITEM = 0
        const val TYPE_MRECT = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if (viewType == TYPE_MRECT) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_mrect, parent, false)
            MrectViewHolder(view, mrectAdUnitId)
        } else {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_item, parent, false)
            ItemViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder is MrectViewHolder) {
            holder.bind()
        } else if (holder is ItemViewHolder) {
            holder.bind(items[position])
        }
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int) =
        if (position == items.size - 1 && mrectAdUnitId.isNotEmpty()) {
            TYPE_MRECT
        } else {
            TYPE_ITEM
        }
}