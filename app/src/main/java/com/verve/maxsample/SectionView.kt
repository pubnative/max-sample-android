package com.verve.maxsample

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SectionView : RecyclerView {

    constructor(context: Context) : this(
        context,
        null
    )

    constructor(context: Context, attrs: AttributeSet?) : this(
        context,
        attrs,
        0
    )

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyle: Int
    ) : super(
        context,
        attrs,
        defStyle
    ) {
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    fun setTabTagAndHelper(contentSection: ContentSection, position: Int) {
        val mrectAdUnitId = when (position) {
            0 -> context.getString(R.string.ad_unit_mrect_0)
            1 -> context.getString(R.string.ad_unit_mrect_1)
            else -> ""
        }
        adapter = ItemAdapter(contentSection.items, mrectAdUnitId)
    }

    fun clear() {
        adapter = null
    }
}