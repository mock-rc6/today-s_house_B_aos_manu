package com.manu.todayhouse.src.main.mypage.myshopping.cupon

import com.manu.todayhouse.src.main.mypage.myshopping.cupon.model.CuponData

interface CuponActivityInterface {

    fun getCuponSuccess(response : CuponData)

    fun getCuponFail(message : String)
}