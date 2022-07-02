package com.manu.todayhouse.src.main.store.storehome

import com.manu.todayhouse.src.main.store.storehome.model.StoreHomeData

interface StoreFragmentInterface {

    fun onGetStoreImageSuccess(response : StoreHomeData)

    fun onGetStoreBannerImageFail(message : String)


}