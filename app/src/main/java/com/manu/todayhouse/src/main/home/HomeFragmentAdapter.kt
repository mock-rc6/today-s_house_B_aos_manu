package com.manu.todayhouse.src.main.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.manu.todayhouse.src.main.home.expert.ExpertFragment
import com.manu.todayhouse.src.main.home.follow.FollowFragment
import com.manu.todayhouse.src.main.home.homeparty.HomePartyFragment
import com.manu.todayhouse.src.main.home.knowledge.KnowledgeFragment
import com.manu.todayhouse.src.main.home.picture.PictureFragment
import com.manu.todayhouse.src.main.home.popluar.PopluarFragment
import com.manu.todayhouse.src.main.home.qanda.QAndAFragment

class HomeFragmentAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    private var fragmentList = listOf<Fragment>(PopluarFragment(), FollowFragment(), PictureFragment(), HomePartyFragment(), KnowledgeFragment(), ExpertFragment(), QAndAFragment())


    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PopluarFragment()
            1 -> FollowFragment()
            2 -> PictureFragment()
            3 -> HomePartyFragment()
            4 -> KnowledgeFragment()
            5 -> ExpertFragment()
            else -> QAndAFragment()
        }
    }


}