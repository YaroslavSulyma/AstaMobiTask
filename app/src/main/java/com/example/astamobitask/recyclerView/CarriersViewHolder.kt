package com.example.astamobitask.recyclerView

import android.view.View
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.astamobitask.R

class CarriersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val name = itemView.findViewById(R.id.text_view_name) as TextView
    private var punctuality = itemView.findViewById(R.id.text_view_punctuality) as TextView
    private var accuracy = itemView.findViewById(R.id.text_view_accuracy) as TextView
    private val completedOrders = itemView.findViewById(R.id.text_view_completed_orders) as TextView
    private val workSchedule = itemView.findViewById(R.id.text_view_work_schedule) as TextView
    private val workingDays = itemView.findViewById(R.id.text_view_working_days) as TextView
    private val punctualityRating = itemView.findViewById(R.id.punctuality_rating) as RatingBar
    private val accuracyRating = itemView.findViewById(R.id.accuracy_rating) as RatingBar
    private val buttonOrder = itemView.findViewById(R.id.button_order) as Button
    private val priceForTime = itemView.findViewById(R.id.text_view_price_for_time) as TextView
    private val pricePerTime = itemView.findViewById(R.id.text_view_price_per_hour) as TextView
    private val priceForKilometer = itemView.findViewById(R.id.text_view_price_for_kilometer) as TextView
    private val pricePerKilometer = itemView.findViewById(R.id.text_view_price_per_kilometer) as TextView

}