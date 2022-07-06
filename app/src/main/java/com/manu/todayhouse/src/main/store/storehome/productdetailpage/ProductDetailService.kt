package com.manu.todayhouse.src.main.store.storehome.productdetailpage

import androidx.viewpager2.widget.ViewPager2
import com.manu.todayhouse.config.ApplicationClass
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.adapter.ProductViewPagerAdapter
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.model.ProductDetailData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductDetailService(val productDetailInterface: ProductDetailInterface) {

    fun getProductDetail(){
        val productDetailRetroFitInterface = ApplicationClass.sRetrofit.create(ProductDetailRetroFitInterface::class.java)

        productDetailRetroFitInterface.getItemDetail(
            ApplicationClass.sSharedPreferences.getString("userJWT", ""),
            ApplicationClass.sSharedPreferences.getLong("ItemNo", 1).toString(),
            ApplicationClass.sSharedPreferences.getLong("userIdNo", 17).toString()
        ).enqueue(
            object : Callback<ProductDetailData>{
                override fun onResponse(
                    call: Call<ProductDetailData>,
                    response: Response<ProductDetailData>
                ) {
                    productDetailInterface.getProductDetailSuccess(response.body() as ProductDetailData)
                }

                override fun onFailure(call: Call<ProductDetailData>, t: Throwable) {
                    productDetailInterface.getProductDetailFail(t.message ?: "통신오류")
                }

            }
        )
    }


}