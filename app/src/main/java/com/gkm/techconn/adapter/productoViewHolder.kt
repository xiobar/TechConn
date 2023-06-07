package com.gkm.techconn.adapter

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.gkm.techconn.R
import com.gkm.techconn.databinding.ItemListProductoBinding
import com.gkm.techconn.modelo.productosDatos
import com.gkm.techconn.ui.view.FullScreenImageFragment
import com.squareup.picasso.Picasso

class productoViewHolder(view:View):RecyclerView.ViewHolder(view) {
    private val binding = ItemListProductoBinding.bind(view)

    fun render(productoDatosModel:productosDatos){
        binding.txtProDescr.text = productoDatosModel.descripcion
        binding.txtProCodigo.text = productoDatosModel.codigo
        binding.txtProMarca.text = productoDatosModel.marca
        binding.txtProEmpaque.text = productoDatosModel.empaque
        binding.txtProStock.text = productoDatosModel.stock
        binding.txtProIndice.text = productoDatosModel.indice
        binding.txtProPrecio.text = productoDatosModel.precio

        binding.imgProView.setOnClickListener{
            val fullImage = FullScreenImageFragment.newInstance(productoDatosModel.imagen)

            val manager:FragmentManager? = itemView.context?.let {
                if(it is Fragment){
                    it.childFragmentManager
                }else{
                    null
                }
            }

            manager?.beginTransaction()
                ?.replace(com.google.android.material.R.id.container, fullImage)
                ?.addToBackStack(null)
                ?.commit()
        }

    }
}