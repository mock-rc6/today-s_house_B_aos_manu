package com.manu.todayhouse.src.login.signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import com.manu.todayhouse.R
import com.manu.todayhouse.config.BaseActivity
import com.manu.todayhouse.databinding.ActivitySignInBinding
import com.manu.todayhouse.databinding.ActivitySignUpBinding
import com.manu.todayhouse.src.login.LoginActivity

class SignInActivity : BaseActivity<ActivitySignInBinding>(ActivitySignInBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.signInBack.setOnClickListener {
            val intent = Intent(this@SignInActivity, LoginActivity::class.java)
            startActivity(intent)
        }

        val loginBtn = binding.signInBtn
        val emailLogIn = binding.signInText
        val pwLogIn = binding.signInPw

//        loginBtn.isEnabled = false
//        loginBtn.setBackgroundColor(R.color.today_house_color_light.toInt())





        }

    }