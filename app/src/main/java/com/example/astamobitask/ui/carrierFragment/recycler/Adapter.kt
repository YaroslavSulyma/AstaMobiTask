package com.example.astamobitask.ui.carrierFragment.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.astamobitask.R

class Adapter(private val carrierList: ArrayList<Data>) :
    RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.carriers_item, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return carrierList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(carrierList[position])
    }

    fun update(response: List<Data>) {
        carrierList.clear()
        carrierList.addAll(response)
        notifyDataSetChanged()
    }

}