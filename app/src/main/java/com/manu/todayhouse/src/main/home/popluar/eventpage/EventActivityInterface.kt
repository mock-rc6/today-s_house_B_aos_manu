package com.manu.todayhouse.src.main.home.popluar.eventpage

import com.manu.todayhouse.src.main.home.popluar.eventpage.model.BannerData

interface EventActivityInterface {

    fun onGetEventBannerImageSuccess(response : BannerData)

    fun onGetEventBannerImageFail(message : String)

}