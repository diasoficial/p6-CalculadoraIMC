package com.dias.p6_calculadoraimc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TbmActivity : AppCompatActivity() {

    private lateinit var textResultMasc: TextView
    private lateinit var textResultFem: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tbm)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        textResultMasc = findViewById(R.id.resultado_masc)
        textResultFem = findViewById(R.id.resultado_fem)

        var bundle = intent.extras
        if (bundle != null){
            val peso = bundle.getDouble("peso")
            val altura = bundle.getDouble("altura")
            val idade = bundle.getDouble("idade")
            val sexo = bundle.getString("sexo")

            if ((sexo == "m") || (sexo == "M" )) {
                val tmb = (10 * peso) + (6.25 * altura * 100) - (5 * idade) + 5

                textResultMasc.text = "Sua TMB é de $tmb kcal por dia"
            } else if (sexo == "f" || sexo == "F") {
                val tmb = (10 * peso) + (6.25 * altura * 100) - (5 * idade) -161

                textResultFem.text = "Sua TMB é de $tmb kcal por dia"
            }
        } else {
            textResultFem.text = "Erro: Informações incompletas fornecidas."
            textResultMasc.text = "Erro: Informações incompletas fornecidas."
        }
    }
}