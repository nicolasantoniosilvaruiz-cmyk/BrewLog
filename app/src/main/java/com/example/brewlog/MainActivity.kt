package com.example.brewlog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Cargar por defecto el fragment de Inicio
        replaceFragment(InicioFragment())

        // Escuchar clics en la barra de navegación
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_inicio -> replaceFragment(InicioFragment())
                R.id.nav_monitoreo -> replaceFragment(MonitoreoFragment())
                R.id.nav_recetas -> replaceFragment(RecetasFragment())
                R.id.nav_config -> replaceFragment(ConfigFragment())
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}