package com.manu.todayhouse.src.main.store.storehome.productdetailpage.buying.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.manu.todayhouse.R
import com.manu.todayhouse.config.ApplicationClass
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.buying.model.ResultX

class ChooseSelectedAdpater(val selectedList : List<ResultX>) : RecyclerView.Adapter<ChooseSelectedAdpater.SelectedView>() {

    inner class SelectedView(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.choose_item_selected, parent, false)
    ){

        var count : Int = 1
        val productCount = itemView.findViewById<TextView>(R.id.product_count)
        val titleSelected = itemView.findViewById<TextView>(R.id.option_choice_name_title_selected)
        val priceSleected = itemView.findViewById<TextView>(R.id.option_cart_price_selected)
        val countPlus = itemView.findViewById<ImageView>(R.id.count_plus_btn)
        val countMinus = itemView.findViewById<ImageView>(R.id.count_minus_btn)


        fun onBindWith(selectedLists : ResultX){

            productCount.text = count.toString()
            titleSelected.text = selectedLists.optionName
            priceSleected.text = (selectedLists.saledPrice * count).toString() + "원"

            countPlus.setOnClickListener {
                    count += 1
                    productCount.text = count.toString()
                    priceSleected.text = (selectedLists.saledPrice * count).toString() + "원"


            }

            countMinus.setOnClickListener {
                if (count != 0){
                    count -= 1
                    productCount.text = count.toString()
                }

                priceSleected.text = (selectedLists.saledPrice.toInt() * count).toString() + "원"
            }


            val pos = adapterPosition

            if (pos != RecyclerView.NO_POSITION){
                itemView.setOnClickListener {
                    val optionId = ApplicationClass.sSharedPreferences.edit()
                    optionId.putLong("optionId", selectedLists.optionId)
                    optionId.apply()
                    listener?.onItemClick(itemView, selectedLists, pos)
                    it.isSelected = true
                }

            }


        }

    }

    interface onItemClickListener {
        fun onItemClick(v : View, data : ResultX, pos : Int)

    }
    private var listener : onItemClickListener? = null

    fun setOnItemClickListener(listener : onItemClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectedView {
        return SelectedView((parent))
    }

    override fun onBindViewHolder(holder: SelectedView, position: Int) {
        holder.onBindWith(selectedList[position])
    }

    override fun getItemCount(): Int {
        return selectedList.size
    }


}