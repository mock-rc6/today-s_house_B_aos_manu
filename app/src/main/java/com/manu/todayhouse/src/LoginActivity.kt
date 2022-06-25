package com.manu.todayhouse.src

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.manu.todayhouse.config.BaseActivity
import com.manu.todayhouse.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.facebookLogoImg.clipToOutline = true

    }
}