package com.manu.todayhouse.src.login

import android.os.Handler
import com.manu.todayhouse.src.login.model.KaKaoId
import com.manu.todayhouse.src.login.model.KaKaoTalkLoginData
import com.manu.todayhouse.src.login.signup.model.SignUpData
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface LogInRetrofitInterface {

//    client_id=f0510e9495bfefc35fcb0e04f193fdd8&redirect_uri=https://rc-rising-test-6th.shop/oauth/kakao&response_type=code

    @GET("oauth/authorize")
    fun userLogin(
        @Query("clinet_id") id: String,
        @Query("redirect_uri") uri : String
    ) : Call<KaKaoTalkLoginData>
}