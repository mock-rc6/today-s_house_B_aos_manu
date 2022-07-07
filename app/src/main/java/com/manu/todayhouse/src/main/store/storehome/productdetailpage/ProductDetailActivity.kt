package com.manu.todayhouse.src.main.store.storehome.productdetailpage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.get
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.manu.todayhouse.R
import com.manu.todayhouse.config.ApplicationClass
import com.manu.todayhouse.config.BaseActivity
import com.manu.todayhouse.databinding.ActivityProductDetailBinding
import com.manu.todayhouse.src.main.mypage.cart.CartSaveActivity
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.buying.ChooseProductFragment
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.adapter.ProductDetailViewAdapter
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.adapter.ProductViewPagerAdapter
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.model.ProductDetailData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductDetailActivity : BaseActivity<ActivityProductDetailBinding>(ActivityProductDetailBinding::inflate) {

    private lateinit var productViewPagerAdapter : ProductViewPagerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.productBuket.setOnClickListener {
            val intent = Intent(this@ProductDetailActivity, CartSaveActivity::class.java)
            startActivity(intent)
        }

        val detailTab = binding.detailTabLayout
        val detailViewPager = binding.detailViewPager2

        val productDetailRetroFitInterface = ApplicationClass.sRetrofit.create(ProductDetailRetroFitInterface::class.java)

        val getItemNo = ApplicationClass.sSharedPreferences.edit()
        getItemNo.putLong("ItemNo", intent.getLongExtra("ItemNo", 1))
        getItemNo.apply()

        Log.d("testtt", "${intent.getLongExtra("ItemNo", 1)}")
        Log.d("testtt", "${ApplicationClass.sSharedPreferences.getString("userJWT", null)}")
        Log.d("testtt", "${ApplicationClass.sSharedPreferences.getLong("userIdNo", 17)}")

        productDetailRetroFitInterface.getItemDetail(
            ApplicationClass.sSharedPreferences.getString("userJWT", ""),
            intent.getLongExtra("ItemNo", 1).toString(),
            ApplicationClass.sSharedPreferences.getLong("userIdNo", 17).toString()
        ).enqueue(
            object : Callback<ProductDetailData>{
                override fun onResponse(
                    call: Call<ProductDetailData>,
                    response: Response<ProductDetailData>
                ) {
                    val result = response.body()?.result
                    val productviewpager = binding.productDetailImg
                    productViewPagerAdapter = ProductViewPagerAdapter(result?.imgList!!)

                    productviewpager.apply {
                        adapter = productViewPagerAdapter
                        orientation = ViewPager2.ORIENTATION_HORIZONTAL
                        registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
                            override fun onPageSelected(position: Int) {
                                super.onPageSelected(position)
                                binding.textViewCurrentBanner.text = "${position + 1}"
                                binding.textViewTotalBanner.text = "${result.imgList.size}"

                        }

                    })
                    }

                    val productTitle = binding.productDetailTitle
                    val companyName = binding.productCompanyName
                    val detailName = binding.productDetailName
                    val discountPercent = binding.productDiscountPercent
                    val productPrice = binding.productPrice
                    val reviewCount = binding.reviewCountProduct
                    val scrapCount = binding.scrapCount
                    val brandName = binding.brandName
                    val pointPlus = binding.pointPlusCount
                    val firstStar = binding.firstStarUn
                    val secondStar = binding.secondStarUn
                    val threeStar = binding.thirdStarUn
                    val fourStar = binding.fourthStarUn
                    val fiveStar = binding.fifthStarUn


                    productTitle.text = result.itemName
                    companyName.text = result.companyName
                    detailName.text = result.itemName
                    discountPercent.text = result.saleRate
                    productPrice.text = result.price
                    scrapCount.text = result.scrapCnt.toString()
                    reviewCount.text = "(" + result.reviewCnt.toString() + ")"
                    brandName.text = result.companyName
//                    pointPlus.text = (result.price.toInt()/1000*3).toString()

                    if (result.score >= 5.0){
                        firstStar.setImageResource(R.drawable.review_start_img)
                        secondStar.setImageResource(R.drawable.review_start_img)
                        threeStar.setImageResource(R.drawable.review_start_img)
                        fourStar.setImageResource(R.drawable.review_start_img)
                        fiveStar.setImageResource(R.drawable.review_start_img)
                    } else if (result.score >= 4.5){
                        firstStar.setImageResource(R.drawable.review_start_img)
                        secondStar.setImageResource(R.drawable.review_start_img)
                        threeStar.setImageResource(R.drawable.review_start_img)
                        fourStar.setImageResource(R.drawable.review_start_img)
                        fiveStar.setImageResource(R.drawable.half_star_img)
                    } else if (result.score >= 4.0) {
                        firstStar.setImageResource(R.drawable.review_start_img)
                        secondStar.setImageResource(R.drawable.review_start_img)
                        threeStar.setImageResource(R.drawable.review_start_img)
                        fourStar.setImageResource(R.drawable.review_start_img)
                    } else if (result.score >= 3.5) {
                        firstStar.setImageResource(R.drawable.review_start_img)
                        secondStar.setImageResource(R.drawable.review_start_img)
                        threeStar.setImageResource(R.drawable.review_start_img)
                        fourStar.setImageResource(R.drawable.half_star_img)
                    } else if (result.score >= 3.0) {
                        firstStar.setImageResource(R.drawable.review_start_img)
                        secondStar.setImageResource(R.drawable.review_start_img)
                        threeStar.setImageResource(R.drawable.review_start_img)
                    } else if (result.score >= 2.5){
                        firstStar.setImageResource(R.drawable.review_start_img)
                        secondStar.setImageResource(R.drawable.review_start_img)
                        threeStar.setImageResource(R.drawable.half_star_img)
                    }

                    else if (result.score >= 2.0) {
                        firstStar.setImageResource(R.drawable.review_start_img)
                        secondStar.setImageResource(R.drawable.review_start_img)
                    }
                    else if (result.score >= 1.5) {
                        firstStar.setImageResource(R.drawable.review_start_img)
                        secondStar.setImageResource(R.drawable.half_star_img)
                    } else if (result.score >= 1.0) {
                        firstStar.setImageResource(R.drawable.review_start_img)
                    } else if (result.score >= 0.5) {
                        firstStar.setImageResource(R.drawable.half_star_img)
                    }





                }

                override fun onFailure(call: Call<ProductDetailData>, t: Throwable) {
                    showCustomToast(t.message ?: "통신 오류")
                }

            }
        )


        val productDetailViewAdapter = ProductDetailViewAdapter(this as FragmentActivity)

        detailViewPager.apply {
            adapter = productDetailViewAdapter
//            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
//                override fun onPageSelected(position: Int) {
//                    super.onPageSelected(position)
//                    // viewPager
//                    val view = (detailViewPager[0] as RecyclerView).layoutManager?.findViewByPosition(position)
//                    view?.post {
//                        val wMeasureSpec =
//                            View.MeasureSpec.makeMeasureSpec(view.width, View.MeasureSpec.EXACTLY)
//                        val hMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
//                        view.measure(wMeasureSpec, hMeasureSpec)
//                        if (detailViewPager.layoutParams.height != view.measuredHeight) {
//                            detailViewPager.layoutParams = (detailViewPager.layoutParams).also { lp ->
//                                lp.height = view.measuredHeight
//                            }
//                        }
//                    }
//                }
//            })
        }


        val productTabTitleList = listOf<String>("상품정보", "리뷰", "문의", "배송/환불", "추천")

        TabLayoutMediator(detailTab, detailViewPager, {tab, poisition -> tab.text = productTabTitleList[poisition]}).attach()

        binding.stickyScroll.run {
            header = detailTab
            stickListener = { _ ->
                Log.d("Logger_Tag", "stickListener")
            }
            freeListener = { _ ->
                Log.d("Logger Tag", "FreeListener")
            }
        }

        val chooseProductFragment : ChooseProductFragment = ChooseProductFragment()

        binding.buyingBtn.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.buying_frame, chooseProductFragment).commit()
            binding.buyingFrame.isClickable = true
        }
    }
}