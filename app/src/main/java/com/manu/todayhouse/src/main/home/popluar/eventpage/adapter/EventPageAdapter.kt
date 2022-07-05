package com.manu.todayhouse.src.main.home.popluar.eventpage.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.manu.todayhouse.R
import com.manu.todayhouse.config.ApplicationClass
import com.manu.todayhouse.src.main.home.popluar.eventpage.eventdetail.EventDetailActivity
import com.manu.todayhouse.src.main.home.popluar.eventpage.model.Result

class EventPageAdapter(val eventList : List<Result>) : RecyclerView.Adapter<EventPageAdapter.EventPageView>() {


    inner class EventPageView(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.banner_event_view_item, parent, false)
    ) {
        val eventImg = itemView.findViewById<ImageView>(R.id.evnet_img_list)
        val dueText = itemView.findViewById<TextView>(R.id.envent_due_text)

        fun onBindWith(eventLists : Result) {
            Glide.with(itemView).load(eventLists.bannerPic).into(eventImg)
            dueText.text = eventLists.due

//            eventImg.setOnClickListener {
//                val intent = Intent(itemView.context, EventDetailActivity::class.java)
//
//                itemView.context.startActivity(intent)
//                val eventId = ApplicationClass.sSharedPreferences.edit()
//                eventId.putInt("eventId", eventLists.eventId)
//                eventId.apply()
//
//
//            }

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EventPageView {
        return EventPageView((parent))
    }

    override fun onBindViewHolder(holder: EventPageView, position: Int) {
        holder.onBindWith(eventList[position])
        holder.eventImg.setOnClickListener {
            val intent = Intent(holder.itemView.context, EventDetailActivity::class.java)
            intent.putExtra("eventId", eventList[position].eventId)
            holder.itemView.context.startActivity(intent)

        }

    }

    override fun getItemCount(): Int {
        return eventList.size
    }
}