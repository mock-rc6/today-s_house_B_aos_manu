package com.manu.todayhouse.src.login

import com.manu.todayhouse.config.ApplicationClass
import com.manu.todayhouse.src.login.model.KaKaoTalkLoginData
import com.manu.todayhouse.src.main.home.popluar.eventpage.model.BannerData
import com.manu.todayhouse.src.main.home.popluar.model.MainHomeData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class KaKaoLoginService(val loginActivityInterface: LoginActivityInterface) {

    val logInRetrofitInterface = ApplicationClass.sRetrofit.create(LogInRetrofitInterface::class.java)

    fun getKaKaoId() {
        logInRetrofitInterface.userLogin().enqueue(
            object : Callback<KaKaoTalkLoginData> {
                override fun onResponse(
                    call: Call<KaKaoTalkLoginData>,
                    response: Response<KaKaoTalkLoginData>
                ) {
                    if (response.isSuccessful){
                        loginActivityInterface.onGetKaKaoIdSuccess(response.body() as KaKaoTalkLoginData)
                    }
                }

                override fun onFailure(call: Call<KaKaoTalkLoginData>, t: Throwable) {
                    loginActivityInterface.onGetKaKaoIdFail(t.message ?: "통신 오류")
                }

            }
        )
    }

}