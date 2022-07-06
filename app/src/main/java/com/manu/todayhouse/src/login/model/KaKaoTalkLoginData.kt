package com.manu.todayhouse.src.login.model

import android.util.JsonToken

data class KaKaoTalkLoginData(
    val isSuccess : Boolean,
    val code : Int,
    val message : String,
    val result : JsonToken
)
