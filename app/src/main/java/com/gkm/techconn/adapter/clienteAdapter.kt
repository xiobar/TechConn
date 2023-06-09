package com.gkm.techconn.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gkm.techconn.R
import com.gkm.techconn.modelo.clientesDatos

class clienteAdapter (
    private var clientesList:List<clientesDatos>)
    :RecyclerView.Adapter<clientesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): clientesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return clientesViewHolder(layoutInflater.inflate(R.layout.item_list_cliente,parent,false))
    }

    override fun getItemCount(): Int = clientesList.size

    override fun onBindViewHolder(holder: clientesViewHolder, position: Int) {
        val item = clientesList[position]
        holder.render(item)
    }

    fun updateClientes(clientesList: List<clientesDatos>){
        this.clientesList = clientesList
        notifyDataSetChanged()
    }
}