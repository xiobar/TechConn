package com.gkm.techconn.ui.view

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentManager
import com.gkm.techconn.R
import com.gkm.techconn.databinding.ActivityInicioBarBinding
import com.google.android.material.navigation.NavigationView

class InicioBarActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityInicioBarBinding
    private lateinit var drawer:DrawerLayout
    private lateinit var toogle:ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInicioBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar:androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawer = binding.drawInicioBar

        toogle = ActionBarDrawerToggle(this,drawer,toolbar,R.string.nav_draw_open, R.string.nav_draw_close)
        drawer.addDrawerListener(toogle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView:NavigationView = binding.navView
        navigationView.setNavigationItemSelectedListener (this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        FragmentManager fm = getSupportFragmentManager()
        when (item.itemId){
            R.id.nav_item_ordenes -> Toast.makeText(this,"Ordenes",Toast.LENGTH_SHORT).show()
            R.id.nav_item_nuevo -> Toast.makeText(this,"Nueva orden",Toast.LENGTH_SHORT).show()
            R.id.nav_item_cliente -> Toast.makeText(this,"Clientes",Toast.LENGTH_SHORT).show()
            R.id.nav_item_producto -> Toast.makeText(this,"Producto",Toast.LENGTH_SHORT).show()
            R.id.nav_item_staPed -> Toast.makeText(this,"Status del pedido",Toast.LENGTH_SHORT).show()
            R.id.nav_item_fact -> Toast.makeText(this,"Factura",Toast.LENGTH_SHORT).show()
            R.id.nav_item_mapa -> Toast.makeText(this,"Mapa",Toast.LENGTH_SHORT).show()
            R.id.nav_item_deuda -> Toast.makeText(this,"Deudas por cobrar",Toast.LENGTH_SHORT).show()
            R.id.nav_item_settings -> Toast.makeText(this,"Opciones",Toast.LENGTH_SHORT).show()
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toogle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toogle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toogle.onOptionsItemSelected(item))
            return true
        return super.onOptionsItemSelected(item)
    }
}