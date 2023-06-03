package com.gkm.techconn.ui.view

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
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
        val fm:FragmentManager= supportFragmentManager
        val ft:FragmentTransaction=fm.beginTransaction()
        when (item.itemId){
            R.id.nav_item_inicio -> ft.replace(R.id.content,InicioFragment()).commit()
            R.id.nav_item_ordenes -> ft.replace(R.id.content,OrdenFragment()).commit()
            R.id.nav_item_nuevo -> ft.replace(R.id.content,CrearOrdenFragment()).commit()
            R.id.nav_item_cliente -> ft.replace(R.id.content,ClientesFragment()).commit()
            R.id.nav_item_producto -> ft.replace(R.id.content,ProductosFragment()).commit()
            R.id.nav_item_staPed -> ft.replace(R.id.content,EstatusFragment()).commit()
            R.id.nav_item_fact -> ft.replace(R.id.content,FacturasFragment()).commit()
            R.id.nav_item_mapa -> ft.replace(R.id.content,MapasFragment()).commit()
            R.id.nav_item_deuda -> ft.replace(R.id.content,DeudaFragment()).commit()
            R.id.nav_item_settings -> ft.replace(R.id.content,OpcionesFragment()).commit()
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