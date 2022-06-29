package com.manu.todayhouse.src.login.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import com.manu.todayhouse.R
import com.manu.todayhouse.config.BaseActivity
import com.manu.todayhouse.databinding.ActivitySignUpBinding
import com.manu.todayhouse.src.MainActivity
import com.manu.todayhouse.src.login.LoginActivity
import java.util.regex.Pattern

class SignUpActivity : BaseActivity<ActivitySignUpBinding>(ActivitySignUpBinding::inflate) {

    private val emailValidation = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.signUpWarningEmail.visibility = View.INVISIBLE

        binding.signUpBack.setOnClickListener {
            val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
            startActivity(intent)
        }


        var email = ""


        binding.signUpInputEmail.doAfterTextChanged {
            email = it.toString()
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.signUpWarningEmail.text = "이메일을 입력해주세요."
                binding.signUpWarningEmail.visibility = View.VISIBLE
                binding.signUpWarningEmail.setBackgroundColor(R.drawable.activity_warning_sign_up)
                binding.signUpInputEmail.setBackgroundColor(R.drawable.activity_warning_sign_up)
                binding.signUpWarningEmail.scaleY = 1.2f
           } else {
                binding.signUpWarningEmail.text = ""
                binding.signUpWarningEmail.visibility = View.INVISIBLE

            }
        }

    }


}