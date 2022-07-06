package com.manu.todayhouse.src.main.mypage.cart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.manu.todayhouse.config.BaseActivity
import com.manu.todayhouse.databinding.ActivityCartSaveBinding
import com.manu.todayhouse.databinding.ActivityCatgoryBinding
import com.manu.todayhouse.src.main.mypage.cart.adapter.CartSaveAdapter
import com.manu.todayhouse.src.main.mypage.cart.model.CartSaveData

class CartSaveActivity : BaseActivity<ActivityCartSaveBinding>(ActivityCartSaveBinding::inflate), CartSaveActivityInterface {

    private lateinit var cartSaveApater : CartSaveAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        CartSaveService(this).getCartSave()

    }

    override fun getCartSaveSuccess(response: CartSaveData) {
        cartSaveApater = CartSaveAdapter(response.result.kartItemList)

        val cartRecycler = binding.cartSaveRecycler

        cartRecycler.apply {
            adapter = cartSaveApater
        }
    }

    override fun getCartSaveFail(message: String) {
        showCustomToast("오류 : $message")
    }
}