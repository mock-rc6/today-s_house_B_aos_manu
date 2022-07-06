package com.manu.todayhouse.src.main.store.storehome.productdetailpage

import com.manu.todayhouse.src.main.store.storehome.productdetailpage.model.ProductDetailData

interface ProductDetailInterface {
    fun getProductDetailSuccess(response : ProductDetailData)

    fun getProductDetailFail(message : String)
}