package com.gkm.techconn.Vista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.gkm.techconn.databinding.ActivityInicioBarBinding
import com.google.android.material.navigation.NavigationView

class InicioBarActivity : AppCompatActivity()/*, NavigationView.OnNavigationItemSelectedListener*/ {

    private lateinit var drawer:DrawerLayout
    private lateinit var toogle:ActionBarDrawerToggle
    private lateinit var binding: ActivityInicioBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInicioBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}