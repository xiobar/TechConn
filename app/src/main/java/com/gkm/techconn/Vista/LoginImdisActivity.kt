package com.gkm.techconn.Vista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gkm.techconn.Modelo.ConeccionSqlServer
import com.gkm.techconn.databinding.ActivityLoginBinding
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

class LoginImdisActivity : AppCompatActivity() {
    val cn = ConeccionSqlServer()
    var con:Connection? = null
    var pst:PreparedStatement? = null
    var rs:ResultSet? = null

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener{
            val usuario = binding.txtLoginUsuario.text.toString()
            val password = binding.txtLoginPassword.text.toString()

            if (verificarUsuario(usuario, password)){
                Toast.makeText(this, "Acceso correcto", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Acceso denegado", Toast.LENGTH_SHORT).show()

            }
        }
    }

    private fun verificarUsuario(usuario:String, password:String):Boolean{
        var validarUsuario:Boolean = false
        val query:String ="SELECT * FROM SEG_USUARIOS WHERE Código = ? AND Password = ?"

        try {
            con = cn.establecerConeccion()
            pst = con?.prepareStatement(query)
            pst?.setString(1,usuario)
            pst?.setString(2,password)

            rs = pst?.executeQuery()
            validarUsuario = rs!!.next()
        }catch (e:Exception){
            e.printStackTrace()
        }finally {
            rs?.close()
            pst?.close()
            con?.close()
        }

        return validarUsuario

    }
}