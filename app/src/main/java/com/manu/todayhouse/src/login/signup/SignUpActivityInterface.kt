package com.manu.todayhouse.src.login.signup

import com.manu.todayhouse.src.login.signup.model.RegisterUser
import com.manu.todayhouse.src.login.signup.model.SignUpData
import com.manu.todayhouse.src.main.home.popluar.model.BannerData

interface SignUpActivityInterface {

    fun onPostSignUpSuccess(response : SignUpData)

    fun onPostSignUpFail(message : String)
}