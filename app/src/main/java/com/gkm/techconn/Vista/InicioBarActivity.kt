package com.gkm.techconn.Vista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gkm.techconn.databinding.ActivityInicioBarBinding

class InicioBarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInicioBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInicioBarBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}