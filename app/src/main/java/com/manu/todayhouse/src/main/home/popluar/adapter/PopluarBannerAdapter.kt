package com.manu.todayhouse.src.main.home.popluar.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.manu.todayhouse.R
import com.manu.todayhouse.src.main.home.popluar.eventpage.model.Result
import com.manu.todayhouse.src.main.home.popluar.eventpage.EventPagectivity

class PopluarBannerAdapter(var imageData : List<Result>) : RecyclerView.Adapter<PopluarBannerAdapter.BannerAdapter>() {

    inner class BannerAdapter(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.popluar_banner_item, parent, false)
    ) {
        val bannerItemList = itemView.findViewById<ImageView>(R.id.banner_item_img)

        fun onBindWith(ImageList : Result) {
            bannerItemList.clipToOutline = true
            Glide.with(itemView).load(ImageList.bannerPic).into(bannerItemList)
            bannerItemList.setOnClickListener {
                val intent = Intent(itemView.context, EventPagectivity::class.java)
                intent.run { itemView.context.startActivity(this) }
            }
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