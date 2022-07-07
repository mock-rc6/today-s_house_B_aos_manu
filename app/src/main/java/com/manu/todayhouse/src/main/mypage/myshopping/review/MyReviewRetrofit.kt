package com.manu.todayhouse.src.main.mypage.myshopping.review

import com.manu.todayhouse.src.main.mypage.myshopping.review.model.MyReviewData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface MyReviewRetrofit {

    @GET("app/{userId}/reviews")
    fun getMyReivew(
        @Header("X-ACCESS-TOKEN") token : String?,
        @Path("userId") userId : Long,
        @Query("picture-reviews") picture_reviews : Boolean,
        @Query("best-reviews") best_reviews : Boolean
    ) : Call<MyReviewData>
}