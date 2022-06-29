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
import com.manu.todayhouse.config.BaseActivity
import com.manu.todayhouse.databinding.ActivitySignInBinding
import com.manu.todayhouse.databinding.ActivitySignUpBinding
import com.manu.todayhouse.src.login.LoginActivity
import com.manu.todayhouse.src.login.signup.SignUpActivity
import kotlin.math.log

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

        loginBtn.isClickable = false
        loginBtn.isEnabled = false

        var email = ""
        var password = ""

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
                }
            }
        }






        }

    }