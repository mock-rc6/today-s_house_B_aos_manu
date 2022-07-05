package com.manu.todayhouse.src.main.mypage.cart

import com.manu.todayhouse.src.main.mypage.cart.model.CartSaveData

interface CartSaveActivityInterface {

    fun getCartSaveSuccess(response : CartSaveData)

    fun getCartSaveFail(message : String)
}