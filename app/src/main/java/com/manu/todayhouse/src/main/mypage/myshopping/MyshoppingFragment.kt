package com.manu.todayhouse.src.main.mypage.myshopping

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.manu.todayhouse.R
import com.manu.todayhouse.config.BaseFragment
import com.manu.todayhouse.databinding.FragmentMyshoppingBinding
import com.manu.todayhouse.src.main.mypage.myshopping.model.MyShoppingData

class MyshoppingFragment : BaseFragment<FragmentMyshoppingBinding>(FragmentMyshoppingBinding::bind, R.layout.fragment_myshopping), MyShoppingFragmentInterface {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        MyShoppingService(this).getMyShopping()
    }

    override fun onGetMyProfileSuccess(response: MyShoppingData) {
        val cuponCount = binding.cuponCount
        val pointCount = binding.pointCount
        val levelTitle = binding.levelTitle

        cuponCount.text = response.result.coupons.toString()
        pointCount.text = response.result.points.toString()
        levelTitle.text = response.result.level


    }

    override fun onGetMyProfileeFail(message: String) {
        showCustomToast("오류 : ${message}")
    }

}