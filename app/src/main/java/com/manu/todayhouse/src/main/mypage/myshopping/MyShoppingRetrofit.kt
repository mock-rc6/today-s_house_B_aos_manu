package com.manu.todayhouse.src.main.mypage.myshopping

import com.manu.todayhouse.src.main.mypage.myshopping.model.MyShoppingData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface MyShoppingRetrofit {

    @GET("app/{userId}/my-shoppings")
    fun getMyShopping(
        @Header("X-ACCESS-TOKEN") token : String?,
        @Path ("userId") userId : Long
    ) : Call<MyShoppingData>
}