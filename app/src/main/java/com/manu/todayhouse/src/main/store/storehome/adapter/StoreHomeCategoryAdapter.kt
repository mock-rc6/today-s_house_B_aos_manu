package com.manu.todayhouse.src.main.store.storehome.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.manu.todayhouse.R
import com.manu.todayhouse.src.MainActivity
import com.manu.todayhouse.src.main.home.popluar.eventpage.model.PopluarCategroy

class StoreHomeCategoryAdapter(var storeCatList : ArrayList<PopluarCategroy>) : RecyclerView.Adapter<StoreHomeCategoryAdapter.HomeCategoryView>(){

    interface ItemClick{
        fun onClick(view : View, position: Int)
    }

    var itemClick : ItemClick? = null

    inner class HomeCategoryView(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.store_home_category_item, parent, false)
    ) {
        val storeCategoryImg = itemView.findViewById<ImageView>(R.id.item_img)
        val storeCategoryTitle = itemView.findViewById<TextView>(R.id.item_title)
        val storeCatgoryContainer = itemView.findViewById<ConstraintLayout>(R.id.category_item_container)

        fun onBindWith(storeList : PopluarCategroy){
            storeCategoryImg.clipToOutline = true
            storeCategoryTitle.text = storeList.title
            storeCategoryImg.setImageResource(storeList.imageSrc)
            storeCatgoryContainer.setOnClickListener {
                val intent = Intent(itemView.context, MainActivity::class.java)
                intent.run { itemView.context.startActivity(this) }
            }

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