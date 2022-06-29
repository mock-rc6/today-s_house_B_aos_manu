package com.manu.todayhouse.src.main.home.popluar

import com.manu.todayhouse.config.ApplicationClass
import com.manu.todayhouse.src.main.home.popluar.model.BannerData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class PopluarService(val popluarFragmentInterface: PopluarFragmentInterface) {

    fun getBannerImage(){

        val popluarBannerRetrofitInterface = ApplicationClass.sRetrofit.create(PopluarBannerRetrofitInterface::class.java)

        popluarBannerRetrofitInterface.getBannerImage().enqueue(
            object : Callback<BannerData> {
                override fun onResponse(call: Call<BannerData>, response: Response<BannerData>) {
                    if (response.isSuccessful) {
                        popluarFragmentInterface.onGetBannerImageSuccess(response.body() as BannerData)
                    }
                }

                override fun onFailure(call: Call<BannerData>, t: Throwable) {
                    popluarFragmentInterface.onGetBannerImageFail(t.message ?: "통신 오류")
                }

            }
        )

    }
}