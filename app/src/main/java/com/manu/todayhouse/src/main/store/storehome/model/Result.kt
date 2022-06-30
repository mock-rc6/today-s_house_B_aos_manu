package com.manu.todayhouse.src.main.store.storehome.model

data class Result(
    val categoryIdList: List<Int>,
    val eventImgs: List<EventImg>,
    val todaysDealList: List<TodaysDeal>
)