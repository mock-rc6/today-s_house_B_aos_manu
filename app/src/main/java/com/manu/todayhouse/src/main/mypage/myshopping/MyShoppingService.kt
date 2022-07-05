package com.manu.todayhouse.src.main.mypage.myshopping

import com.manu.todayhouse.config.ApplicationClass
import com.manu.todayhouse.src.main.mypage.myshopping.model.MyShoppingData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MyShoppingService(val myShoppingFragmentInterface: MyShoppingFragmentInterface) {

    fun getMyShopping() {

        val myShoppingService = ApplicationClass.sRetrofit.create(MyShoppingRetrofit::class.java)

        myShoppingService.getMyShopping(
            ApplicationClass.sSharedPreferences.getString("userJWT", null),
            ApplicationClass.sSharedPreferences.getLong("userIdNo", 17)
        ).enqueue(
            object : Callback<MyShoppingData>{
                override fun onResponse(
                    call: Call<MyShoppingData>,
                    response: Response<MyShoppingData>
                ) {
                    myShoppingFragmentInterface.onGetMyProfileSuccess(response.body() as MyShoppingData)
                }

                override fun onFailure(call: Call<MyShoppingData>, t: Throwable) {
                    myShoppingFragmentInterface.onGetMyProfileeFail(t.message ?: "통신 불가")
                }

            }
        )
    }
}