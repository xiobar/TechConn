package com.gkm.techconn.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.gkm.techconn.adapter.ordenesAdapter
import com.gkm.techconn.databinding.FragmentOrdenBinding
import com.gkm.techconn.datos.ordenesInfomracion
import com.gkm.techconn.modelo.ordenesDatos

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class OrdenFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentOrdenBinding
    private lateinit var adapter: ordenesAdapter
    private var ordenesMuteableList: MutableList<ordenesDatos> =
        ordenesInfomracion.ordenList.toMutableList()

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
        binding = FragmentOrdenBinding.inflate(inflater, container, false)
        return binding.root//inflater.inflate(R.layout.fragment_orden, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fragmentSearch.addTextChangedListener { clientFilter ->
            val ordenFiltrado = ordenesMuteableList.filter { ordenes ->
                ordenes.nameCliente.lowercase().contains(clientFilter.toString().lowercase())
            }
            adapter.updateOrdenes(ordenFiltrado)
        }
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val manager = LinearLayoutManager(requireContext())
        binding.recyclerOrdenes.layoutManager = manager
        binding.recyclerOrdenes.adapter = ordenesAdapter(ordenesInfomracion.ordenList)


    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            OrdenFragment()
                .apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}