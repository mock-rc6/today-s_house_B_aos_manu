package com.manu.todayhouse.src.main.home.popluar.eventpage

import android.util.Log
import com.manu.todayhouse.config.ApplicationClass
import com.manu.todayhouse.src.main.home.popluar.eventpage.model.BannerData
import com.manu.todayhouse.src.main.home.popluar.eventpage.model.Result
import com.manu.todayhouse.src.main.home.popluar.model.MainHomeData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EventService(val eventActivityInterface: EventActivityInterface) {
    val eventRetrofitInterface = ApplicationClass.sRetrofit.create(EventBannerRetrofitInterface::class.java)

    fun getBannerImage(){

        eventRetrofitInterface.getEventBannerImage().enqueue(
            object : Callback<BannerData> {
                override fun onResponse(call: Call<BannerData>, response: Response<BannerData>) {
                    if (response.isSuccessful) {
                        eventActivityInterface.onGetEventBannerImageSuccess(response.body() as BannerData)
                    }
                }

                override fun onFailure(call: Call<BannerData>, t: Throwable) {
                    eventActivityInterface.onGetEventBannerImageFail(t.message ?: "통신 오류")
                }

            }
        )

    }



}