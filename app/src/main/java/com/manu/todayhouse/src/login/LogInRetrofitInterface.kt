package com.manu.todayhouse.src.login

import com.manu.todayhouse.src.login.model.KaKaoTalkLoginData
import retrofit2.Call
import retrofit2.http.*

interface LogInRetrofitInterface {

//    client_id=f0510e9495bfefc35fcb0e04f193fdd8&redirect_uri=https://rc-rising-test-6th.shop/oauth/kakao&response_type=code
    @GET("oauth/authorize")
    fun userLogin(
        @Query("clinet_id") clinet_id: String,
        @Query("redirect_uri") redirect_uri : String,
        @Query("response_type") response_type : String
    ) : Call<KaKaoTalkLoginData>
}