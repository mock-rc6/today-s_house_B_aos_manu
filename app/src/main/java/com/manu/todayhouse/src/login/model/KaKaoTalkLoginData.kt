package com.manu.todayhouse.src.login.model

data class KaKaoTalkLoginData(
    val isSuccess : Boolean,
    val code : Int,
    val message : String,
    val result : KaKaoId
)
