package com.manu.todayhouse.src.main.home.popluar.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.manu.todayhouse.R
import com.manu.todayhouse.src.main.home.popluar.model.GetMainHouseInfo

class PopluarHomeInfoAdapter(val homeInfoLists : List<GetMainHouseInfo>) : RecyclerView.Adapter<PopluarHomeInfoAdapter.HomeInfoView>() {

    inner class HomeInfoView(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.home_recycler_item, parent, false)
    ) {
        val homeInfoImg = itemView.findViewById<ImageView>(R.id.home_info_img)
        val homeInfoScript = itemView.findViewById<TextView>(R.id.home_info_script)

        fun onBindWith(homeInfoList : GetMainHouseInfo) {
            homeInfoImg.clipToOutline = true
            Glide.with(itemView).load(homeInfoList.houseImgList).into(homeInfoImg)
            homeInfoScript.text = homeInfoList.houseDescriptionList

        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PopluarHomeInfoAdapter.HomeInfoView {
        return HomeInfoView((parent))
    }

    override fun onBindViewHolder(holder: PopluarHomeInfoAdapter.HomeInfoView, position: Int) {
        holder.onBindWith(homeInfoLists[position])
    }

    override fun getItemCount(): Int {
        return homeInfoLists.size
    }
}