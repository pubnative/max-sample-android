package com.verve.maxsample

import android.graphics.Color
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import com.applovin.mediation.MaxAd
import com.applovin.mediation.MaxAdFormat
import com.applovin.mediation.MaxAdViewAdListener
import com.applovin.mediation.MaxError
import com.applovin.mediation.ads.MaxAdView
import com.applovin.sdk.AppLovinSdkUtils

class MrectViewHolder(itemView: View, adUnitId: String) : RecyclerView.ViewHolder(itemView),
    MaxAdViewAdListener {
    private var adView: MaxAdView? = null

    init {
        adView = MaxAdView(adUnitId, MaxAdFormat.MREC, itemView.context)
        adView?.setListener(this)

        val widthPx = AppLovinSdkUtils.dpToPx(itemView.context, 300)
        val heightPx = AppLovinSdkUtils.dpToPx(itemView.context, 250)

        val layoutParams = FrameLayout.LayoutParams(widthPx, heightPx)
        layoutParams.gravity = Gravity.CENTER
        adView?.layoutParams = layoutParams

        // Set background or background color for MRECs to be fully functional
        adView?.setBackgroundColor(Color.WHITE)

        (itemView as FrameLayout).addView(adView);
    }

    fun bind() {
        adView?.loadAd()
    }

    override fun onAdLoaded(ad: MaxAd?) {
        Log.i("MrectAdViewHolder", "onAdLoaded")
    }

    override fun onAdDisplayed(ad: MaxAd?) {
        Log.i("MrectAdViewHolder", "onAdDisplayed")
    }

    override fun onAdHidden(ad: MaxAd?) {
        Log.i("MrectAdViewHolder", "onAdHidden")
    }

    override fun onAdClicked(ad: MaxAd?) {
        Log.i("MrectAdViewHolder", "onAdClicked")
    }

    override fun onAdLoadFailed(adUnitId: String?, error: MaxError?) {
        Log.i("MrectAdViewHolder", "onAdLoadFailed")
        Log.i("MrectAdViewHolder", error?.message.toString())
        Log.i("MrectAdViewHolder", "error code: ".plus(error?.code.toString()))
        Log.i(
            "MrectAdViewHolder",
            "error adLoadFailureInfo: ".plus(error?.adLoadFailureInfo.toString())
        )
    }

    override fun onAdDisplayFailed(ad: MaxAd?, error: MaxError?) {
        Log.i("MrectAdViewHolder", "onAdDisplayFailed")
        Log.i("MrectAdViewHolder", error?.message.toString())
        Log.i("MrectAdViewHolder", "error code: ".plus(error?.code.toString()))
    }

    override fun onAdExpanded(ad: MaxAd?) {
        Log.i("MrectAdViewHolder", "onAdExpanded")
    }

    override fun onAdCollapsed(ad: MaxAd?) {
        Log.i("MrectAdViewHolder", "onAdCollapsed")
    }
}