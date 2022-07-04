package com.manu.todayhouse.src.login.signup

import com.manu.todayhouse.src.login.signup.model.SignUpData

interface SignUpActivityInterface {

    fun onPostSignUpSuccess(response : SignUpData)

    fun onPostSignUpFail(message : String)
}