package com.manu.todayhouse.src.main.store.storehome.productdetailpage.model

data class Review(
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