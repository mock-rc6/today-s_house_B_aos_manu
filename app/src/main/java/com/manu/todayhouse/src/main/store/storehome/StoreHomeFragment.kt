package com.manu.todayhouse.src.main.store.storehome

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.manu.todayhouse.R
import com.manu.todayhouse.config.BaseFragment
import com.manu.todayhouse.databinding.FragmentStoreHomeBinding
import com.manu.todayhouse.src.main.home.popluar.model.PopluarCategroy
import com.manu.todayhouse.src.main.store.storehome.adapter.StoreHomeBannerAdapter
import com.manu.todayhouse.src.main.store.storehome.adapter.StoreHomeCategoryAdapter
import com.manu.todayhouse.src.main.store.storehome.adapter.TodayDealApater
import com.manu.todayhouse.src.main.store.storehome.model.StoreHomeData


class StoreHomeFragment : BaseFragment<FragmentStoreHomeBinding>(FragmentStoreHomeBinding::bind, R.layout.fragment_store_home), StoreFragmentInterface {

    private lateinit var storeHomeBannerAdapter: StoreHomeBannerAdapter
    private val sliderImageHandler: Handler = Handler(Looper.getMainLooper())
    private val sliderImageRunnable = Runnable { binding.storeBannerViewpager.currentItem = binding.storeBannerViewpager.currentItem + 1 }
    private val storeCategoryLists = ArrayList<PopluarCategroy>()
    private lateinit var storeHomeCategoryAdapter: StoreHomeCategoryAdapter
    private lateinit var todayDealApater: TodayDealApater

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        StoreHomeService(this@StoreHomeFragment).getstoreHomeBanner()

        storeCategoryLists.add(PopluarCategroy(R.drawable.o_sale_store_home, "오세일"))
        storeCategoryLists.add(PopluarCategroy(R.drawable.kids_pair_store_home, "키즈페어"))
        storeCategoryLists.add(PopluarCategroy(R.drawable.pet_week_store_home, "펫위크"))
        storeCategoryLists.add(PopluarCategroy(R.drawable.product_today_store_home, "생필품..."))
        storeCategoryLists.add(PopluarCategroy(R.drawable.quick_delivery_store_home, "빠른배송"))
        storeCategoryLists.add(PopluarCategroy(R.drawable.new_sale_store_home, "신상특가"))
        storeCategoryLists.add(PopluarCategroy(R.drawable.weekend_evnet_store_home, "주말특가"))
        storeCategoryLists.add(PopluarCategroy(R.drawable.refer_market_store_home, "리퍼마켓"))
        storeCategoryLists.add(PopluarCategroy(R.drawable.premier_store_home, "프리미엄"))
        storeCategoryLists.add(PopluarCategroy(R.drawable.oh_goods_store_home, "오!굿즈"))

        storeHomeCategoryAdapter = StoreHomeCategoryAdapter(storeCategoryLists)

        binding.storeHomeCategoryGrid.apply {
            adapter = storeHomeCategoryAdapter
            layoutManager = GridLayoutManager(context, 5)
        }

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



        val todayDealView = binding.todayDealRecycler
        todayDealApater = TodayDealApater(response.result.todaysDealList)

        todayDealView.apply {
            adapter = todayDealApater
        }


    }

    override fun onGetStoreBannerImageFail(message: String) {
        showCustomToast("오류 : ${message}")
    }



}