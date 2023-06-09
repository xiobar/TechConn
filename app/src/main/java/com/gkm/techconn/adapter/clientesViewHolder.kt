package com.gkm.techconn.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.gkm.techconn.databinding.ItemListClienteBinding
import com.gkm.techconn.modelo.clientesDatos

class clientesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemListClienteBinding.bind(view)

    fun render(clientesDatosModel: clientesDatos) {
        binding.txtCliName.text = clientesDatosModel.nameCliCliente
        binding.txtCliCodigo.text = clientesDatosModel.codigoCli
        binding.txtCliDireccion.text = clientesDatosModel.direccionCli
        binding.txtCliCategoria.text = clientesDatosModel.categoriaCli
        binding.txtCliCiudad.text = clientesDatosModel.ciudad
        binding.txtCliCupo.text = clientesDatosModel.cupoCli
        binding.txtCliDeuda.text = clientesDatosModel.deudaCli
    }
}