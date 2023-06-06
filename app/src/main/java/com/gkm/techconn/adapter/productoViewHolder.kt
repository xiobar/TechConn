package com.gkm.techconn.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.gkm.techconn.databinding.ItemListProductoBinding
import com.gkm.techconn.modelo.productosDatos

class productoViewHolder(view:View):RecyclerView.ViewHolder(view) {
    val binding = ItemListProductoBinding.bind(view)

    fun render(productoDatosModel:productosDatos){
        binding.txtProDescr.text = productoDatosModel.descripcion
        binding.txtProCodigo.text = productoDatosModel.codigo
        binding.txtProMarca.text = productoDatosModel.marca
        binding.txtProEmpaque.text = productoDatosModel.empaque
        binding.txtProStock.text = productoDatosModel.stock
        binding.txtProIndice.text = productoDatosModel.indice
        binding.txtProPrecio.text = productoDatosModel.precio
    }
}