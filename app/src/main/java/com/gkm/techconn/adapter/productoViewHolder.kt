package com.gkm.techconn.adapter

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.gkm.techconn.R
import com.gkm.techconn.databinding.ItemListProductoBinding
import com.gkm.techconn.modelo.productosDatos
import com.gkm.techconn.ui.view.FullScreenImageFragment

class productoViewHolder(view:View, private val fragment: Fragment):RecyclerView.ViewHolder(view) {
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
            val imageUrl:String = productoDatosModel.imagen
            val fragmentManager: FragmentManager = fragment.childFragmentManager
            val fullScreenImageFragment:FullScreenImageFragment = FullScreenImageFragment.newInstance(imageUrl)
            fragmentManager.beginTransaction()
                .replace(R.id.img_full_screen, fullScreenImageFragment)
                .addToBackStack(null)
                .commit()
        }
    }
}