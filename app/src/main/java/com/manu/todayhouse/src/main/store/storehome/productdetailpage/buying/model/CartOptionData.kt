package com.manu.todayhouse.src.main.store.storehome.productdetailpage.buying.model

data class CartOptionData(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<ResultX>
)