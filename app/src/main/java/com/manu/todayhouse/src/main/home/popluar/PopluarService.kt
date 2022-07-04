package com.manu.todayhouse.src.main.home.popluar

import com.manu.todayhouse.config.ApplicationClass
import com.manu.todayhouse.src.main.home.popluar.eventpage.model.BannerData
import com.manu.todayhouse.src.main.home.popluar.model.MainHomeData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

    fun getHomeInfo() {
        val getInfoRetrofitInterface = ApplicationClass.sRetrofit.create(PopluarBannerRetrofitInterface::class.java)

        getInfoRetrofitInterface.getMenuHouseInfo().enqueue(
            object : Callback<MainHomeData> {
                override fun onResponse(
                    call: Call<MainHomeData>,
                    response: Response<MainHomeData>
                ) {
                    if (response.isSuccessful) {
                        popluarFragmentInterface.onGetHomeInfoSuccess(response.body() as MainHomeData)
                    }
                }

                override fun onFailure(call: Call<MainHomeData>, t: Throwable) {
                    popluarFragmentInterface.onGetHomeInfoFail(t.message ?: "통신 오류")
                }

            }
        )
    }
}