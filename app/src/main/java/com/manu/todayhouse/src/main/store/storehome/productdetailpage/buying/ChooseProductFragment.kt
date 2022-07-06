package com.manu.todayhouse.src.main.store.storehome.productdetailpage.buying

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.manu.todayhouse.R
import com.manu.todayhouse.config.ApplicationClass
import com.manu.todayhouse.config.BaseFragment
import com.manu.todayhouse.databinding.FragmentChooseProductBinding
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.ProductDetailActivity
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.buying.adapter.ChooseOptionAdapter
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.buying.model.CardAdd
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.buying.model.CartOptionData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create


class ChooseProductFragment : BaseFragment<FragmentChooseProductBinding>(FragmentChooseProductBinding::bind, R.layout.fragment_choose_product), ChooseproductFragmentInterface {

    private var cartAddHash = HashMap<String, Any>()
    private lateinit var chooseOptionAdapter: ChooseOptionAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.optionItem.visibility = View.GONE
        ChooseProductService(this).getCartOption()

        binding.optionChooseCheck.setOnClickListener {
            binding.optionItem.visibility = View.VISIBLE
        }





        Log.d("testtt", "${ApplicationClass.sSharedPreferences.getLong("ItemNo", 100)}")

        binding.stopRemoveView.setOnClickListener {
            val intent = Intent(context, ProductDetailActivity::class.java)
            startActivity(intent)
        }

        cartAddHash["optionId"] = 1
        cartAddHash["number"] = 1

        binding.addCart.setOnClickListener {
            val chooseProductRetrofit = ApplicationClass.sRetrofit.create(ChooseProductRetrofit::class.java)

            chooseProductRetrofit.postAddCart(
                ApplicationClass.sSharedPreferences.getString("userJWT", null),
                ApplicationClass.sSharedPreferences.getLong("userIdNo", 17),
                ApplicationClass.sSharedPreferences.getLong("ItemNo", 1),cartAddHash
            ).enqueue(
                object : Callback<CardAdd>{
                    override fun onResponse(call: Call<CardAdd>, response: Response<CardAdd>) {
                        if (response.isSuccessful){
                            val result = response.body()

                        }
                    }

                    override fun onFailure(call: Call<CardAdd>, t: Throwable) {
                        showCustomToast(t.message ?: "통신오류")
                    }

                }
            )
        }




    }

    override fun CartAddSuccess(response: CartOptionData) {
        val result = response.result

        val thumnailImg = binding.chooseThumnail

        Glide.with(this).load(result[0].thumbnail).into(thumnailImg)

        val optionItem = binding.optionItem
        chooseOptionAdapter = ChooseOptionAdapter(response.result)
        optionItem.apply {
            adapter = chooseOptionAdapter
        }
    }

    override fun CartAddFail(message: String) {
        showCustomToast("오류 : $message")
    }

}