package com.manu.todayhouse.src.main.home.popluar

import com.manu.todayhouse.src.main.home.popluar.model.BannerData

interface PopluarFragmentInterface {

    fun onGetBannerImageSuccess(response : BannerData)

    fun onGetBannerImageFail(message : String)
}