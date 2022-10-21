package com.santino.simstock.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.santino.simstock.R
import com.santino.simstock.data.models.Company

class HomeAdapter(
    private val dataSet: List<Company>
) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvCompanyName: TextView

        init {
            tvCompanyName = view.findViewById(R.id.companyName)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_company, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvCompanyName.text = dataSet[position].compName
    }

    override fun getItemCount(): Int = dataSet.size
}