package com.manu.todayhouse.src.main.mypage.myshopping.cupon

import com.manu.todayhouse.config.ApplicationClass
import com.manu.todayhouse.src.main.mypage.myshopping.cupon.model.CuponData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class CuponService(val cuponActivityInterface: CuponActivityInterface) {

    val cuponRetrofit = ApplicationClass.sRetrofit.create(CuponRetofit::class.java)

    fun getCupon(){
        cuponRetrofit.getCupon(
            ApplicationClass.sSharedPreferences.getString("userJWT", null),
            ApplicationClass.sSharedPreferences.getLong("userIdNo", 17)
        ).enqueue(
            object : Callback<CuponData>{
                override fun onResponse(call: Call<CuponData>, response: Response<CuponData>) {
                    if (response.isSuccessful){
                        cuponActivityInterface.getCuponSuccess(response.body() as CuponData)
                    }
                }

                override fun onFailure(call: Call<CuponData>, t: Throwable) {
                    cuponActivityInterface.getCuponFail(t.message ?: "통신 오류")
                }

            }
        )
    }

}