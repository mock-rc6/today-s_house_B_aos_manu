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
import com.manu.todayhouse.config.ApplicationClass
import com.manu.todayhouse.src.MainActivity
import com.manu.todayhouse.src.main.store.storehome.catgory.CatgoryActivity
import com.manu.todayhouse.src.main.store.storehome.model.FindCatgoryData
import kotlinx.android.synthetic.main.store_home_catgory_find_item.view.*
import okio.blackholeSink
import java.lang.invoke.ConstantCallSite

class StoreHomeFindAdpater(val findCatList : List<FindCatgoryData>) : RecyclerView.Adapter<StoreHomeFindAdpater.HomeFindView>() {

    private var listener : OnClickInterface? =null

    interface OnClickInterface{
        fun onItemClick(v: View, pos : Int)
    }

    fun setOnItemClickListener(listener : OnClickInterface){
        this.listener = listener
    }


    inner class HomeFindView(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.store_home_catgory_find_item, parent, false)
    ) {

        val catgContanier = itemView.findViewById<ConstraintLayout>(R.id.catgory_container)
        val catgImg = itemView.findViewById<ImageView>(R.id.find_img)
        val catgText = itemView.findViewById<TextView>(R.id.find_text)
        val catgSubText = itemView.findViewById<TextView>(R.id.find_sub_text)

        fun onBindWith(findCatLists : FindCatgoryData) {
            catgImg.setImageResource(findCatLists.imgSrc)
            catgText.text = findCatLists.title
            catgSubText.text = findCatLists.subTitle




        }


    }



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StoreHomeFindAdpater.HomeFindView {
        return HomeFindView((parent))
    }

    override fun onBindViewHolder(holder: StoreHomeFindAdpater.HomeFindView, position: Int) {
        holder.onBindWith(findCatList[position])
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, CatgoryActivity::class.java)
            intent.putExtra("catgoryId",findCatList[position].catgoryId)
            intent.run { holder.itemView.context.startActivity(this) }
        }

    }

    override fun getItemCount(): Int {
        return  findCatList.size
    }
}