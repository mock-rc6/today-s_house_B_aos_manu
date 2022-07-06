package com.manu.todayhouse.src.main.store.storehome.productdetailpage.productinfo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.manu.todayhouse.R
import com.manu.todayhouse.config.ApplicationClass
import com.manu.todayhouse.config.BaseFragment
import com.manu.todayhouse.databinding.FragmentProductInfoBinding
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.ProductDetailActivity
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.ProductDetailInterface
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.ProductDetailRetroFitInterface
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.ProductDetailService
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.adapter.ProductViewPagerAdapter
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.model.ProductDetailData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProductInfoFragment : BaseFragment<FragmentProductInfoBinding>(FragmentProductInfoBinding::bind, R.layout.fragment_product_info), ProductDetailInterface {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ProductDetailService(this).getProductDetail()

    }

    override fun getProductDetailSuccess(response: ProductDetailData) {

        val infoImage = response.result.itemInfoList
        val img1 = binding.productInfo1
        val img2 = binding.productInfo2
        val img3 = binding.productInfo3

        if (infoImage[2] != null){
            Glide.with(this).load(infoImage[0]).into(img1)
            Glide.with(this).load(infoImage[1]).into(img2)
            Glide.with(this).load(infoImage[2]).into(img3)
        } else if (infoImage[1] != null) {
            Glide.with(this).load(infoImage[0]).into(img1)
            Glide.with(this).load(infoImage[1]).into(img2)
        } else if (infoImage[1] != null) {
            Glide.with(this).load(infoImage[0]).into(img1)
        }
    }

    override fun getProductDetailFail(message: String) {
        showCustomToast("오류 : ${message}")
    }

}