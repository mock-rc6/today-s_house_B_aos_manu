package com.manu.todayhouse.src.main.mypage.myshopping

import com.manu.todayhouse.src.main.mypage.myshopping.model.MyShoppingData


interface MyShoppingFragmentInterface {

    fun onGetMyProfileSuccess(response : MyShoppingData)

    fun onGetMyProfileeFail(message : String)
}