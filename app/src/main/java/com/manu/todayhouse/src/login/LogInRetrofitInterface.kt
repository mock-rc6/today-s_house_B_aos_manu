package com.manu.todayhouse.src.login

import android.os.Handler
import com.manu.todayhouse.src.login.model.KaKaoTalkLoginData
import com.manu.todayhouse.src.login.signup.model.SignUpData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface LogInRetrofitInterface {

    @GET("https://kauth.kakao.com/oauth/authorize?client_id=f0510e9495bfefc35fcb0e04f193fdd8&redirect_uri=https://rc-rising-test-6th.shop/oauth/kakao&response_type=code")
    fun userLogin(

    ) : Call<KaKaoTalkLoginData>
}