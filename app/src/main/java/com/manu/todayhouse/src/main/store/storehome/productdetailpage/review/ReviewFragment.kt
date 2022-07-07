package com.manu.todayhouse.src.main.store.storehome.productdetailpage.review

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.manu.todayhouse.R
import com.manu.todayhouse.config.BaseFragment
import com.manu.todayhouse.databinding.FragmentReviewBinding
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.ProductDetailInterface
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.ProductDetailService
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.model.ProductDetailData
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.review.adapter.ReviewListViewPagerAdapter
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.review.adapter.ReviewRecyclerAdapter


class ReviewFragment : BaseFragment<FragmentReviewBinding>(FragmentReviewBinding::bind, R.layout.fragment_review), ProductDetailInterface {

    private lateinit var reviewListViewPagerAdapter: ReviewListViewPagerAdapter
    private lateinit var reviewRecyclerAdapter: ReviewRecyclerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.goToReviewpage.setOnClickListener {
//
//        }
        ProductDetailService(this@ReviewFragment).getProductDetail()
    }

    override fun getProductDetailSuccess(response: ProductDetailData) {
        val reviewReslut = response.result.reviewList

        reviewListViewPagerAdapter = ReviewListViewPagerAdapter(reviewReslut)
        reviewRecyclerAdapter = ReviewRecyclerAdapter(reviewReslut)

        val viewPagerTest = view?.findViewById<RecyclerView>(R.id.review_img_list_viewpager)
        val viewRecyclerList = view?.findViewById<RecyclerView>(R.id.review_recycler_list)

        view?.findViewById<TextView>(R.id.review_count)?.text = response.result.reviewCnt.toString()

        viewPagerTest?.apply {
            adapter = reviewListViewPagerAdapter
        }

        viewRecyclerList?.apply {
            adapter = reviewRecyclerAdapter
        }
    }

    override fun getProductDetailFail(message: String) {
        showCustomToast("오류  : $message")
    }

}