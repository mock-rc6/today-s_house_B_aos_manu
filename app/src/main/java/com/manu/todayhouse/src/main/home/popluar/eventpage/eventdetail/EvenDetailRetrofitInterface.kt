package com.manu.todayhouse.src.main.home.popluar.eventpage.eventdetail

import com.manu.todayhouse.src.main.home.popluar.eventpage.model.BannerData
import com.manu.todayhouse.src.main.home.popluar.eventpage.model.EventImageDetail
import com.manu.todayhouse.src.main.home.popluar.model.MainHomeData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface EvenDetailRetrofitInterface {

    @GET("/app/events/{eventId}")
    fun getEventDetailImage(
        @Path("eventId") eventId : Long
    ) : Call<EventImageDetail>

}