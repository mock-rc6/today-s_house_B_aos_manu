package com.manu.todayhouse.src.main.home.popluar

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.manu.todayhouse.R
import com.manu.todayhouse.config.BaseFragment
import com.manu.todayhouse.databinding.FragmentPopluarBinding
import com.manu.todayhouse.src.main.home.popluar.adapter.PopluarBannerAdapter
import com.manu.todayhouse.src.main.home.popluar.model.BannerData

class PopluarFragment : BaseFragment<FragmentPopluarBinding>(FragmentPopluarBinding::bind, R.layout.fragment_popluar), PopluarFragmentInterface {

    private lateinit var popluarBannerAdapter: PopluarBannerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        PopluarService(this@PopluarFragment).getBannerImage()
    }

    override fun onGetBannerImageSuccess(response: BannerData) {

        popluarBannerAdapter = PopluarBannerAdapter(response.result)
        binding.popluarBannerView.apply {
            adapter = popluarBannerAdapter
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }
    }

    override fun onGetBannerImageFail(message: String) {
        showCustomToast("오류 : ${message}")
    }

}