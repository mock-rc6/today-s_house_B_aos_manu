package com.manu.todayhouse.src.main.home.popluar

import com.manu.todayhouse.src.main.home.popluar.eventpage.model.BannerData
import com.manu.todayhouse.src.main.home.popluar.model.MainHomeData
import retrofit2.Call
import retrofit2.http.GET

interface PopluarBannerRetrofitInterface {

    @GET("app/events")
    fun getBannerImage(

    ) : Call<BannerData>

    @GET("app")
    fun getMenuHouseInfo(

    ) : Call<MainHomeData>
}