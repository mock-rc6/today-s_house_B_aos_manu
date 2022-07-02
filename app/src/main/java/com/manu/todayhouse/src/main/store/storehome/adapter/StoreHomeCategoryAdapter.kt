package com.manu.todayhouse.src.main.store.storehome.adapter

import android.media.Image
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.manu.todayhouse.R
import com.manu.todayhouse.src.main.home.popluar.model.PopluarCategroy

class StoreHomeCategoryAdapter(var storeCatList : ArrayList<PopluarCategroy>) : RecyclerView.Adapter<StoreHomeCategoryAdapter.HomeCategoryView>(){

    inner class HomeCategoryView(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.store_home_category_item, parent, false)
    ) {
        val storeCategoryImg = itemView.findViewById<ImageView>(R.id.item_img)
        val storeCategoryTitle = itemView.findViewById<TextView>(R.id.item_title)

        fun onBindWith(storeList : PopluarCategroy){
            storeCategoryImg.clipToOutline = true
            storeCategoryTitle.text = storeList.title
            storeCategoryImg.setImageResource(storeList.imageSrc)
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StoreHomeCategoryAdapter.HomeCategoryView {
        return HomeCategoryView((parent))
    }

    override fun onBindViewHolder(
        holder: StoreHomeCategoryAdapter.HomeCategoryView,
        position: Int
    ) {
        holder.onBindWith(storeCatList[position])
    }

    override fun getItemCount(): Int {
        return storeCatList.size
    }


}