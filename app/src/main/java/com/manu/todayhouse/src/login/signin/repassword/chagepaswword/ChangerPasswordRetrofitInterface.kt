package com.manu.todayhouse.src.login.signin.repassword.chagepaswword

import android.os.Handler
import com.manu.todayhouse.src.login.model.KaKaoTalkLoginData
import com.manu.todayhouse.src.login.signin.repassword.chagepaswword.model.ChangePathData
import com.manu.todayhouse.src.login.signup.model.SignUpData
import retrofit2.Call
import retrofit2.http.*

interface ChangerPasswordRetrofitInterface {

    @PATCH("users/{userId}")
    fun userLogin(
        @Header("X-ACCESS-TOKEN") token : String?,
        @Path ("userId") userId : Long,
        @Body Parm : HashMap<String, Any>,
    ) : Call<ChangePathData>
}