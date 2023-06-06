package com.gkm.techconn.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.gkm.techconn.databinding.ItemListProductoBinding
import com.gkm.techconn.modelo.productosDatos
import com.gkm.techconn.ui.view.FullScreenImageFragment
import com.squareup.picasso.Picasso

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

        Picasso.get()
            .load(productoDatosModel.imagen)
            .into(binding.imgProView)

        binding.imgProView.setOnClickListener {
            val imagenUrl = productoDatosModel.imagen

            val fullScreenImageFragment = FullScreenImageFragment.newInstance(imagenUrl)
            val fragmentManager = binding.root.context.packageManager
            val transaccion = fragmentManager.begin
        }
    }
}