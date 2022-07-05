package com.manu.todayhouse.src.main.store.storehome.productdetailpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.viewpager2.widget.ViewPager2
import com.manu.todayhouse.config.ApplicationClass
import com.manu.todayhouse.config.BaseActivity
import com.manu.todayhouse.databinding.ActivityProductDetailBinding
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.adapter.ProductViewPagerAdapter
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.model.ProductDetailData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class ProductDetailActivity : BaseActivity<ActivityProductDetailBinding>(ActivityProductDetailBinding::inflate) {
    private lateinit var productViewPagerAdapter : ProductViewPagerAdapter
    private val sliderImageHandler: Handler = Handler(Looper.getMainLooper())
    private val sliderImageRunnable = Runnable { binding.productDetailImg.currentItem = binding.productDetailImg.currentItem + 1 }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val productDetailRetroFitInterface = ApplicationClass.sRetrofit.create(ProductDetailRetroFitInterface::class.java)

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
                    productViewPagerAdapter = ProductViewPagerAdapter(result!!.imgList)

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


                    productTitle.text = result.itemName
                    companyName.text = result.companyName
                    detailName.text = result.itemName
                    discountPercent.text = result.saleRate
                    productPrice.text = result.price
                    scrapCount.text = result.scrapCnt.toString()
                    reviewCount.text = "(" + result.reviewCnt.toString() + ")"
                    brandName.text = result.companyName
                    pointPlus.text = (result.price.toInt()/1000*3).toString()





                }

                override fun onFailure(call: Call<ProductDetailData>, t: Throwable) {
                    showCustomToast(t.message ?: "통신 오류")
                }

            }
        )

    }
}