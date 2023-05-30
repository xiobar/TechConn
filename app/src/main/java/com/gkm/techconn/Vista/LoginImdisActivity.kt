package com.gkm.techconn.Vista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gkm.techconn.databinding.ActivityLoginBinding

class LoginImdisActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
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
        val user = "DAVID"
        val pass = "123456"
        return user == usuario && pass == password
    }
}