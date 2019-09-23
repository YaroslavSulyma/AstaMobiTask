package com.example.astamobitask.ui.carrierFragment.carrierRecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.astamobitask.R

class CarriersAdapter(private val carrierList: ArrayList<Worker>) :
    RecyclerView.Adapter<CarriersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarriersViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.carriers_item, parent, false)
        return CarriersViewHolder(view)

    }

    override fun getItemCount(): Int {
        return carrierList.size
    }

    override fun onBindViewHolder(holder: CarriersViewHolder, position: Int) {
        holder.onBind(carrierList[position])
    }

    fun update(response: List<Worker>) {
        carrierList.clear()
        carrierList.addAll(response)
        notifyDataSetChanged()
    }

}