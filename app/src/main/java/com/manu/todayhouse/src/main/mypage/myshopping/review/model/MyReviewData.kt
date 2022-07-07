package com.manu.todayhouse.src.main.mypage.myshopping.review.model

data class MyReviewData(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<ReviewResult>
)