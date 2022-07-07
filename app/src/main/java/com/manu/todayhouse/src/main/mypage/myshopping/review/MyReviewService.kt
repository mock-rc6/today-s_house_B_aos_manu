package com.manu.todayhouse.src.main.mypage.myshopping.review

import com.manu.todayhouse.config.ApplicationClass
import com.manu.todayhouse.src.main.mypage.myshopping.review.model.MyReviewData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MyReviewService(val myReviewActivityInterface: MyReivewActivityInterface) {

    val myReviewRetrofit = ApplicationClass.sRetrofit.create(MyReviewRetrofit::class.java)

    fun getMyReview(){

        myReviewRetrofit.getMyReivew(
            ApplicationClass.sSharedPreferences.getString("userJWT", null),
            ApplicationClass.sSharedPreferences.getLong("userIdNo", 17),
            true,
            true
        ).enqueue(
            object : Callback<MyReviewData> {
                override fun onResponse(
                    call: Call<MyReviewData>,
                    response: Response<MyReviewData>
                ) {
                    if (response.isSuccessful){
                        myReviewActivityInterface.getMyReviewSuccess(response.body() as MyReviewData)
                    }
                }

                override fun onFailure(call: Call<MyReviewData>, t: Throwable) {
                    myReviewActivityInterface.getMyReviewFail(t.message ?: "통신 오류")
                }

            }
        )
    }
}