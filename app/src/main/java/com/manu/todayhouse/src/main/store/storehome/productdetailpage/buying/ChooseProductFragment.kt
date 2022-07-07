package com.manu.todayhouse.src.main.store.storehome.productdetailpage.buying

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.manu.todayhouse.R
import com.manu.todayhouse.config.ApplicationClass
import com.manu.todayhouse.config.BaseFragment
import com.manu.todayhouse.databinding.FragmentChooseProductBinding
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.ProductDetailActivity
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.buying.adapter.ChooseOptionAdapter
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.buying.adapter.ChooseSelectedAdpater
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.buying.model.CardAdd
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.buying.model.CartOptionData
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.buying.model.ResultX
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ChooseProductFragment : BaseFragment<FragmentChooseProductBinding>(FragmentChooseProductBinding::bind, R.layout.fragment_choose_product), ChooseproductFragmentInterface {

    private var cartAddHash = HashMap<String, Any>()
    private lateinit var chooseOptionAdapter: ChooseOptionAdapter
    private lateinit var chooseSelectedAdpater: ChooseSelectedAdpater


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.optionNameChoose.visibility = View.GONE
        binding.chooseDiscountPercentChoose.visibility = View.GONE
        binding.productPriceChoose.visibility = View.GONE
        binding.freeDeliveryChooseProduct.visibility = View.GONE
        binding.dealPriceChoose.visibility = View.GONE
        binding.optionItemSelected.visibility = View.GONE

        binding.optionItem.visibility = View.GONE
        ChooseProductService(this).getCartOption()

        binding.optionChooseCheck.setOnClickListener {
            binding.optionItem.visibility = View.VISIBLE
            binding.optionItem.isClickable = true
            binding.optionItem.isEnabled = true
            binding.optionItem.isSelected = true
            binding.optionItemSelected.visibility = View.GONE
            binding.chooseTextContainer.visibility = View.GONE
        }

        binding.optionItemDown.setOnClickListener {
            binding.optionItem.visibility = View.GONE
            binding.optionItemSelected.visibility = View.VISIBLE
        }







        binding.stopRemoveView.setOnClickListener {
            val intent = Intent(context, ProductDetailActivity::class.java)
            startActivity(intent)
        }

        cartAddHash["optionId"] = ApplicationClass.sSharedPreferences.getLong("optionId", 6)
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
                            showCustomToast("${result?.message}")
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








        Log.d("Testt", "${ApplicationClass.sSharedPreferences.getLong("optionId", 100)}")


        chooseOptionAdapter.setOnItemClickListener(
            object : ChooseOptionAdapter.onItemClickListener{
                override fun onItemClick(v: View, data: ResultX, pos: Int) {
                    binding.allPrice.text = data.saledPrice.toString() + "원"
                    optionItem.visibility = View.GONE
                    binding.optionNameChoose.visibility = View.VISIBLE
                    binding.chooseDiscountPercentChoose.visibility = View.VISIBLE
                    binding.productPriceChoose.visibility = View.VISIBLE
                    binding.freeDeliveryChooseProduct.visibility = View.VISIBLE
                    binding.dealPriceChoose.visibility = View.VISIBLE
                    binding.chooseProudctNameText.visibility = View.GONE
                    binding.chooseTextContainer.visibility = View.VISIBLE

                    binding.optionNameChoose.text = data.optionName
                    binding.chooseDiscountPercentChoose.text = data.saleRate
                    binding.productPriceChoose.text = data.saledPrice.toString()
                    binding.freeDeliveryChooseProduct.text = data.delivery
                    binding.dealPriceChoose.text = data.specialPrice





                    chooseSelectedAdpater = ChooseSelectedAdpater(listOf(data))

                    binding.optionItemSelected.apply {
                        adapter = chooseSelectedAdpater
                    }

                    binding.optionItemSelected.visibility = View.VISIBLE



                    chooseSelectedAdpater.setOnItemClickListener(
                        object : ChooseSelectedAdpater.onItemClickListener{
                            override fun onItemClick(v: View, data: ResultX, pos: Int) {
                                var counts : Int = 1
                                val price = v.findViewById<TextView>(R.id.option_cart_price_selected)
                                val priceCount = v.findViewById<TextView>(R.id.product_count)
                                v.findViewById<ImageView>(R.id.count_plus_btn).setOnClickListener {
                                    counts += 1
                                    priceCount.text = counts.toString()
                                    price.text = (data.saledPrice * counts).toString() + "원"
                                    binding.allPrice.text = price.text
                                }

                                v.findViewById<ImageView>(R.id.count_minus_btn).setOnClickListener {
                                    if (counts != 0){
                                        counts -= 1
                                        priceCount.text = counts.toString()
                                        price.text = (data.saledPrice * counts).toString() + "원"
                                        binding.allPrice.text = price.text
                                    }
                                }



                            }

                        }
                    )



                }

            }
        )
    }

    override fun CartAddFail(message: String) {
        showCustomToast("오류 : $message")
    }

}