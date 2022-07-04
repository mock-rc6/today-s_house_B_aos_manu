package com.manu.todayhouse.src.main.mypage.profile

import com.manu.todayhouse.src.main.home.popluar.eventpage.model.BannerData
import com.manu.todayhouse.src.main.home.popluar.model.MainHomeData
import com.manu.todayhouse.src.main.mypage.profile.model.UserMyPageData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface MyProfileRetrofitInterface {

    @GET("app/{userId}")
    fun getUserProfile(
        @Header("X-ACCESS-TOKEN") token : String?,
        @Path("userId") userId : Long
    ) : Call<UserMyPageData>

}