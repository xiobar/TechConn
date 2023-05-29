package com.gkm.techconn.Vista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gkm.techconn.R
import com.gkm.techconn.databinding.ActivityMainBinding

class SelectorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}