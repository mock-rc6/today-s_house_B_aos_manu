package com.manu.todayhouse.src.main.store.storehome.productdetailpage.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.deliver.DeliverFragment
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.productinfo.ProductInfoFragment
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.question.QuestionFragment
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.recommend.RecommentFragment
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.review.ReviewFragment


class ProductDetailViewAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity)  {

    private var productFragmentList = listOf<Fragment>(ProductInfoFragment(), ReviewFragment(), QuestionFragment(), DeliverFragment(), RecommentFragment())

    override fun getItemCount(): Int {
        return productFragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> ProductInfoFragment()
            1 -> ReviewFragment()
            2 -> QuestionFragment()
            3 -> DeliverFragment()
            else -> RecommentFragment()
        }
    }
}