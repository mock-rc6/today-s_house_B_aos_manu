package com.manu.todayhouse.src.main.home.popluar.eventpage.eventdetail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.manu.todayhouse.config.ApplicationClass
import com.manu.todayhouse.config.BaseActivity
import com.manu.todayhouse.databinding.ActivityEventDetailBinding
import com.manu.todayhouse.src.MainActivity
import com.manu.todayhouse.src.login.signin.SignInRetrofitInterface
import com.manu.todayhouse.src.login.signup.model.SignUpData
import com.manu.todayhouse.src.main.home.popluar.eventpage.EventPagectivity
import com.manu.todayhouse.src.main.home.popluar.eventpage.model.EventImageDetail
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EventDetailActivity : BaseActivity<ActivityEventDetailBinding>(ActivityEventDetailBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.eventDetailBack.setOnClickListener {
            val intent = Intent(this@EventDetailActivity, EventPagectivity::class.java)
            startActivity(intent)
        }

        Log.d("testt", "${intent.getLongExtra("eventId", 100)}")

        val eventDetailRetrofitInterface =
            ApplicationClass.sRetrofit.create(EvenDetailRetrofitInterface::class.java)

        eventDetailRetrofitInterface.getEventDetailImage(intent.getLongExtra("eventId", 100)).enqueue(
            object : Callback<EventImageDetail>{
                override fun onResponse(
                    call: Call<EventImageDetail>,
                    response: Response<EventImageDetail>
                ) {

                    val detailResult = response.body()
                    val detailImg1 = binding.eventDetailImg1
                    val detailImg2 = binding.eventDetailImg2
                    val detailImg3 = binding.eventDetailImg3
                    val img1 = detailResult?.result!!.imgUrlList[0]
                    val img2 = detailResult?.result!!.imgUrlList[1]
                    val img3 = detailResult?.result!!.imgUrlList[2]

                    if (response.isSuccessful){
                        binding.eventDetailText.text = detailResult?.result?.eventName
                        Glide.with(this@EventDetailActivity).load(img1).into(binding.eventDetailImg1)
                        Glide.with(this@EventDetailActivity).load(img2).into(binding.eventDetailImg2)
                        Glide.with(this@EventDetailActivity).load(img3).into(binding.eventDetailImg3)
                    } else {
                        showCustomToast("코드확인")
                    }
                }

                override fun onFailure(call: Call<EventImageDetail>, t: Throwable) {
                    showCustomToast(t.message ?: "통신오류")
                }

            }
        )

    }

}