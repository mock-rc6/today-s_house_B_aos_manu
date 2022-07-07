package com.manu.todayhouse.src.main.mypage.myshopping.review.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.manu.todayhouse.R
import com.manu.todayhouse.src.main.mypage.myshopping.review.model.ReviewResult
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.model.Review
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.review.adapter.ReviewRecyclerAdapter

class MyReivewRecyclerAdapter(private val myReviewList : List<ReviewResult>) : RecyclerView.Adapter<MyReivewRecyclerAdapter.MyReviewRecyclerView>() {

    inner class MyReviewRecyclerView(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.review_recycler_item, parent, false)
    ){
        val userImg = itemView.findViewById<ImageView>(R.id.user_img_review)
        val userNickname = itemView.findViewById<TextView>(R.id.user_nickname)
        val userstar1 = itemView.findViewById<ImageView>(R.id.user_star1)
        val userstar2 = itemView.findViewById<ImageView>(R.id.user_star2)
        val userstar3 = itemView.findViewById<ImageView>(R.id.user_star3)
        val userstar4 = itemView.findViewById<ImageView>(R.id.user_star4)
        val userstar5 = itemView.findViewById<ImageView>(R.id.user_star5)
        val writeDate = itemView.findViewById<TextView>(R.id.user_write_date)
        val whereBuy = itemView.findViewById<TextView>(R.id.where_buying)
        val userPicImg = itemView.findViewById<ImageView>(R.id.review_pic_img)
        val reviewSrcipt = itemView.findViewById<TextView>(R.id.review_srcipt)

        fun onBindWith(reviewScriptLists : ReviewResult){
            Glide.with(itemView).load(reviewScriptLists.profilePic).override(300,300).circleCrop().into(userImg)
            userNickname.text = reviewScriptLists.userName
            if (reviewScriptLists.score >= 5.0){
                userstar1.setImageResource(R.drawable.review_start_img)
                userstar2.setImageResource(R.drawable.review_start_img)
                userstar3.setImageResource(R.drawable.review_start_img)
                userstar4.setImageResource(R.drawable.review_start_img)
                userstar5.setImageResource(R.drawable.review_start_img)
            } else if (reviewScriptLists.score >= 4.5){
                userstar1.setImageResource(R.drawable.review_start_img)
                userstar2.setImageResource(R.drawable.review_start_img)
                userstar3.setImageResource(R.drawable.review_start_img)
                userstar4.setImageResource(R.drawable.review_start_img)
                userstar5.setImageResource(R.drawable.half_star_img)
            } else if (reviewScriptLists.score >= 4.0) {
                userstar1.setImageResource(R.drawable.review_start_img)
                userstar2.setImageResource(R.drawable.review_start_img)
                userstar3.setImageResource(R.drawable.review_start_img)
                userstar4.setImageResource(R.drawable.review_start_img)
            } else if (reviewScriptLists.score >= 3.5) {
                userstar1.setImageResource(R.drawable.review_start_img)
                userstar2.setImageResource(R.drawable.review_start_img)
                userstar3.setImageResource(R.drawable.review_start_img)
                userstar4.setImageResource(R.drawable.half_star_img)
            } else if (reviewScriptLists.score >= 3.0) {
                userstar1.setImageResource(R.drawable.review_start_img)
                userstar2.setImageResource(R.drawable.review_start_img)
                userstar3.setImageResource(R.drawable.review_start_img)
            } else if (reviewScriptLists.score >= 2.5){
                userstar1.setImageResource(R.drawable.review_start_img)
                userstar2.setImageResource(R.drawable.review_start_img)
                userstar3.setImageResource(R.drawable.half_star_img)
            }

            else if (reviewScriptLists.score >= 2.0) {
                userstar1.setImageResource(R.drawable.review_start_img)
                userstar2.setImageResource(R.drawable.review_start_img)
            }
            else if (reviewScriptLists.score >= 1.5) {
                userstar1.setImageResource(R.drawable.review_start_img)
                userstar2.setImageResource(R.drawable.half_star_img)
            } else if (reviewScriptLists.score >= 1.0) {
                userstar1.setImageResource(R.drawable.review_start_img)
            } else if (reviewScriptLists.score >= 0.5) {
                userstar1.setImageResource(R.drawable.half_star_img)
            }

            writeDate.text = reviewScriptLists.createdAt
            whereBuy.text = reviewScriptLists.buyAt
            userPicImg.clipToOutline = true
            Glide.with(itemView).load(reviewScriptLists.imgList).into(userPicImg)
            reviewSrcipt.text = reviewScriptLists.description
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyReviewRecyclerView {
        return MyReviewRecyclerView((parent))
    }

    override fun onBindViewHolder(holder: MyReviewRecyclerView, position: Int) {
        holder.onBindWith(myReviewList[position])
    }

    override fun getItemCount(): Int {
        return myReviewList.size
    }


}