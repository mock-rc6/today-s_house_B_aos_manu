package com.manu.todayhouse.src.main.mypage.myshopping.review.model

data class ReviewResult(
    val buyAt: String,
    val createdAt: String,
    val description: String,
    val imgList: List<String>,
    val itemName: String,
    val profilePic: String,
    val score: Double,
    val userId: Long,
    val userName: String
)
