package com.example.astamobitask.ui.carrierFragment.carrierRecyclerView

import android.util.Log
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.astamobitask.R
import com.squareup.picasso.Picasso

class CarriersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val name = itemView.findViewById(R.id.text_view_name) as TextView
    private val avatar = itemView.findViewById(R.id.image_view_avatar) as ImageView
    private val ratingPunctuality =
            itemView.findViewById(R.id.text_view_rating_punctuality) as TextView
    private val ratingSpeed = itemView.findViewById(R.id.text_view_rating_speed) as TextView
    private val completedOrders = itemView.findViewById(R.id.text_view_completed_orders) as TextView
    private val workSchedule = itemView.findViewById(R.id.text_view_work_schedule) as TextView
    private val workingDays = itemView.findViewById(R.id.text_view_working_days) as TextView
    private val punctualityRating = itemView.findViewById(R.id.punctuality_rating) as RatingBar
    private val accuracyRating = itemView.findViewById(R.id.accuracy_rating) as RatingBar
    private val buttonOrder = itemView.findViewById(R.id.button_order) as Button
    private val priceForTime = itemView.findViewById(R.id.text_view_price_for_time) as TextView
    private val pricePerTime = itemView.findViewById(R.id.text_view_price_per_hour) as TextView
    private val priceForKilometer =
            itemView.findViewById(R.id.text_view_price_for_kilometer) as TextView
    private val pricePerKilometer =
            itemView.findViewById(R.id.text_view_price_per_kilometer) as TextView
    private val expand = itemView.findViewById(R.id.clickable_constraint_layout) as ConstraintLayout
    private val priceLayout = itemView.findViewById(R.id.price_layout) as LinearLayout

    private var expanded: Boolean = false

    fun onBind(item: Worker) {
        if (item.getSuccess()) {
            for(i in item.getData().indices){
                name.text = item.getData()[i].getName()
                Picasso.get().load(item.getData()[i].getAvatar()).into(avatar)
                ratingPunctuality.text = item.getData()[i].getRatingPunctuality().toString()
                ratingSpeed.text = item.getData()[i].getRatingSpeed().toString()
                punctualityRating.rating = item.getData()[i].getRatingPunctuality().toFloat()
                accuracyRating.rating = item.getData()[i].getRatingSpeed().toFloat()
                completedOrders.text = item.getData()[i].getOrders()
                workSchedule.text = item.getData()[i].getWorkSchedule().getTime()
                val week: MutableList<String> = arrayListOf()
                for (k in item.getData()[i].getWorkSchedule().getDayOfWeek().indices) {
                    when (k) {
                        0 -> week.add("Пн")
                        1 -> week.add("ВТ")
                        2 -> week.add("Ср")
                        3 -> week.add("Чт")
                        4 -> week.add("Пт")
                        5 -> week.add("Сб")
                        6 -> week.add("Нд")
                    }
                }
                workingDays.text = week.toString()
                expand.setOnClickListener {
                    if (!expanded) {
                        priceLayout.visibility = View.VISIBLE
                        expanded = true
                    } else {
                        priceLayout.visibility = View.GONE
                        expanded = false
                    }
                }
                priceForTime.text = item.getData()[i].getServices()[0].getLabel()
                pricePerTime.text = item.getData()[i].getServices()[0].getNumber().toString()
                priceForKilometer.text = item.getData()[i].getServices()[1].getLabel()
                pricePerKilometer.text = item.getData()[i].getServices()[1].getNumber().toString()
            }

        } else Log.e("Errors", "${item.getErrors()}")
    }
}