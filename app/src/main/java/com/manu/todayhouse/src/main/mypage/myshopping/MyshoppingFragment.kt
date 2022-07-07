package com.manu.todayhouse.src.main.mypage.myshopping

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.manu.todayhouse.R
import com.manu.todayhouse.config.BaseFragment
import com.manu.todayhouse.databinding.FragmentMyshoppingBinding
import com.manu.todayhouse.src.main.mypage.myshopping.cupon.CuponActivity
import com.manu.todayhouse.src.main.mypage.myshopping.model.MyShoppingData
import com.manu.todayhouse.src.main.mypage.myshopping.review.ReviewActivity

class MyshoppingFragment : BaseFragment<FragmentMyshoppingBinding>(FragmentMyshoppingBinding::bind, R.layout.fragment_myshopping), MyShoppingFragmentInterface {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        MyShoppingService(this).getMyShopping()

        binding.cuponImg.setOnClickListener{
            val intent = Intent(context, CuponActivity::class.java)
            startActivity(intent)
        }

        binding.myReviewContainer.setOnClickListener {
            val intent = Intent(context, ReviewActivity::class.java)
            startActivity(intent)
        }



    }

    override fun onGetMyProfileSuccess(response: MyShoppingData) {
        val cuponCount = binding.cuponCount
        val pointCount = binding.pointCount
        val levelTitle = binding.levelTitle
        val waiting = binding.waitingCount
        val finishMoney = binding.finishingCount
        val readyDeilver = binding.readyDeliverCount
        val delivering = binding.deliverIngCount
        val deliverFinish = binding.deliverFinishCount
        val writeReview = binding.writeReviewCount

        val myShoppingData = response.result

        cuponCount.text = response.result.coupons.toString()
        pointCount.text = response.result.points.toString()
        levelTitle.text = response.result.level
        waiting.text = response.result.waiting.toString()
        finishMoney.text = myShoppingData.finish.toString()
        readyDeilver.text = myShoppingData.ready.toString()
        delivering.text = myShoppingData.delivery.toString()
        deliverFinish.text = myShoppingData.finish.toString()
        writeReview.text = myShoppingData.reviewWritten.toString()

        val myDeliver = binding.myDeliverCount
        val myScrap = binding.myScrapCount
        val myReview = binding.myReviewCount
        val myQuestion = binding.myQuestionCount

        myDeliver.text = myShoppingData.bought.toString()
        myScrap.text = myShoppingData.scraps.toString()
        myReview.text = myShoppingData.review.toString()
        myQuestion.text = myShoppingData.inquiry.toString()


    }

    override fun onGetMyProfileeFail(message: String) {
        showCustomToast("오류 : ${message}")
    }

}