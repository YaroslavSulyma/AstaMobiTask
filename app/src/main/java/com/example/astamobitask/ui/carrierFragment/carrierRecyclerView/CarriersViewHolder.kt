package com.example.astamobitask.ui.carrierFragment.carrierRecyclerView

import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.astamobitask.R
import com.squareup.picasso.Picasso

class CarriersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val showMore = itemView.findViewById(R.id.show_more) as View
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

    fun onBind(item: Data) {
        name.text = item.getName()
        Picasso.get().load(item.getAvatar()).into(avatar)
        ratingPunctuality.text = item.getRatingPunctuality().toString()
        ratingSpeed.text = item.getRatingSpeed().toString()
        punctualityRating.rating = item.getRatingPunctuality().toFloat()
        accuracyRating.rating = item.getRatingSpeed().toFloat()
        completedOrders.text = item.getOrders()
        workSchedule.text = item.getWorkSchedule().getTime()
        val week: MutableList<String> = arrayListOf()
        for (k in item.getWorkSchedule().getDayOfWeek().indices) {
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
                showMore.animate().rotation(180F)
                priceLayout.visibility = View.VISIBLE
                expanded = true
            } else {
                showMore.animate().rotation(0F)
                priceLayout.visibility = View.GONE
                expanded = false
            }
        }
        priceForTime.text = item.getServices()[0].getLabel()
        pricePerTime.text = item.getServices()[0].getNumber().toString()
        priceForKilometer.text = item.getServices()[1].getLabel()
        pricePerKilometer.text = item.getServices()[1].getNumber().toString()
    }
}