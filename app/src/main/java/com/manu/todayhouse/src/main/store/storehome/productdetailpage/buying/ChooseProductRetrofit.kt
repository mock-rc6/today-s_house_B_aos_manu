package com.manu.todayhouse.src.main.store.storehome.productdetailpage.buying

import com.manu.todayhouse.src.main.store.storehome.productdetailpage.buying.model.CardAdd
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.buying.model.CartOptionData
import retrofit2.Call
import retrofit2.http.*

interface ChooseProductRetrofit {

    @POST("app/store/{userId}/items")
    fun postAddCart(
        @Header("X-ACCESS-TOKEN") token : String?,
        @Path("userId") userId : Long,
        @Query("id") itemId : Long,
        @Body Parm : HashMap<String, Any>,
    ) : Call<CardAdd>

    @GET("app/store/{userId}/items")
    fun getOptionItem(
        @Header("X-ACCESS-TOKEN") token : String?,
        @Path("userId") userId : Long,
        @Query("id") itemId: Long
    ) : Call<CartOptionData>
}