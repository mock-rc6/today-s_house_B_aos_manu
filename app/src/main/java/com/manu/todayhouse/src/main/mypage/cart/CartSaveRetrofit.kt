package com.manu.todayhouse.src.main.mypage.cart

import com.manu.todayhouse.src.main.mypage.cart.model.CartSaveData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface CartSaveRetrofit {

    @GET("users/karts/{userId}")
    fun getCartSave(
        @Header("X-ACCESS-TOKEN") token : String?,
        @Path("userId") userId : Long
    ) :Call<CartSaveData>
}