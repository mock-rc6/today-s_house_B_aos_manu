package com.manu.todayhouse.src.main.store.storehome.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.manu.todayhouse.R
import com.manu.todayhouse.src.main.store.storehome.model.TodaysDeal
import org.w3c.dom.Text

class TodayDealApater(val todayDeal : List<TodaysDeal>) : RecyclerView.Adapter<TodayDealApater.TodayDealView>() {

    inner class TodayDealView(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.today_deal_item, parent, false)
    ){
        val mainImg = itemView.findViewById<ImageView>(R.id.today_deal_main_img)
        val dealDue = itemView.findViewById<TextView>(R.id.today_deal_due)
        val companyName = itemView.findViewById<TextView>(R.id.today_deal_company_name)
        val itemTitle = itemView.findViewById<TextView>(R.id.today_deal_title)
        val discountPercent = itemView.findViewById<TextView>(R.id.deal_discount_percent)
        val dealPrice = itemView.findViewById<TextView>(R.id.deal_price)
        val tagImg = itemView.findViewById<ImageButton>(R.id.deal_tag_img)
        val reviewPoint = itemView.findViewById<TextView>(R.id.today_deal_review_point)
        val reviewCount = itemView.findViewById<TextView>(R.id.review_text_count)

        fun onBindWith(todayDealLists : TodaysDeal){
            mainImg.clipToOutline = true
            tagImg.isEnabled = true
            Glide.with(itemView).load(todayDealLists.hotDealThumbnail).into(mainImg)
            dealDue.text = todayDealLists.due
            companyName.text = todayDealLists.companyName
            itemTitle.text = todayDealLists.itemName
            discountPercent.text = todayDealLists.saleRate
            dealPrice.text = todayDealLists.price
            reviewPoint.text = todayDealLists.score.toString()
            reviewCount.text = todayDealLists.reviewNum.toString()
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TodayDealApater.TodayDealView {
        return  TodayDealView((parent))
    }

    override fun onBindViewHolder(holder: TodayDealApater.TodayDealView, position: Int) {
        holder.onBindWith(todayDeal[position])
    }

    override fun getItemCount(): Int {
        return todayDeal.size
    }
}