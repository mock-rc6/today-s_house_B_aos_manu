package com.manu.todayhouse.src.login.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.core.widget.addTextChangedListener
import com.manu.todayhouse.config.BaseActivity
import com.manu.todayhouse.databinding.ActivitySignUpBinding
import com.manu.todayhouse.src.MainActivity
import com.manu.todayhouse.src.login.LoginActivity
import java.util.regex.Pattern

class SignUpActivity : BaseActivity<ActivitySignUpBinding>(ActivitySignUpBinding::inflate) {

    private val emailValidation = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.signUpBack.setOnClickListener {
            val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.signUpInputEmail.addTextChangedListener { object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                TODO("Not yet implemented")
            }

            override fun afterTextChanged(s: Editable?) {
                checkEmail()
            }

        } }

    }

    fun checkEmail() : Boolean {
        var email = binding.signUpInputEmail.text.toString().trim()
        val p = Pattern.matches(emailValidation, email)

        if (p) {
            binding.signUpWarningEmail.visibility = View.INVISIBLE
            return true
        } else {
            binding.signUpWarningEmail.visibility = View.VISIBLE
            return false
        }
    }
}