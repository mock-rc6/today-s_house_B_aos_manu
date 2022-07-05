package com.manu.todayhouse.src.main.mypage.cart

import com.manu.todayhouse.config.ApplicationClass
import com.manu.todayhouse.src.main.mypage.cart.model.CartSaveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class CartSaveService(val cartSaveActivityInterface: CartSaveActivityInterface) {

    val cartSaveRetrofit = ApplicationClass.sRetrofit.create(CartSaveRetrofit::class.java)

    fun getCartSave(){
        cartSaveRetrofit.getCartSave(
            ApplicationClass.sSharedPreferences.getString("userJWT", null),
            ApplicationClass.sSharedPreferences.getLong("userIdNo", 17)
        ).enqueue(
            object : Callback<CartSaveData>{
                override fun onResponse(
                    call: Call<CartSaveData>,
                    response: Response<CartSaveData>
                ) {
                    cartSaveActivityInterface.getCartSaveSuccess(response.body() as CartSaveData)
                }

                override fun onFailure(call: Call<CartSaveData>, t: Throwable) {
                    cartSaveActivityInterface.getCartSaveFail(t.message ?: "통신 오류")
                }

            }
        )
    }
}