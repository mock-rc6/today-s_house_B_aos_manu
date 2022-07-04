package com.manu.todayhouse.src.main.home.popluar.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.manu.todayhouse.R
import com.manu.todayhouse.src.main.home.popluar.eventpage.model.PopluarCategroy

class PopluarCatgAdapter(var CatgList : ArrayList<PopluarCategroy>) : RecyclerView.Adapter<PopluarCatgAdapter.CatgView>() {

    inner class CatgView(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.popluar_grid_click_item, parent, false)
    ){
        val itemImg = itemView.findViewById<ImageView>(R.id.item_img)
        val itemTitle = itemView.findViewById<TextView>(R.id.item_title)

        fun onBindWith(catLists : PopluarCategroy){
            itemImg.clipToOutline = true
            itemImg.setImageResource(catLists.imageSrc)
            itemTitle.text = catLists.title

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopluarCatgAdapter.CatgView {
        return CatgView((parent))
    }

    override fun onBindViewHolder(holder: PopluarCatgAdapter.CatgView, position: Int) {
        holder.onBindWith(CatgList[position])
    }

    override fun getItemCount(): Int {
        return CatgList.size
    }
}