package com.manu.todayhouse.src.main.store.storehome.productdetailpage.review

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.manu.todayhouse.R
import com.manu.todayhouse.config.BaseFragment
import com.manu.todayhouse.databinding.FragmentReviewBinding
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.ProductDetailInterface
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.model.ProductDetailData


class ReviewFragment : BaseFragment<FragmentReviewBinding>(FragmentReviewBinding::bind, R.layout.fragment_review), ProductDetailInterface {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun getProductDetailSuccess(response: ProductDetailData) {
        TODO("Not yet implemented")
    }

    override fun getProductDetailFail(message: String) {
        TODO("Not yet implemented")
    }

}