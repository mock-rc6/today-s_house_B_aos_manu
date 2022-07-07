package com.manu.todayhouse.src.main.mypage.myshopping.review

import com.manu.todayhouse.src.main.mypage.myshopping.review.model.MyReviewData
import java.net.CacheResponse

interface MyReivewActivityInterface {
    fun getMyReviewSuccess(response: MyReviewData)

    fun getMyReviewFail(message : String)
}