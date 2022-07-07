package com.manu.todayhouse.src.main.mypage

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.manu.todayhouse.R
import com.manu.todayhouse.config.BaseFragment
import com.manu.todayhouse.databinding.FragmentMyPageBinding
import com.manu.todayhouse.src.main.mypage.cart.CartSaveActivity


class MyPageFragment : BaseFragment<FragmentMyPageBinding>(FragmentMyPageBinding::bind, R.layout.fragment_my_page) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mypageTab = binding.mypageTabLayout
        val mypageConnecter = binding.tabMypageConnectViewpager

        val mypageFragmentAdapter = MypageFragmentAdapter(view.context as FragmentActivity)
        mypageConnecter.adapter = mypageFragmentAdapter


        val myPagetabTitleList = listOf<String>("프로필", "나의쇼핑")

        TabLayoutMediator(mypageTab, mypageConnecter, {tab, poisition -> tab.text = myPagetabTitleList[poisition]}).attach()

        binding.cartImg.setOnClickListener {
            val intent = Intent(context, CartSaveActivity::class.java)
            startActivity(intent)
        }

    }

}