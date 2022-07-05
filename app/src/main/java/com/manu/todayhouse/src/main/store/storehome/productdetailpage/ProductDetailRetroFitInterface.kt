package com.manu.todayhouse.src.main.store.storehome.productdetailpage

import com.manu.todayhouse.src.main.store.storehome.productdetailpage.model.ProductDetailData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductDetailRetroFitInterface {

    @GET("app/store/items")
    fun getItemDetail(
        @Header("X-ACCESS-TOKEN") token: String?,
        @Query("id") itemId : String,
        @Query("user") userId : String
    ) : Call<ProductDetailData>
}