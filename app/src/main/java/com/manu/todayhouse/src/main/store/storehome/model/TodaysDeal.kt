package com.manu.todayhouse.src.main.store.storehome.model

data class TodaysDeal(
    val companyId: Long,
    val companyName: String,
    val due: String,
    val hotDealThumbnail: String,
    val itemId: Long,
    val itemName: String,
    val price: String,
    val reviewNum: Int,
    val saleRate: String,
    val score: Double,
    val subCategory: String,
    val subCategoryId: Long
)