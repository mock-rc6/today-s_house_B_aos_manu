package com.manu.todayhouse.src.main.home.popluar.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.manu.todayhouse.R
import com.manu.todayhouse.src.main.home.popluar.model.Result

class PopluarBannerAdapter(var imageData : List<Result>) : RecyclerView.Adapter<PopluarBannerAdapter.BannerAdapter>() {

    inner class BannerAdapter(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.popluar_banner_item, parent, false)
    ) {
        val bannerItemList = itemView.findViewById<ImageView>(R.id.banner_item_img)

        fun onBindWith(ImageList : Result) {
            bannerItemList.clipToOutline = true
            Glide.with(itemView).load(ImageList.bannerPic).into(bannerItemList)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerAdapter {
        return BannerAdapter((parent))
    }

    override fun onBindViewHolder(holder: BannerAdapter, position: Int) {
        holder.onBindWith(imageData[position])
    }

    override fun getItemCount(): Int {
        return imageData.size
    }
}