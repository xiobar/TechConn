package com.gkm.techconn.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gkm.techconn.R
import com.gkm.techconn.databinding.ItemListOrdenesBinding
import com.gkm.techconn.modelo.ordenesDatos

class ordenesViewHolder(view:View):RecyclerView.ViewHolder(view){

    val binding = ItemListOrdenesBinding.bind(view)

    fun render(ordenesDatosModel: ordenesDatos){
        binding.txtOrdCliente.text = ordenesDatosModel.nameCliente
        binding.txtOrdCodigo.text = ordenesDatosModel.nroOrden
        binding.txtOrdFecha.text = ordenesDatosModel.fecha
        binding.txtOrdTotal.text = ordenesDatosModel.total
        binding.txtOrdStatus.text = ordenesDatosModel.estado
    }

}