package com.manu.todayhouse.src.main.home.popluar

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.manu.todayhouse.R
import com.manu.todayhouse.config.BaseFragment
import com.manu.todayhouse.databinding.FragmentPopluarBinding
import com.manu.todayhouse.src.main.home.popluar.adapter.PopluarBannerAdapter
import com.manu.todayhouse.src.main.home.popluar.adapter.PopluarCatgAdapter
import com.manu.todayhouse.src.main.home.popluar.adapter.PopluarHomeInfoAdapter
import com.manu.todayhouse.src.main.home.popluar.eventpage.model.BannerData
import com.manu.todayhouse.src.main.home.popluar.model.MainHomeData
import com.manu.todayhouse.src.main.home.popluar.eventpage.model.PopluarCategroy

class PopluarFragment : BaseFragment<FragmentPopluarBinding>(FragmentPopluarBinding::bind, R.layout.fragment_popluar), PopluarFragmentInterface {

    private lateinit var popluarBannerAdapter: PopluarBannerAdapter
    private val sliderImageHandler: Handler = Handler(Looper.getMainLooper())
    private val sliderImageRunnable = Runnable { binding.popluarBannerView.currentItem = binding.popluarBannerView.currentItem + 1 }
    private var catgLists = ArrayList<PopluarCategroy>()
    private lateinit var popluarCatgAdapter: PopluarCatgAdapter
    private lateinit var popluarHomeInfoAdapter: PopluarHomeInfoAdapter




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        PopluarService(this@PopluarFragment).getBannerImage()
        PopluarService(this@PopluarFragment).getHomeInfo()

        catgLists.add(PopluarCategroy(R.drawable.home_shopping_btn, "쇼핑하기"))
        catgLists.add(PopluarCategroy(R.drawable.home_quickdel_btn, "빠른배송"))
        catgLists.add(PopluarCategroy(R.drawable.home_n_place, "N평집들이"))
        catgLists.add(PopluarCategroy(R.drawable.home_place_picture, "공간별사진"))
        catgLists.add(PopluarCategroy(R.drawable.home_fix_evnet, "시공이벤트"))
        catgLists.add(PopluarCategroy(R.drawable.home_easy_move, "쉬운이사"))
        catgLists.add(PopluarCategroy(R.drawable.home_today_deal, "오늘의딜"))
        catgLists.add(PopluarCategroy(R.drawable.home_click_cupon, "누르면할인"))
        catgLists.add(PopluarCategroy(R.drawable.home_cat_and_dog, "멍냥템특가"))
        catgLists.add(PopluarCategroy(R.drawable.home_what_home, "집에서뭐해?"))

        popluarCatgAdapter = PopluarCatgAdapter(catgLists)

        val CatgView = binding.popluarCatgView

        CatgView.apply {
            adapter = popluarCatgAdapter
            layoutManager = GridLayoutManager(context, 5)
        }

    }

    override fun onGetBannerImageSuccess(response: BannerData) {

        popluarBannerAdapter = PopluarBannerAdapter(response.result)
        binding.popluarBannerView.apply {
            adapter = popluarBannerAdapter
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.textViewCurrentBanner.text = "${position + 1}"
                    binding.textViewTotalBanner.text = "${response.result.size}"
                    sliderImageHandler.removeCallbacks(sliderImageRunnable)
                    sliderImageHandler.postDelayed(sliderImageRunnable, 3000)
                }
            })

        }
    }

    override fun onResume() {
        super.onResume()
        sliderImageHandler.postDelayed(sliderImageRunnable, 1000)
    }

    override fun onPause() {
        super.onPause()
        sliderImageHandler.removeCallbacks(sliderImageRunnable)
    }

    override fun onGetBannerImageFail(message: String) {
        showCustomToast("오류 : ${message}")
    }

    override fun onGetHomeInfoSuccess(response: MainHomeData) {
        popluarHomeInfoAdapter = PopluarHomeInfoAdapter(response.result.getMainHouseInfos)
        binding.homeInfoRecycler.apply {
            adapter = popluarHomeInfoAdapter
            layoutManager = GridLayoutManager(context, 2)
        }
    }

    override fun onGetHomeInfoFail(message: String) {
        showCustomToast("오류 : ${message}")
    }

}