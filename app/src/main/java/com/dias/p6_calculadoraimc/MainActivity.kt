package com.dias.p6_calculadoraimc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var btnCalcular: Button
    private lateinit var editPeso: EditText
    private lateinit var editAltura: EditText
    private lateinit var btnCalcularAgua: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main))
        { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnCalcular = findViewById(R.id.btn_calcular)
        editPeso = findViewById(R.id.edit_peso)
        editAltura = findViewById(R.id.edit_altura)
        btnCalcularAgua = findViewById(R.id.btn_calcular_agua)

        //Abrir nova tela
        btnCalcular.setOnClickListener {
            val intent = Intent(this, ResultadoActivity::class.java)

            val peso = editPeso.text.toString()
            val altura = editAltura.text.toString()

            if (peso.isNotEmpty() && altura.isNotEmpty()){
                //convertendo o que era toString para toDouble
                intent.putExtra("peso", peso.toDouble())
                intent.putExtra("altura", altura.toDouble())
            }

            startActivity(intent)
        }

        //Abrir nova tela Agua
        btnCalcularAgua.setOnClickListener {
            val intent = Intent(this, ResultadoAguaActivity::class.java)

            val peso = editPeso.text.toString()

            if(peso.isNotEmpty()) {
                intent.putExtra("peso", peso.toDouble())
            }

            startActivity(intent)
        }

    }
}