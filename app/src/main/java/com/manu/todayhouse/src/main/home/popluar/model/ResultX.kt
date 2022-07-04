package com.manu.todayhouse.src.main.home.popluar.model

data class ResultX(
    val categoryList: List<Int>,
    val getEventInfos: List<GetEventInfo>,
    val getMainHouseInfos: List<GetMainHouseInfo>
)