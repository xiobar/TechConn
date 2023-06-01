package com.gkm.techconn.viewModel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gkm.techconn.databinding.ActivityLoginDimBinding

class LoginDimActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginDimBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginDimBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogindim.setOnClickListener {
            val usuario = binding.txtLoginUsuario.text.toString()
            val password = binding.txtLoginPassword.text.toString()

            if (verificadorUsuario(usuario, password)) {
                Toast.makeText(this, "Usuario Correcto", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Usuario incorrecto", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun verificadorUsuario(usuario: String, password: String): Boolean {
        val user = "DARIO"
        val pass = "12345"
        return user == usuario && pass == password
    }
}