package com.manu.todayhouse.src.login.signup.model

import com.google.gson.annotations.SerializedName
import com.manu.todayhouse.config.BaseResponse

data class SignUpData(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    @SerializedName("result") val result : RegisterResult
)
