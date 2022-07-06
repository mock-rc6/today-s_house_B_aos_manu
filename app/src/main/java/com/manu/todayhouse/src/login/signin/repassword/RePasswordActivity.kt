package com.manu.todayhouse.src.login.signin.repassword

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import com.manu.todayhouse.R
import com.manu.todayhouse.config.BaseActivity
import com.manu.todayhouse.databinding.ActivityRePasswordBinding
import com.manu.todayhouse.src.login.signin.repassword.chagepaswword.ChangePasswordActivity

class RePasswordActivity : BaseActivity<ActivityRePasswordBinding>(ActivityRePasswordBinding::inflate) {


    private var email : String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val emailchecking = binding.reEmailCheck
        val recheckPassword = binding.reCheckPassword
        val recheckBtn = binding.reCheckBtn

        recheckPassword.isEnabled = false
        recheckPassword.isClickable = false
        recheckPassword.setBackgroundResource(R.drawable.register_before_finish)
        recheckBtn.setBackgroundResource(R.drawable.register_before_finish)
        recheckBtn.isEnabled = false
        recheckBtn.isClickable = false


        emailchecking.doAfterTextChanged {
            email = it.toString()
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                recheckPassword.isEnabled = false
                recheckPassword.isClickable = false
                recheckPassword.setBackgroundResource(R.drawable.register_before_finish)
                recheckBtn.setBackgroundResource(R.drawable.register_before_finish)
                recheckBtn.isEnabled = false
                recheckBtn.isClickable = false

            } else{

                recheckPassword.isEnabled = true
                recheckPassword.isClickable = true
                recheckPassword.setBackgroundResource(R.color.today_house_color)
                recheckBtn.setBackgroundResource(R.color.today_house_color)
                recheckBtn.isEnabled = true
                recheckBtn.isClickable = true

            }
        }

        recheckPassword.setOnClickListener {
            val intent = Intent(this@RePasswordActivity, ChangePasswordActivity::class.java)
            startActivity(intent)
        }


    }
}