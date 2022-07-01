package com.manu.todayhouse.src.main.store.storehome.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.manu.todayhouse.R
import com.manu.todayhouse.src.main.store.storehome.model.EventImg

class StoreHomeBannerAdapter(val bannerImage : List<EventImg>) : RecyclerView.Adapter<StoreHomeBannerAdapter.BannerViewHolder>() {

    inner class BannerViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.store_home_banner_item, parent, false)
    ) {
        val storeBanner: ImageView = itemView.findViewById(R.id.store_home_banner)

        fun onBindWith(ImageLists : EventImg) {
            Glide.with(itemView).load(ImageLists.storeEventImgUrl).into(storeBanner)
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StoreHomeBannerAdapter.BannerViewHolder {
        return BannerViewHolder((parent))
    }

    override fun onBindViewHolder(holder: StoreHomeBannerAdapter.BannerViewHolder, position: Int) {
        holder.onBindWith(bannerImage[position])
    }

    override fun getItemCount(): Int {
        return bannerImage.size
    }

}