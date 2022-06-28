package com.manu.todayhouse.src.main.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import com.android.car.ui.toolbar.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.manu.todayhouse.R
import com.manu.todayhouse.config.BaseFragment
import com.manu.todayhouse.databinding.FragmentHomeBinding
import com.manu.todayhouse.src.MainActivity


class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home) {



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val homeTabLayout = binding.homeTabLayout
        val homeConnectView = binding.tabConnectViewpager

        val homeFragmentAdapter = HomeFragmentAdapter(view.context as FragmentActivity)
        homeConnectView.adapter = homeFragmentAdapter

        val tabTitleList = listOf<String>("인기", "팔로잉", "사진", "집들이", "노하우", "전문가집들이", "질문과 답변")

        TabLayoutMediator(homeTabLayout, homeConnectView, {tab, poisition -> tab.text = tabTitleList[poisition]}).attach()



    }

}