package com.manu.todayhouse.src.main.mypage.myshopping.review

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.manu.todayhouse.config.BaseActivity
import com.manu.todayhouse.databinding.ActivityReviewBinding
import com.manu.todayhouse.src.main.mypage.myshopping.review.adapter.MyReivewRecyclerAdapter
import com.manu.todayhouse.src.main.mypage.myshopping.review.model.MyReviewData
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.review.adapter.ReviewRecyclerAdapter

class ReviewActivity : BaseActivity<ActivityReviewBinding>(ActivityReviewBinding::inflate), MyReivewActivityInterface {

    private lateinit var myReviewRecyclerAdapter: MyReivewRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        MyReviewService(this).getMyReview()

    }

    override fun getMyReviewSuccess(response: MyReviewData) {
        showCustomToast("${response.message}")
        if (response.result != null) {
            myReviewRecyclerAdapter = MyReivewRecyclerAdapter(response.result)
            binding.noMyReview.visibility = View.GONE

            binding.myReviewRecycler.apply {
                adapter = myReviewRecyclerAdapter
            }
        } else {

        }

    }

    override fun getMyReviewFail(message: String) {
        showCustomToast("오류 : $message")
    }

}