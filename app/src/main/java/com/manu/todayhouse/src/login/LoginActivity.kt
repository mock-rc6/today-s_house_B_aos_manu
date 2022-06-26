package com.manu.todayhouse.src.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.manu.todayhouse.config.BaseActivity
import com.manu.todayhouse.databinding.ActivityLoginBinding
import com.manu.todayhouse.src.signup.SignUpActivity

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.facebookLogoImg.clipToOutline = true

        binding.emailSignup.setOnClickListener {
            val intent = Intent(this@LoginActivity, SignUpActivity::class.java)
            startActivity(intent)
        }

    }
}