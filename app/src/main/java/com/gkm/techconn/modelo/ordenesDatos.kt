package com.gkm.techconn.modelo

data class ordenesDatos(
    val nameCliente: String,
    val nroOrden: String,
    val fecha: String,
    val total: String,
    val estado: String
)

data class productosDatos(
    val descripcion: String,
    val codigo: String,
    val marca: String,
    val empaque: String,
    val stock: String,
    val indice: String,
    val precio: String,
    val imagen:String
)