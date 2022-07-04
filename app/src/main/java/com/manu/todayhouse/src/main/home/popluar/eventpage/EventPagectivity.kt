package com.manu.todayhouse.src.main.home.popluar.eventpage

import android.content.Intent
import android.os.Bundle
import com.manu.todayhouse.config.ApplicationClass
import com.manu.todayhouse.config.BaseActivity
import com.manu.todayhouse.databinding.ActivityEventPageBinding
import com.manu.todayhouse.src.MainActivity
import com.manu.todayhouse.src.main.home.popluar.PopluarFragmentInterface
import com.manu.todayhouse.src.main.home.popluar.PopluarService
import com.manu.todayhouse.src.main.home.popluar.eventpage.adapter.EventPageAdapter
import com.manu.todayhouse.src.main.home.popluar.eventpage.model.BannerData
import com.manu.todayhouse.src.main.home.popluar.model.MainHomeData

class EventPagectivity : BaseActivity<ActivityEventPageBinding>(ActivityEventPageBinding::inflate), EventActivityInterface {

    private lateinit var eventPageAdapter: EventPageAdapter
    val eventRetrofitInterface = ApplicationClass.sRetrofit.create(EventBannerRetrofitInterface::class.java)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val exit = binding.exitBack

        EventService(this@EventPagectivity).getBannerImage()

        exit.setOnClickListener {
            val intent = Intent(this@EventPagectivity, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onGetEventBannerImageSuccess(response: BannerData) {
        eventPageAdapter = EventPageAdapter(response.result)

        binding.bannerEventView.apply {
            adapter = eventPageAdapter
        }

    }


    override fun onGetEventBannerImageFail(message: String) {
        showCustomToast("오류 : ${message}")
    }


}