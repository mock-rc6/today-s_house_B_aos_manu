package com.manu.todayhouse.src.main.store.storehome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.manu.todayhouse.R
import com.manu.todayhouse.config.BaseFragment
import com.manu.todayhouse.databinding.FragmentStoreHomeBinding
import com.manu.todayhouse.src.main.store.storehome.model.StoreHomeData


class StoreHomeFragment : BaseFragment<FragmentStoreHomeBinding>(FragmentStoreHomeBinding::bind, R.layout.fragment_store_home), StoreFragmentInterface {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onGetBannerImageSuccess(response: StoreHomeData) {
        TODO("Not yet implemented")
    }

    override fun onGetBannerImageFail(message: String) {
        TODO("Not yet implemented")
    }

}