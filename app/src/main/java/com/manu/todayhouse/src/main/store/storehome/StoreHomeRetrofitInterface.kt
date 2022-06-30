package com.manu.todayhouse.src.main.store.storehome

import com.manu.todayhouse.src.main.store.storehome.model.StoreHomeData
import retrofit2.Call
import retrofit2.http.GET

interface StoreHomeRetrofitInterface {

    @GET("app/store")
    fun getStoreHome(

    ) : Call<StoreHomeData>
}