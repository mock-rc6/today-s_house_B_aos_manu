package com.manu.todayhouse.src.main.store.storehome.productdetailpage.buying

import com.manu.todayhouse.config.ApplicationClass
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.buying.model.CartOptionData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class ChooseProductService(val chooseproductFragmentInterface: ChooseproductFragmentInterface) {

    val chooseProductRetrofit = ApplicationClass.sRetrofit.create(ChooseProductRetrofit::class.java)

    fun getCartOption(){
        chooseProductRetrofit.getOptionItem(
            ApplicationClass.sSharedPreferences.getString("userJWT", null),
            ApplicationClass.sSharedPreferences.getLong("userIdNo", 17),
            ApplicationClass.sSharedPreferences.getLong("ItemNo", 1)
        ).enqueue(
            object : Callback<CartOptionData>{
                override fun onResponse(
                    call: Call<CartOptionData>,
                    response: Response<CartOptionData>
                ) {
                    if (response.isSuccessful){
                        chooseproductFragmentInterface.CartAddSuccess(response.body() as CartOptionData)
                    }
                }

                override fun onFailure(call: Call<CartOptionData>, t: Throwable) {
                    chooseproductFragmentInterface.CartAddFail(t.message ?: "통신 오류")
                }

            }
        )
    }
}