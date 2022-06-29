package com.manu.todayhouse.src.login.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import com.manu.todayhouse.R
import com.manu.todayhouse.config.BaseActivity
import com.manu.todayhouse.databinding.ActivitySignUpBinding
import com.manu.todayhouse.src.MainActivity
import com.manu.todayhouse.src.login.LoginActivity
import java.util.regex.Pattern

class SignUpActivity : BaseActivity<ActivitySignUpBinding>(ActivitySignUpBinding::inflate) {

    private val emailValidation = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
    private val pwValidation = "^.*(?=^.{8,15}\$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#\$%^&+=]).*\$"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.signUpWarningEmail.visibility = View.GONE
        binding.emailCheckBtn.isEnabled = false
        binding.emailCheckBtn.isClickable = false

        binding.signUpBack.setOnClickListener {
            val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
            startActivity(intent)
        }

        val signupEmail = binding.signUpInputEmail

        var email = ""


        binding.signUpInputEmail.doAfterTextChanged {
            email = it.toString()
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.signUpWarningEmail.text = "이메일을 입력해주세요."
                binding.signUpWarningEmail.visibility = View.VISIBLE
                binding.emailContainer.setBackgroundResource(R.drawable.activity_warning_sign_up)
                binding.emailCheckBtn.isEnabled = false
                binding.emailCheckBtn.isClickable = false

           } else {
                binding.signUpWarningEmail.visibility = View.GONE
                binding.emailCheckBtn.isClickable = true
                binding.emailCheckBtn.isEnabled = true
                binding.emailCheckBtn.setBackgroundResource(R.drawable.sign_up_email_check_bg)
                binding.emailCheckBtn.setTextColor(ContextCompat.getColor(applicationContext!!, R.color.today_house_color))
                binding.emailContainer.setBackgroundResource(R.drawable.sign_up_bg)
                binding.emailContainer.scaleY = 0.9f

            }
        }

        val pwInput = binding.signUpInputPw
        val pwWarning = binding.signUpWarningPw
        val pwCheckInput = binding.signUpInputPwCheck
        val pwCheckWarning = binding.signUpWarningPwCheck
        var pw = ""
        var pwCheck = ""

        pwWarning.visibility = View.GONE
        pwCheckWarning.visibility = View.GONE

        pwInput.doAfterTextChanged {
            pw = it.toString()
            if (Pattern.compile(pwValidation).matcher(pw).matches() || pw.length <= 8) {
                pwWarning.text = "비밀번호는 영문, 숫자를 포함하여 8자 이상이어야 합니다."
                pwWarning.visibility = View.VISIBLE
                binding.pwContainer.setBackgroundResource(R.drawable.activity_warning_sign_up)
            } else {
                pwWarning.visibility = View.GONE
                binding.pwContainer.setBackgroundResource(R.drawable.sign_up_bg)
            }
        }

        pwCheckInput.doAfterTextChanged {
            pwCheck = it.toString()
            if (pwCheck != pw) {
                pwCheckWarning.text = "확인을 위해 비밀번호를 한 번 더 입력해주세요."
                pwCheckWarning.visibility = View.VISIBLE
                binding.pwCheckContainer.setBackgroundResource(R.drawable.activity_warning_sign_up)
            } else  {
                pwCheckWarning.visibility = View.GONE
                binding.pwCheckContainer.setBackgroundResource(R.drawable.sign_up_bg)
            }
        }

        val inputNickname = binding.signUpInputNickname
        val inputWarningNickname = binding.signUpWarningNickname
        inputWarningNickname.visibility = View.GONE
        var nickname = ""

        inputNickname.doAfterTextChanged {
            nickname = it.toString()
            if (nickname.length < 2){
                inputWarningNickname.text = "별명을 2~15자 내로 입력해주세요."
                inputWarningNickname.visibility = View.VISIBLE
                binding.nickNameContainer.setBackgroundResource(R.drawable.activity_warning_sign_up)
            } else {
                inputWarningNickname.visibility = View.GONE
                binding.nickNameContainer.setBackgroundResource(R.drawable.sign_up_bg)
            }
        }


    }


}