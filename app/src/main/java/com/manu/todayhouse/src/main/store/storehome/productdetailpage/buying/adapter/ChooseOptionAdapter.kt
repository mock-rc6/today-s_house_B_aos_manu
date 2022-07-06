package com.manu.todayhouse.src.main.store.storehome.productdetailpage.buying.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.manu.todayhouse.R
import com.manu.todayhouse.config.ApplicationClass
import com.manu.todayhouse.src.main.store.storehome.productdetailpage.buying.model.ResultX

class ChooseOptionAdapter(val chooseList : List<ResultX>) : RecyclerView.Adapter<ChooseOptionAdapter.OptionView>() {

    inner class OptionView(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.choose_option_item, parent, false)
    ){
        val optionNumber = itemView.findViewById<TextView>(R.id.option_number)
        val optionThunmail = itemView.findViewById<ImageView>(R.id.option_thumnail)
        val optionName = itemView.findViewById<TextView>(R.id.option_name)
        val percent = itemView.findViewById<TextView>(R.id.choose_discount_percent)
        val price = itemView.findViewById<TextView>(R.id.product_price_choose)
        val delivery = itemView.findViewById<TextView>(R.id.free_delivery_choose)
        val deal = itemView.findViewById<TextView>(R.id.deal_price_choose)

        val allChoiceContainer: ConstraintLayout = itemView.findViewById<ConstraintLayout>(R.id.all_choice_container)

        fun onBindWith(chooseLists : ResultX){
            Glide.with(itemView.context).load(chooseLists.thumbnail).into(optionThunmail)
            optionName.text = chooseLists.optionName
            percent.text = chooseLists.saleRate
            price.text = chooseLists.saledPrice
            delivery.text = chooseLists.delivery
            deal.text = chooseLists.specialPrice

            val pos = adapterPosition

            if (pos != RecyclerView.NO_POSITION){
                allChoiceContainer.setOnClickListener {
                    val optionId = ApplicationClass.sSharedPreferences.edit()
                    optionId.putLong("optionId", chooseLists.optionId)
                    optionId.apply()
                    listener?.onItemClick(itemView, chooseLists, pos)
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

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChooseOptionAdapter.OptionView {
        return OptionView((parent))
    }


    override fun onBindViewHolder(holder: ChooseOptionAdapter.OptionView, position: Int) {
        holder.onBindWith(chooseList[position])
        holder.optionNumber.text = (position + 1).toString()
//        holder.allChoiceContainer.setOnClickListener {
//            val optionId = ApplicationClass.sSharedPreferences.edit()
//            optionId.putLong("optionId", chooseList[position].optionId)
//            optionId.apply()
//            it.isSelected = true
//        }
    }



    override fun getItemCount(): Int {
        return chooseList.size
    }
}