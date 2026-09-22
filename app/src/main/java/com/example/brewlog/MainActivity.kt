package com.example.brewlog

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Vincular componentes del XML con el código Kotlin
        val tvTemperatura = findViewById<TextView>(R.id.tvTemperatura)
        val tvPh = findViewById<TextView>(R.id.tvPh)
        val tvTiempo = findViewById<TextView>(R.id.tvTiempo)
        val btnSimular = findViewById<Button>(R.id.btnSimular)

        var minutosTranscurridos = 45

        // 2. Configurar la acción al presionar el botón
        btnSimular.setOnClickListener {
            // Simulación de valores aleatorios realistas de Arduino
            val tempAleatoria = Random.nextDouble(62.0, 68.0)
            val phAleatorio = Random.nextDouble(5.0, 5.6)
            minutosTranscurridos += 1

            // Formatear datos y mostrarlos en pantalla
            tvTemperatura.text = String.format("%.1f °C", tempAleatoria)
            tvPh.text = String.format("%.2f pH", phAleatorio)
            tvTiempo.text = String.format("00:%02d:00 min", minutosTranscurridos)
        }
    }
}