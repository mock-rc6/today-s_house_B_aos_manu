package com.manu.todayhouse.src.login.signin

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.core.content.res.ResourcesCompat
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import com.manu.todayhouse.R
import com.manu.todayhouse.config.ApplicationClass
import com.manu.todayhouse.config.BaseActivity
import com.manu.todayhouse.databinding.ActivitySignInBinding
import com.manu.todayhouse.databinding.ActivitySignUpBinding
import com.manu.todayhouse.src.MainActivity
import com.manu.todayhouse.src.login.LoginActivity
import com.manu.todayhouse.src.login.signup.SignUpActivity
import com.manu.todayhouse.src.login.signup.SignupRetrofitInterface
import com.manu.todayhouse.src.login.signup.model.SignUpData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class SignInActivity : BaseActivity<ActivitySignInBinding>(ActivitySignInBinding::inflate) {

    private var email = ""
    private var password = ""
    private var userLogin = HashMap<String, Any>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.signInBack.setOnClickListener {
            val intent = Intent(this@SignInActivity, LoginActivity::class.java)
            startActivity(intent)
        }

        val loginBtn = binding.signInBtn
        val emailLogIn = binding.signInText
        val pwLogIn = binding.signInPw

        loginBtn.isClickable = false
        loginBtn.isEnabled = false
        loginBtn.setBackgroundResource(R.color.today_house_color_light)


        emailLogIn.doAfterTextChanged {
            email = it.toString()
            pwLogIn.doAfterTextChanged {
                password = it.toString()
                if (email.length < 1 && password.length < 1){
                    loginBtn.isClickable = false
                    loginBtn.isEnabled = false

                } else {
                    loginBtn.isClickable = true
                    loginBtn.isEnabled = true
                    loginBtn.setBackgroundResource(R.color.today_house_color)
                }
            }
        }

        val signinRetrofitInterface = ApplicationClass.sRetrofit.create(SignInRetrofitInterface::class.java)

        binding.signInBtn.setOnClickListener {
            userLogin["email"] = email
            userLogin["password"] = password
            var userJwt = ""

            signinRetrofitInterface.userLogin(userLogin).enqueue(object : Callback<SignUpData>{
                override fun onResponse(call: Call<SignUpData>, response: Response<SignUpData>) {
                    var userJWT = response.body() as SignUpData
                }

                override fun onFailure(call: Call<SignUpData>, t: Throwable) {
                    showCustomToast(t.message ?: "아이디 비밀번호를 확인하세요!")
                }



            })
            val intent = Intent(this@SignInActivity, MainActivity::class.java)
            startActivity(intent)
        }






        }

    }