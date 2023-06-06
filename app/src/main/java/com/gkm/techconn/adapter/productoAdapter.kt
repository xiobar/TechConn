package com.gkm.techconn.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gkm.techconn.R
import com.gkm.techconn.modelo.productosDatos

class productoAdapter(
    private var productoList:List<productosDatos>)
    :RecyclerView.Adapter<productoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): productoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return productoViewHolder(layoutInflater.inflate(R.layout.item_list_producto, parent, false))
    }

    override fun getItemCount(): Int = productoList.size

    override fun onBindViewHolder(holder: productoViewHolder, position: Int) {
        val item = productoList[position]
        holder.render(item)
    }

    fun updateProductos(productoList: List<productosDatos>){
        this.productoList = productoList
        notifyDataSetChanged()
    }
}