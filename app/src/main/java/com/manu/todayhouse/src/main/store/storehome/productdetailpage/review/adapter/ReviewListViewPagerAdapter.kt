package com.manu.todayhouse.src.main.store.storehome.productdetailpage.review.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.manu.todayhouse.R
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.model.Review

class ReviewListViewPagerAdapter(val reviewList : List<Review>) : RecyclerView.Adapter<ReviewListViewPagerAdapter.ReviewViewPager>() {

    inner class ReviewViewPager(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.review_viewpager_item, parent, false)
    ) {
        val imgLists = itemView.findViewById<ImageView>(R.id.review_img_lists)

        fun onBindWith(reviewLists : Review) {
            Glide.with(itemView).load(reviewLists.img).into(imgLists)
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ReviewListViewPagerAdapter.ReviewViewPager {
        return ReviewViewPager((parent))
    }

    override fun onBindViewHolder(
        holder: ReviewListViewPagerAdapter.ReviewViewPager,
        position: Int
    ) {
        holder.onBindWith(reviewList[position])
    }

    override fun getItemCount(): Int {
        return reviewList.size
    }
}