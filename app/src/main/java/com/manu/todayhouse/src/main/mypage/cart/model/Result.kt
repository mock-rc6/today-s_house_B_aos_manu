package com.manu.todayhouse.src.main.mypage.cart.model

data class Result(
    val delivery: String,
    val discountPrice: String,
    val itemNum: String,
    val kartItemList: List<KartItem>,
    val price: String,
    val saledPrice: String
)