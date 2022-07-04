package com.manu.todayhouse.src.main.store.storehome

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.manu.todayhouse.R
import com.manu.todayhouse.config.BaseFragment
import com.manu.todayhouse.databinding.FragmentStoreHomeBinding
import com.manu.todayhouse.src.main.home.popluar.eventpage.model.PopluarCategroy
import com.manu.todayhouse.src.main.store.storehome.adapter.StoreHomeBannerAdapter
import com.manu.todayhouse.src.main.store.storehome.adapter.StoreHomeCategoryAdapter
import com.manu.todayhouse.src.main.store.storehome.adapter.StoreHomeFindAdpater
import com.manu.todayhouse.src.main.store.storehome.adapter.TodayDealApater
import com.manu.todayhouse.src.main.store.storehome.model.FindCatgoryData
import com.manu.todayhouse.src.main.store.storehome.model.StoreHomeData


class StoreHomeFragment : BaseFragment<FragmentStoreHomeBinding>(FragmentStoreHomeBinding::bind, R.layout.fragment_store_home), StoreFragmentInterface {

    private lateinit var storeHomeBannerAdapter: StoreHomeBannerAdapter
    private val sliderImageHandler: Handler = Handler(Looper.getMainLooper())
    private val sliderImageRunnable = Runnable { binding.storeBannerViewpager.currentItem = binding.storeBannerViewpager.currentItem + 1 }
    private val storeCategoryLists = ArrayList<PopluarCategroy>()
    private val findCatgLists = ArrayList<FindCatgoryData>()
    private lateinit var storeHomeCategoryAdapter: StoreHomeCategoryAdapter
    private lateinit var todayDealApater: TodayDealApater
    private lateinit var storeHomeFindAdpater: StoreHomeFindAdpater

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

        findCatgLists.add(FindCatgoryData(R.drawable.store_home_find1, "가구", "소파,침대,테이블,거실장,선반,거울"))
        findCatgLists.add(FindCatgoryData(R.drawable.store_home_find2, "패브릭", "침구,커튼,이불,베개"))
        findCatgLists.add(FindCatgoryData(R.drawable.store_home_find3, "가전", "냉장고,TV,세탁기·건조기,에어컨"))
        findCatgLists.add(FindCatgoryData(R.drawable.store_home_find4, "유아·아동", "매트,기저귀,장난감"))
        findCatgLists.add(FindCatgoryData(R.drawable.store_home_find5, "조명", "스탠드,무드등,LED"))
        findCatgLists.add(FindCatgoryData(R.drawable.store_home_find6, "주방용품", "그릇,냄비,후라이펜"))
        findCatgLists.add(FindCatgoryData(R.drawable.store_home_find7, "데코·식물", "그림,캔들,식물"))
        findCatgLists.add(FindCatgoryData(R.drawable.store_home_find8, "수납·정리", "리방박스,행거,수납장"))
        findCatgLists.add(FindCatgoryData(R.drawable.store_home_find9, "생활용품", "욕실,청소,수건·타올"))
        findCatgLists.add(FindCatgoryData(R.drawable.store_home_find10, "생필품", "세제,화장지,제습·탈취·방향제"))
        findCatgLists.add(FindCatgoryData(R.drawable.store_home_find11, "공구·DIY", "시트지,손잡이,드릴,드라이버"))
        findCatgLists.add(FindCatgoryData(R.drawable.store_home_find12, "인테리어시공", "주방,욕실,수도꼭지,빌트인수납"))
        findCatgLists.add(FindCatgoryData(R.drawable.store_home_find13, "반려동물", "사료,패션,고양이 위생,고양이 패션"))
        findCatgLists.add(FindCatgoryData(R.drawable.store_home_find14, "캠핑용품", "캠핑가구,텐트·타프,침낭·매트"))
        findCatgLists.add(FindCatgoryData(R.drawable.store_home_find15, "실내운동", "요가,헬스,필라테스,보호대,체중계"))
        findCatgLists.add(FindCatgoryData(R.drawable.store_home_find16, "렌탈", "정수기,비데,공기청정기,대형가전"))

        storeHomeFindAdpater = StoreHomeFindAdpater(findCatgLists)

        binding.categoryRecyclerView.apply {
            adapter = storeHomeFindAdpater
            layoutManager = GridLayoutManager(context, 4)
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
            binding.tabBanner,
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