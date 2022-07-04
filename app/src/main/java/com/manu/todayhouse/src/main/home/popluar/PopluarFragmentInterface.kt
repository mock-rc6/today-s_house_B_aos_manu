package com.manu.todayhouse.src.main.home.popluar

import com.manu.todayhouse.src.main.home.popluar.eventpage.model.BannerData
import com.manu.todayhouse.src.main.home.popluar.model.MainHomeData

interface PopluarFragmentInterface {

    fun onGetBannerImageSuccess(response : BannerData)

    fun onGetBannerImageFail(message : String)

    fun onGetHomeInfoSuccess(response : MainHomeData)

    fun onGetHomeInfoFail(message: String)
}