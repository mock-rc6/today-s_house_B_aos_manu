package com.manu.todayhouse.src.main.store

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.manu.todayhouse.R
import com.manu.todayhouse.config.BaseFragment
import com.manu.todayhouse.databinding.FragmentStoreBinding
import com.manu.todayhouse.src.main.home.HomeFragmentAdapter


class StoreFragment : BaseFragment<FragmentStoreBinding>(FragmentStoreBinding::bind, R.layout.fragment_store) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val storeTabLayout = binding.storeTabLayout
        val storeConnect = binding.storeTabConnectViewpager

        val storeFragmentAdapter = StoreFragmentAdapter(view.context as FragmentActivity)
        storeConnect.adapter = storeFragmentAdapter

        val tabTitleLists = listOf<String>("스토어홈", "베스트", "오늘의딜", "7월한정특가", "주말반짝세일", "빠른배송", "오!굿즈", "프리미엄", "기획전")

        TabLayoutMediator(storeTabLayout, storeConnect, {tab, poisition -> tab.text = tabTitleLists[poisition]}).attach()
    }
}