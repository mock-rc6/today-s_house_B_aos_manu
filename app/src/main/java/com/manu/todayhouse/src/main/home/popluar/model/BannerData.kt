package com.manu.todayhouse.src.main.home.popluar.model

data class BannerData(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<Result>
)