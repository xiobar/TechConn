package com.gkm.techconn.viewModel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.gkm.techconn.databinding.ActivityMainBinding

class SelectorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onCardViewClicked(view: View) {
        val intent = Intent(this,LoginImdisActivity::class.java)
        startActivity(intent)
    }

    fun cardClickedDimcorp(view: View) {
        val intent = Intent(this,LoginDimActivity::class.java)
        startActivity(intent)
    }
}