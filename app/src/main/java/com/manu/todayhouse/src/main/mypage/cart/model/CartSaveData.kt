package com.manu.todayhouse.src.main.mypage.cart.model

data class CartSaveData(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: Result
)