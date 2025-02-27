package com.dias.p6_calculadoraimc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AguaActivity : AppCompatActivity() {

    private lateinit var textResultadoAgua: TextView
    private lateinit var textPeso: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_agua)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textResultadoAgua = findViewById(R.id.text_resultado_agua)
        textPeso = findViewById(R.id.text_peso)

        var bundle = intent.extras
        if(bundle != null){
            val peso = bundle.getDouble("peso")

            textPeso.text = "Peso informado $peso kg"

            val resultado = 35 * peso / 1000
            val resultadoFormatado = String.format("%.1f", resultado)

            textResultadoAgua.text = "Tome $resultadoFormatado lítros de água por dia"
        }
    }
}