package com.manu.todayhouse.src.login

import com.manu.todayhouse.src.login.model.KaKaoTalkLoginData
import com.manu.todayhouse.src.main.home.popluar.eventpage.model.BannerData
import com.manu.todayhouse.src.main.home.popluar.model.MainHomeData

interface LoginActivityInterface {

    fun onGetKaKaoIdSuccess(response : KaKaoTalkLoginData)

    fun onGetKaKaoIdFail(message : String)

}