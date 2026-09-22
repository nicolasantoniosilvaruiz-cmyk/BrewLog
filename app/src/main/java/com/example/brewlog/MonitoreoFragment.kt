package com.example.brewlog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlin.random.Random

class MonitoreoFragment : Fragment() {

    private var minutosTranscurridos = 45

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla el diseño fragment_monitoreo.xml
        return inflater.inflate(R.layout.fragment_monitoreo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Vincular componentes usando la vista 'view' recibida
        val tvTemperatura = view.findViewById<TextView>(R.id.tvTemperatura)
        val tvPh = view.findViewById<TextView>(R.id.tvPh)
        val tvTiempo = view.findViewById<TextView>(R.id.tvTiempo)
        val btnSimular = view.findViewById<Button>(R.id.btnSimular)

        // 2. Evento del botón de simulación
        btnSimular.setOnClickListener {
            val tempAleatoria = Random.nextDouble(62.0, 68.0)
            val phAleatorio = Random.nextDouble(5.0, 5.6)
            minutosTranscurridos += 1

            tvTemperatura.text = String.format("%.1f °C", tempAleatoria)
            tvPh.text = String.format("%.2f pH", phAleatorio)
            tvTiempo.text = String.format("00:%02d:00 min", minutosTranscurridos)
        }
    }
}