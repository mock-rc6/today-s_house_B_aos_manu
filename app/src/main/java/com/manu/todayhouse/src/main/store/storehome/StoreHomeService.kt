package com.manu.todayhouse.src.main.store.storehome

import com.manu.todayhouse.config.ApplicationClass
import com.manu.todayhouse.src.main.store.storehome.model.StoreHomeData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class StoreHomeService(val storeFragmentInterface: StoreFragmentInterface) {

    fun getstoreHomeBanner() {

        val storeHomeRetrofitInterface = ApplicationClass.sRetrofit.create(StoreHomeRetrofitInterface::class.java)

        storeHomeRetrofitInterface.getStoreHome().enqueue( object : Callback<StoreHomeData> {
            override fun onResponse(call: Call<StoreHomeData>, response: Response<StoreHomeData>) {
                if (response.isSuccessful) {
                    storeFragmentInterface.onGetStoreImageSuccess(response.body() as StoreHomeData)
                }
            }

            override fun onFailure(call: Call<StoreHomeData>, t: Throwable) {
                storeFragmentInterface.onGetStoreBannerImageFail(t.message ?: "통신 오류")
            }

        })

    }
}