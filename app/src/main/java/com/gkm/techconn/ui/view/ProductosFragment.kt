package com.gkm.techconn.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.gkm.techconn.adapter.productoAdapter
import com.gkm.techconn.databinding.FragmentProductosBinding
import com.gkm.techconn.datos.productosInformacion
import com.gkm.techconn.modelo.productosDatos

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ProductosFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentProductosBinding
    private lateinit var adapter: productoAdapter
    private var productoMutableList : MutableList<productosDatos> =
        productosInformacion.productoList.toMutableList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentProductosBinding.inflate(inflater, container, false)

        return binding.root//inflater.inflate(R.layout.fragment_productos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.searchPro.addTextChangedListener{productFilter ->
            val productoFiltrado = productoMutableList.filter { producto ->
                producto.descripcion.lowercase().contains(productFilter.toString().lowercase())
            }

            adapter.updateProductos(productoFiltrado)
        }

        initRecyclerView()
    }

    private fun initRecyclerView(){
        adapter = productoAdapter(productoMutableList, this)
        val manager = LinearLayoutManager(requireContext())
        binding.recyclerProducto.layoutManager = manager
        binding.recyclerProducto.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProductosFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}