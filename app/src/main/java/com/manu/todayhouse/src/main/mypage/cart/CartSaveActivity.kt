package com.manu.todayhouse.src.main.mypage.cart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.manu.todayhouse.config.BaseActivity
import com.manu.todayhouse.databinding.ActivityCatgoryBinding
import com.manu.todayhouse.src.main.mypage.cart.model.CartSaveData

class CartSaveActivity : BaseActivity<ActivityCatgoryBinding>(ActivityCatgoryBinding::inflate), CartSaveActivityInterface {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun getCartSaveSuccess(response: CartSaveData) {
        TODO("Not yet implemented")
    }

    override fun getCartSaveFail(message: String) {
        TODO("Not yet implemented")
    }
}