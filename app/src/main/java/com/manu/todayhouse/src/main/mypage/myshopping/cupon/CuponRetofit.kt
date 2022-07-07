package com.manu.todayhouse.src.main.mypage.myshopping.cupon

import com.manu.todayhouse.src.main.mypage.myshopping.cupon.model.CuponData
import retrofit2.Call
import retrofit2.http.*

interface CuponRetofit {

    @GET("users/coupons/{userId}")
    fun getCupon(
        @Header("X-ACCESS-TOKEN") token : String?,
        @Path("userId") userId : Long
    ) : Call<CuponData>


    @POST("users/coupons/{userId}")
    fun postCupon(
        @Header("X-ACCESS-TOKEN") token : String?,
        @Path("userId") userId : Long,
        @Body Parms : HashMap<String, String>
    ) : Call<CuponData>
}