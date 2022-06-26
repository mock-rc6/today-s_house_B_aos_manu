package com.manu.todayhouse.src.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.manu.todayhouse.config.BaseActivity
import com.manu.todayhouse.databinding.ActivitySplashBinding
import com.manu.todayhouse.src.login.LoginActivity

class SplashActivity : BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate) {

    var handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        handler.postDelayed({
            val intent = Intent(this@SplashActivity, LoginActivity::class.java)
            startActivity(intent)
        }, 1500)
    }

    override fun onDestroy() {
        super.onDestroy()
        finish()
    }
}