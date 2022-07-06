package com.manu.todayhouse.src.main.store.storehome.productdetailpage.buying

import com.manu.todayhouse.src.main.store.storehome.productdetailpage.buying.model.CardAdd
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.buying.model.CartOptionData

interface ChooseproductFragmentInterface {

    fun CartAddSuccess(response : CartOptionData)

    fun CartAddFail(message : String)
}