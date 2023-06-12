package com.gkm.techconn.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.gkm.techconn.adapter.clienteAdapter
import com.gkm.techconn.databinding.FragmentClientesBinding
import com.gkm.techconn.datos.clientesInformacion
import com.gkm.techconn.modelo.clientesDatos


class ClientesFragment : Fragment() {

    private lateinit var binding:FragmentClientesBinding
    private lateinit var adapter: clienteAdapter
    private var clientesMutableList: MutableList<clientesDatos> =
        clientesInformacion.clienteList.toMutableList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentClientesBinding.inflate(inflater,container,false)
        return binding.root //inflater.inflate(R.layout.fragment_clientes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.searchCli.addTextChangedListener{clienteFilter ->
            val clienteFiltrado = clientesMutableList.filter { clientes ->
                clientes.nameCliCliente.lowercase().contains(clienteFilter.toString().lowercase())
            }
            adapter.updateClientes(clienteFiltrado)
        }
        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter = clienteAdapter(clientesMutableList)
        val manager = LinearLayoutManager(requireContext())
        binding.recyclerCliente.layoutManager = manager
        binding.recyclerCliente.adapter = adapter
    }

    companion object {

    }
}