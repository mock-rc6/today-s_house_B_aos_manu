package com.manu.todayhouse.src.main.mypage.profile

import android.content.Intent
import com.manu.todayhouse.config.ApplicationClass
import com.manu.todayhouse.src.main.mypage.profile.model.UserMyPageData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyProfileService(val profileFragmentInterface: ProfileFragmentInterface) {

    fun getBannerImage() {

        val myProfileRetrofitInterface =
            ApplicationClass.sRetrofit.create(MyProfileRetrofitInterface::class.java)
        val intent = Intent()

        myProfileRetrofitInterface.getUserProfile(ApplicationClass.sSharedPreferences.getString("userJWT", ""),ApplicationClass.sSharedPreferences.getLong("userIdNo", 1)).enqueue(
            object : Callback<UserMyPageData>{
                override fun onResponse(
                    call: Call<UserMyPageData>,
                    response: Response<UserMyPageData>
                ) {
                    if (response.isSuccessful){
                        profileFragmentInterface.onGetMyProfileSuccess(response.body() as UserMyPageData)
                    }
                }

                override fun onFailure(call: Call<UserMyPageData>, t: Throwable) {
                    profileFragmentInterface.onGetMyProfileeFail(t.message ?: "통신 오류")
                }

            }
        )


    }
}