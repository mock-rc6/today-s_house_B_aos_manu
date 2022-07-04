package com.manu.todayhouse.src.main.mypage.profile

import com.manu.todayhouse.src.main.home.popluar.eventpage.model.BannerData
import com.manu.todayhouse.src.main.home.popluar.model.MainHomeData
import com.manu.todayhouse.src.main.mypage.profile.model.UserMyPageData

interface ProfileFragmentInterface {

    fun onGetMyProfileSuccess(response : UserMyPageData)

    fun onGetMyProfileeFail(message : String)

}