package com.manu.todayhouse.src.main.mypage.myshopping.cupon.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.manu.todayhouse.R
import com.manu.todayhouse.src.main.mypage.myshopping.cupon.model.Result

class GetCuponRecyclerAdapter(val getCupon : List<Result>) : RecyclerView.Adapter<GetCuponRecyclerAdapter.GetCuponView>() {

    inner class GetCuponView(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.get_cupon_item, parent, false)
    ){

        val cuponName = itemView.findViewById<TextView>(R.id.cupon_name)
        val benefitCupon = itemView.findViewById<TextView>(R.id.benefit_cupon)
        val dueCupon = itemView.findViewById<TextView>(R.id.cupon_due)


        fun onBindWith(getCupons : Result){
            cuponName.text = getCupons.description
            benefitCupon.text = getCupons.benefit
            dueCupon.text = getCupons.due
        }


    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GetCuponRecyclerAdapter.GetCuponView {
        return GetCuponView((parent))
    }

    override fun onBindViewHolder(holder: GetCuponRecyclerAdapter.GetCuponView, position: Int) {
        holder.onBindWith(getCupon[position])
    }

    override fun getItemCount(): Int {
        return getCupon.size
    }
}