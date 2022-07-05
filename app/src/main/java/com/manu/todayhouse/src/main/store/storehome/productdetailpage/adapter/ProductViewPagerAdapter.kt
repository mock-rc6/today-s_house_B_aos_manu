package com.manu.todayhouse.src.main.store.storehome.productdetailpage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.manu.todayhouse.R
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.model.Result

class ProductViewPagerAdapter(var productImg : List<String>) : RecyclerView.Adapter<ProductViewPagerAdapter.ProductDetailView>(){

    inner class ProductDetailView(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.product_detail_viewpager, parent, false)
    ) {
        val detailImg = itemView.findViewById<ImageView>(R.id.product_view_img)

        fun onBindWith(productImg: String) {
            Glide.with(itemView.context).load(productImg).into(detailImg)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductViewPagerAdapter.ProductDetailView {
        return ProductDetailView((parent))
    }

    override fun onBindViewHolder(
        holder: ProductViewPagerAdapter.ProductDetailView,
        position: Int
    ) {
        holder.onBindWith(productImg[position])
    }

    override fun getItemCount(): Int {
        return productImg.size
    }
}