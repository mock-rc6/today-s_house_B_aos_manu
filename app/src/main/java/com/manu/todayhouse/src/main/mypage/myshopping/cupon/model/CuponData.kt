package com.manu.todayhouse.src.main.mypage.myshopping.cupon.model

data class CuponData(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<Result>
)