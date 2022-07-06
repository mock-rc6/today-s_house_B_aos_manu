package com.manu.todayhouse.src.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.kakao.sdk.auth.LoginClient
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.AuthErrorCause
import com.kakao.sdk.common.util.Utility


import com.manu.todayhouse.config.BaseActivity
import com.manu.todayhouse.databinding.ActivityLoginBinding
import com.manu.todayhouse.src.MainActivity
import com.manu.todayhouse.src.login.model.KaKaoTalkLoginData
import com.manu.todayhouse.src.login.signin.SignInActivity
import com.manu.todayhouse.src.login.signup.SignUpActivity

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate), LoginActivityInterface {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.facebookLogoImg.clipToOutline = true
        binding.kakaoTalkLogin.setOnClickListener {
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            KaKaoLoginService(this@LoginActivity).getKaKaoId()
            startActivity(intent)
        }


        binding.loginNaver.setOnClickListener {
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
        }

        val keyHash = Utility.getKeyHash(this)
        Log.d("hash", keyHash)

        binding.emailSignup.setOnClickListener {
            val intent = Intent(this@LoginActivity, SignUpActivity::class.java)
            startActivity(intent)
        }

        binding.emailLogin.setOnClickListener {
            val intent = Intent(this@LoginActivity, SignInActivity::class.java)
            startActivity(intent)
        }

//        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
//            if (error != null) {
//                when {
//                    error.toString() == AuthErrorCause.AccessDenied.toString() -> {
//                        Toast.makeText(this, "접근이 거부 됨(동의 취소)", Toast.LENGTH_SHORT).show()
//                    }
//                    error.toString() == AuthErrorCause.InvalidClient.toString() -> {
//                        Toast.makeText(this, "유효하지 않은 앱", Toast.LENGTH_SHORT).show()
//                    }
//                    error.toString() == AuthErrorCause.InvalidGrant.toString() -> {
//                        Toast.makeText(this, "인증 수단이 유효하지 않아 인증할 수 없는 상태", Toast.LENGTH_SHORT).show()
//                    }
//                    error.toString() == AuthErrorCause.InvalidRequest.toString() -> {
//                        Toast.makeText(this, "요청 파라미터 오류", Toast.LENGTH_SHORT).show()
//                    }
//                    error.toString() == AuthErrorCause.InvalidScope.toString() -> {
//                        Toast.makeText(this, "유효하지 않은 scope ID", Toast.LENGTH_SHORT).show()
//                    }
//                    error.toString() == AuthErrorCause.Misconfigured.toString() -> {
//                        Toast.makeText(this, "설정이 올바르지 않음(android key hash)", Toast.LENGTH_SHORT).show()
//                    }
//                    error.toString() == AuthErrorCause.ServerError.toString() -> {
//                        Toast.makeText(this, "서버 내부 에러", Toast.LENGTH_SHORT).show()
//                    }
//                    error.toString() == AuthErrorCause.Unauthorized.toString() -> {
//                        Toast.makeText(this, "앱이 요청 권한이 없음", Toast.LENGTH_SHORT).show()
//                    }
//                    else -> { // Unknown
//                        Toast.makeText(this, "기타 에러", Toast.LENGTH_SHORT).show()
//                    }
//                }
//            }
//            else if (token != null) {
//                Toast.makeText(this, "로그인에 성공하였습니다.", Toast.LENGTH_SHORT).show()
//                val intent = Intent(this, MainActivity::class.java)
//                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
//                finish()
//            }
//        }
//
//        binding.kakaoTalkLogin.setOnClickListener{
//            if (LoginClient.instance.isKakaoTalkLoginAvailable(this)){
//                LoginClient.instance.loginWithKakaoTalk(this, callback = callback)
//            } else {
//                LoginClient.instance.loginWithKakaoAccount(this, callback = callback)
//            }
//        }



    }

    override fun onGetKaKaoIdSuccess(response: KaKaoTalkLoginData) {
        binding.kakaoTalkLogin.setOnClickListener {
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onGetKaKaoIdFail(message: String) {
        showCustomToast("오류 : ${message}.")
        Log.d("testtt", "${message}")
    }
}