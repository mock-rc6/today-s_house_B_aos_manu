package com.manu.todayhouse.src.main.store.storehome.productdetailpage.model

data class Result(
    val companyId: Long,
    val companyName: String,
    val five: Int,
    val four: Int,
    val imgList: List<String>,
    val inquiry: Int,
    val itemInfoList: List<Any>,
    val itemName: String,
    val one: Int,
    val price: String,
    val reviewCnt: Int,
    val reviewList: List<Review>,
    val saleRate: String,
    val score: Double,
    val scrap: Boolean,
    val scrapCnt: Int,
    val three: Int,
    val two: Int
)