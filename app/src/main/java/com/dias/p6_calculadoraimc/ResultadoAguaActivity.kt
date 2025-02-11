package com.dias.p6_calculadoraimc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultadoAguaActivity : AppCompatActivity() {

    private lateinit var textResultadoAgua: TextView
    private lateinit var textPeso: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado_agua)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textResultadoAgua = findViewById(R.id.text_resultado_agua)
        textPeso = findViewById(R.id.text_peso)

        var bundleAgua = intent.extras
        if(bundleAgua != null){
            val peso = bundleAgua.getDouble("peso")

            textPeso.text = "Peso informado $peso kg"

            val resultado = 35 * peso

            textResultadoAgua.text = "Tome $resultado litros de água por dia"
        }
    }
}