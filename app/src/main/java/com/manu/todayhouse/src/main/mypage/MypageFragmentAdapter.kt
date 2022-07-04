package com.manu.todayhouse.src.main.mypage

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
import com.manu.todayhouse.src.main.mypage.myshopping.MyshoppingFragment
import com.manu.todayhouse.src.main.mypage.profile.ProfileFragment

class MypageFragmentAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    private var fragmentList = listOf<Fragment>(ProfileFragment(), MyshoppingFragment())


    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ProfileFragment()
            else -> MyshoppingFragment()
        }
    }


}