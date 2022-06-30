package com.manu.todayhouse.src.main.store

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.manu.todayhouse.src.main.store.best.StoreBestragment
import com.manu.todayhouse.src.main.store.exhibition.StroeExhibitionFragment
import com.manu.todayhouse.src.main.store.ohgoods.OhGoodsFragment
import com.manu.todayhouse.src.main.store.premier.PremierFragment
import com.manu.todayhouse.src.main.store.quickdel.QuickDeliveryFragment
import com.manu.todayhouse.src.main.store.specialprrice.SpecialPriceFragment
import com.manu.todayhouse.src.main.store.storehome.StoreHomeFragment
import com.manu.todayhouse.src.main.store.todaydeal.TodayDealFragment
import com.manu.todayhouse.src.main.store.weekenddiscount.WeekendDiscountFragment


class StoreFragmentAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    private var fragmentLists = listOf<Fragment>(StoreHomeFragment(), StoreBestragment(), TodayDealFragment(), SpecialPriceFragment(), WeekendDiscountFragment(), OhGoodsFragment(), QuickDeliveryFragment(), PremierFragment(), StroeExhibitionFragment())
    override fun getItemCount(): Int {
        return fragmentLists.size
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> StoreHomeFragment()
            1 -> StoreBestragment()
            2 -> TodayDealFragment()
            3 -> SpecialPriceFragment()
            4 -> WeekendDiscountFragment()
            5 -> OhGoodsFragment()
            6 -> QuickDeliveryFragment()
            7 -> PremierFragment()
            else -> StroeExhibitionFragment()
        }
    }
}