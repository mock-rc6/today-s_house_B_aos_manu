package com.manu.todayhouse.src.login.signin.repassword.chagepaswword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.manu.todayhouse.config.ApplicationClass
import com.manu.todayhouse.config.BaseActivity
import com.manu.todayhouse.databinding.ActivityChangePasswordBinding
import com.manu.todayhouse.src.login.signin.repassword.chagepaswword.model.ChangePathData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class ChangePasswordActivity : BaseActivity<ActivityChangePasswordBinding>(ActivityChangePasswordBinding::inflate) {

    private var rePassword = HashMap<String, Any>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val changePasswordRetrofit = ApplicationClass.sRetrofit.create(ChangerPasswordRetrofitInterface::class.java)

        changePasswordRetrofit.userLogin(ApplicationClass.sSharedPreferences.getString("userJWT", ""),ApplicationClass.sSharedPreferences.getLong("userIdNo", 17), rePassword).enqueue(
            object : Callback<ChangePathData>{
                override fun onResponse(
                    call: Call<ChangePathData>,
                    response: Response<ChangePathData>
                ) {
                    TODO("Not yet implemented")
                }

                override fun onFailure(call: Call<ChangePathData>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            }
        )

    }



}