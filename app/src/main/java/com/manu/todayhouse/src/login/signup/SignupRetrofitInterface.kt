package com.manu.todayhouse.src.login.signup

import com.manu.todayhouse.src.login.signup.model.RegisterUser
import com.manu.todayhouse.src.login.signup.model.SignUpData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SignupRetrofitInterface {

    @POST("users")
    fun registerUser(
        @Body Parm : HashMap<String, Any>,
    ) : Call<SignUpData>
}