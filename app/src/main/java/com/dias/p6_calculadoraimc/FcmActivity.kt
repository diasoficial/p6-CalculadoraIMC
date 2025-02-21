package com.dias.p6_calculadoraimc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FcmActivity : AppCompatActivity() {

    private lateinit var editFreq: EditText
    private lateinit var btnCalcularFcm: Button
    private lateinit var textResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fcm)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        editFreq = findViewById(R.id.edit_freq)
        btnCalcularFcm = findViewById(R.id.btn_calcularfcm)
        textResult = findViewById(R.id.text_resultado_fcm)

        btnCalcularFcm.setOnClickListener {
            val zona = editFreq.text.toString()

            if (zona.isNotEmpty()) {
                val zonaInt = zona.toIntOrNull()

                if (zonaInt != null) {
                    val bundle = intent.extras

                    if (bundle != null) {
                        val idade = bundle.getInt("idade") // Use um valor padrão para segurança

                        val fcm = 220 - idade
                        val resultadoFcm = fcm * (zonaInt / 100.0) // Use divisão por 100.0 para resultado em Double

                        textResult.text = String.format("%.1f bpm", resultadoFcm) // Formate o resultado com 1 casa decimal
                    }
                }
            } else {
                textResult.text = "Digite a idade e a porcentagem da frequência"
            }
        }
    }
}