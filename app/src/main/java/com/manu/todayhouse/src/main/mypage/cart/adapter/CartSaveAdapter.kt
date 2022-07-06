package com.manu.todayhouse.src.main.mypage.cart.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.MethodCallsLogger
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.manu.todayhouse.R
import com.manu.todayhouse.src.main.mypage.cart.model.KartItem

class CartSaveAdapter(val cartList : List<KartItem>) :RecyclerView.Adapter<CartSaveAdapter.CartSaveView>() {


    inner class CartSaveView(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.cart_save_item, parent, false)
    ) {
        val deliverCompany = itemView.findViewById<TextView>(R.id.cart_save_deliver_company)
        val cartsaveImg = itemView.findViewById<ImageView>(R.id.cart_save_img)
        val productName = itemView.findViewById<TextView>(R.id.cart_product_name)
        val optionChoiceTitle = itemView.findViewById<TextView>(R.id.option_choice_name_title)
        val optionPrice = itemView.findViewById<TextView>(R.id.option_cart_price)
        val totalPrice = itemView.findViewById<TextView>(R.id.cart_total_price)

        fun onBindWith(cartLists : KartItem) {

            Glide.with(itemView).load(cartLists.imgUrl).into(cartsaveImg)
            optionChoiceTitle.text = cartLists.optionName
            optionPrice.text = cartLists.price
            totalPrice.text = cartLists.price

        }

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CartSaveAdapter.CartSaveView {
        return CartSaveView((parent))
    }

    override fun onBindViewHolder(holder: CartSaveAdapter.CartSaveView, position: Int) {
        holder.onBindWith(cartList[position])
    }

    override fun getItemCount(): Int {
        return cartList.size
    }
}