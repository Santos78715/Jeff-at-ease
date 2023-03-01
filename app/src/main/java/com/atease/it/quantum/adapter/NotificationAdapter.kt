package com.atease.it.quantum.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.atease.it.quantum.R
import com.atease.it.quantum.response.DummyNotificationData
import com.bumptech.glide.Glide

class NotificationAdapter(private val context: Context) :
    RecyclerView.Adapter<NotificationAdapter.ViewHolder>() {

    var items: ArrayList<DummyNotificationData> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_notifications, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.text_notification.text = item.notification_text
        holder.text_application_status.text = item.notification_status

        val timeAgo = item.timestamp
        holder.text_ago.text = timeAgo

        val category = item.notification_image_category

        if (category == "Connection request"){
            Glide.with(context).load(R.drawable.notification_request)
                .into(holder.notification_image)
        }
        if (category == "Application status"){
            Glide.with(context).load(R.drawable.posted_in_help)
                .into(holder.notification_image)
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text_notification: TextView = itemView.findViewById(R.id.text_notification)
        val text_application_status: TextView = itemView.findViewById(R.id.text_application_status)
        val text_ago: TextView = itemView.findViewById(R.id.text_ago)
        val notification_image: ImageView = itemView.findViewById(R.id.notification_image)
        val notification_layout: ConstraintLayout = itemView.findViewById(R.id.notification_layout)
    }

    fun setData(data: ArrayList<DummyNotificationData>) {
        this.items = data
        notifyDataSetChanged()
    }

}