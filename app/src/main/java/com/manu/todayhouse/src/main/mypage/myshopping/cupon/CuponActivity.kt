package com.manu.todayhouse.src.main.mypage.myshopping.cupon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.GridLayoutManager
import com.manu.todayhouse.config.ApplicationClass
import com.manu.todayhouse.config.BaseActivity
import com.manu.todayhouse.databinding.ActivityCuponBinding
import com.manu.todayhouse.src.main.mypage.myshopping.cupon.adapter.GetCuponRecyclerAdapter
import com.manu.todayhouse.src.main.mypage.myshopping.cupon.model.CuponData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class CuponActivity : BaseActivity<ActivityCuponBinding>(ActivityCuponBinding::inflate), CuponActivityInterface {

    private lateinit var getCuponRecyclerAdapter: GetCuponRecyclerAdapter
    private var cuponCode  = HashMap<String, String>()
    var cupon : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val cuponRetrofitService = ApplicationClass.sRetrofit.create(CuponRetofit::class.java)

        CuponService(this).getCupon()

        binding.registerCupon.doAfterTextChanged {
            cupon = it.toString()
            cuponCode["couponCode"] = cupon
        }

        binding.registerCuponBtn.setOnClickListener {
            cuponCode["couponCode"] = cupon
            Log.d("Testt", "$cupon")
            cuponRetrofitService.postCupon(
                ApplicationClass.sSharedPreferences.getString("userJWT", null),
                ApplicationClass.sSharedPreferences.getLong("userIdNo", 17),
                cuponCode
            ).enqueue(
                object : Callback<CuponData> {
                    override fun onResponse(call: Call<CuponData>, response: Response<CuponData>) {
                        if (response.isSuccessful) {
                            val responseData = response.body()
                            showCustomToast("${responseData?.message}")
                        }
                    }

                    override fun onFailure(call: Call<CuponData>, t: Throwable) {
                        showCustomToast(t.message ?: "통신 오류")
                    }

                }
            )
        }



    }

    override fun getCuponSuccess(response: CuponData) {
        val cupongetRecycler = binding.getCuponRecycler

        getCuponRecyclerAdapter = GetCuponRecyclerAdapter(response.result)

        cupongetRecycler.apply {
            adapter = getCuponRecyclerAdapter
            layoutManager = GridLayoutManager(this@CuponActivity, 2)
        }


    }

    override fun getCuponFail(message: String) {
        showCustomToast("오류 : $message")
    }

}