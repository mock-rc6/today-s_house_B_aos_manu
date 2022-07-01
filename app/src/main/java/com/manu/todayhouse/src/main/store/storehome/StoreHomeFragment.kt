package com.manu.todayhouse.src.main.store.storehome

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.manu.todayhouse.R
import com.manu.todayhouse.config.BaseFragment
import com.manu.todayhouse.databinding.FragmentStoreHomeBinding
import com.manu.todayhouse.src.main.store.storehome.adapter.StoreHomeBannerAdapter
import com.manu.todayhouse.src.main.store.storehome.model.StoreHomeData


class StoreHomeFragment : BaseFragment<FragmentStoreHomeBinding>(FragmentStoreHomeBinding::bind, R.layout.fragment_store_home), StoreFragmentInterface {

    private lateinit var storeHomeBannerAdapter: StoreHomeBannerAdapter
    private val sliderImageHandler: Handler = Handler(Looper.getMainLooper())
    private val sliderImageRunnable = Runnable { binding.storeBannerViewpager.currentItem = binding.storeBannerViewpager.currentItem + 1 }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        StoreHomeService(this@StoreHomeFragment).getstoreHomeBanner()



    }


    override fun onGetStoreImageSuccess(response: StoreHomeData) {
        val storeHomeBannerView = binding.storeBannerViewpager
        storeHomeBannerAdapter = StoreHomeBannerAdapter(response.result.eventImgs)
        storeHomeBannerView.apply {
            adapter = storeHomeBannerAdapter
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    sliderImageHandler.removeCallbacks(sliderImageRunnable)
                    sliderImageHandler.postDelayed(sliderImageRunnable, 3000)
                }
            })
        }

        TabLayoutMediator(
            binding.tabStoreBanner,
            binding.storeBannerViewpager
        ){
                tab, position ->
            binding.storeBannerViewpager.setCurrentItem(tab.position)
        }.attach()

    }

    override fun onGetStoreBannerImageFail(message: String) {
        showCustomToast("오류 : ${message}")
    }

}