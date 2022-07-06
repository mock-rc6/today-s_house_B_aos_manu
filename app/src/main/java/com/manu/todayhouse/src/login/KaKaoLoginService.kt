package com.manu.todayhouse.src.login

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.manu.todayhouse.config.ApplicationClass
import com.manu.todayhouse.config.XAccessTokenInterceptor
import com.manu.todayhouse.src.login.model.KaKaoTalkLoginData
import com.manu.todayhouse.src.main.home.popluar.eventpage.model.BannerData
import com.manu.todayhouse.src.main.home.popluar.model.MainHomeData
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class KaKaoLoginService(val loginActivityInterface: LoginActivityInterface) {

    private lateinit var kRetrofit : Retrofit
    private lateinit var gson : Gson

    val client: OkHttpClient = OkHttpClient.Builder()
        .readTimeout(5000, TimeUnit.MILLISECONDS)
        .connectTimeout(5000, TimeUnit.MILLISECONDS)
        // 로그캣에 okhttp.OkHttpClient로 검색하면 http 통신 내용을 보여줍니다.
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .addNetworkInterceptor(XAccessTokenInterceptor()) // JWT 자동 헤더 전송
        .build()


    val logInRetrofitInterface = ApplicationClass.sRetrofit.create(LogInRetrofitInterface::class.java)



    fun getKaKaoId() {
        gson = GsonBuilder().setLenient().create()
        kRetrofit = Retrofit.Builder()
            .baseUrl("https://kauth.kakao.com/").client(client)
            .addConverterFactory(GsonConverterFactory.create(gson)).build()
        val loginKaKao = kRetrofit.create(LogInRetrofitInterface::class.java)

        loginKaKao.userLogin("f0510e9495bfefc35fcb0e04f193fdd8","https://rc-rising-test-6th.shop/oauth/kakao", "code").enqueue(
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