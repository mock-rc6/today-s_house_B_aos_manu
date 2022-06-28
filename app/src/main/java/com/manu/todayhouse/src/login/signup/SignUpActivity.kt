package com.manu.todayhouse.src.login.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.manu.todayhouse.config.BaseActivity
import com.manu.todayhouse.databinding.ActivitySignUpBinding
import com.manu.todayhouse.src.MainActivity
import com.manu.todayhouse.src.login.LoginActivity

class SignUpActivity : BaseActivity<ActivitySignUpBinding>(ActivitySignUpBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.signUpBack.setOnClickListener {
            val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}