package com.example.fimazaapp

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawerLayout)
        val navigationView = findViewById<NavigationView>(R.id.navigationView)

        // El ícono de hamburguesa que abre/cierra el drawer
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.nav_open, R.string.nav_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Carga el Fragment de Inicio por defecto
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, InicioFragment())
                .commit()
            navigationView.setCheckedItem(R.id.nav_inicio)
        }

        // Maneja los clics del menú
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_inicio -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, InicioFragment())
                        .commit()
                }
                R.id.nav_nosotros -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, NosotrosFragment())
                        .commit()
                }
                R.id.nav_contactos -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, ContactosFragment())
                        .commit()
                }
                R.id.nav_login -> {
                    val intent = android.content.Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                }
            }
            drawerLayout.closeDrawers()
            true
        }
    }
}