package com.manu.todayhouse.src.login.signin.repassword.chagepaswword

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.widget.doAfterTextChanged
import com.manu.todayhouse.config.ApplicationClass
import com.manu.todayhouse.config.BaseActivity
import com.manu.todayhouse.databinding.ActivityChangePasswordBinding
import com.manu.todayhouse.src.login.LoginActivity
import com.manu.todayhouse.src.login.signin.repassword.chagepaswword.model.ChangePathData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create
import java.util.regex.Pattern

class ChangePasswordActivity : BaseActivity<ActivityChangePasswordBinding>(ActivityChangePasswordBinding::inflate) {

    private var rePassword = HashMap<String, Any>()
    private var pw : String = ""
    private var pwCheck : String = ""
    private val pwValidation = "^.*(?=^.{8,15}\$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#\$%^&+=]).*\$"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val exit = binding.exitBack

        exit.setOnClickListener {
            val intent = Intent(this@ChangePasswordActivity, LoginActivity::class.java)
            startActivity(intent)
        }

        val changePasswordRetrofit = ApplicationClass.sRetrofit.create(ChangerPasswordRetrofitInterface::class.java)

        changePasswordRetrofit.userLogin(ApplicationClass.sSharedPreferences.getString("userJWT", ""),ApplicationClass.sSharedPreferences.getLong("userIdNo", 17), rePassword).enqueue(
            object : Callback<ChangePathData>{
                override fun onResponse(
                    call: Call<ChangePathData>,
                    response: Response<ChangePathData>
                ) {
                    val changePw = binding.changePwText
                    val changePwCheck = binding.changePwCheck

                    changePw.doAfterTextChanged {
                        pw = it.toString()
                    }

                    changePwCheck.doAfterTextChanged {
                        pwCheck = it.toString()
                    }

                    binding.registerEmail.setOnClickListener {
                        rePassword["password"] = pw
                        if (Pattern.compile(pwValidation).matcher(pw).matches() || pw.length <= 8 || pw == pwCheck){
                            showCustomToast("비밀번호를 확인해 주세요!")
                        } else {
                            val intent = Intent(this@ChangePasswordActivity, LoginActivity::class.java)
                            startActivity(intent)
                            showCustomToast("비밀번호 변경이 완료되었습니다.")
                        }
                    }

                }

                override fun onFailure(call: Call<ChangePathData>, t: Throwable) {
                    showCustomToast(t.message ?: "통신오류")
                }

            }
        )

    }



}