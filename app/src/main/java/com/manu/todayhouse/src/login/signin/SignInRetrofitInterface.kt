package com.manu.todayhouse.src.login.signin

import android.os.Handler
import com.manu.todayhouse.src.login.signup.model.SignUpData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SignInRetrofitInterface {

    @POST("users/log-in")
    fun userLogin(
        @Body parms : HashMap<String, Any>
    ) : Call<SignUpData>
}