package com.manu.todayhouse.src.main.mypage.cart.model

data class KartItem(
    val delivery: String,
    val imgUrl: String,
    val itemNum: Int,
    val kartId: Int,
    val optionId: Int,
    val optionName: String,
    val price: String
)