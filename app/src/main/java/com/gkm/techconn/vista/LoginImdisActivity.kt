package com.gkm.techconn.vista

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gkm.techconn.databinding.ActivityLoginBinding

class LoginImdisActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("LoginPrefs", MODE_PRIVATE)

        binding.swiImdis.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                sharedPreferences.edit().putBoolean("rememberLogin", true).apply()
            }else{
                sharedPreferences.edit().remove("rememberLogin").apply()
            }
        }

        val rememberLogin = sharedPreferences.getBoolean("rememberLogin", false)
        binding.swiImdis.isChecked = rememberLogin

        if(rememberLogin){
            val saveUsername = sharedPreferences.getString("username", "")
            val savedPassword = sharedPreferences.getString("password", "")
            binding.txtLoginUsuario.setText(saveUsername)
            binding.txtLoginPassword.setText(savedPassword)
            navergarTo()
        }

        binding.btnLogin.setOnClickListener {
            val usuario = binding.txtLoginUsuario.text.toString()
            val password = binding.txtLoginPassword.text.toString()

            if (verificadorUsuario(usuario, password)) {
                if(binding.swiImdis.isChecked){
                    sharedPreferences.edit()
                        .putString("username", usuario)
                        .putString("password", password)
                        .apply()
                }
                Toast.makeText(this, "Usuario Correcto", Toast.LENGTH_SHORT).show()
                navergarTo()
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

    private fun navergarTo(){
        val intent = Intent(this,InicioBarActivity::class.java)
        startActivity(intent)
        finish()
    }
}