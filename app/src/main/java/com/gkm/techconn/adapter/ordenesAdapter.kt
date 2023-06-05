package com.gkm.techconn.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gkm.techconn.R
import com.gkm.techconn.modelo.ordenesDatos

class ordenesAdapter(
    private var ordenesList:List<ordenesDatos>)
    : RecyclerView.Adapter<ordenesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ordenesViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        return ordenesViewHolder(layoutInflater.inflate(R.layout.item_list_ordenes, parent, false))
    }

    override fun getItemCount(): Int = ordenesList.size

    override fun onBindViewHolder(holder: ordenesViewHolder, position: Int) {
        val item = ordenesList[position]
        holder.render(item)
    }

    fun updateOrdenes(ordenesList: List<ordenesDatos>){
        this.ordenesList = ordenesList
        notifyDataSetChanged()
    }
}