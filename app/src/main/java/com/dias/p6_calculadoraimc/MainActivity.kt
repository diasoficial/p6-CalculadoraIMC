package com.dias.p6_calculadoraimc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var btnCalcular: Button
    private lateinit var editPeso: EditText
    private lateinit var editAltura: EditText
    private lateinit var btnCalcularAgua: Button
    private lateinit var editSexo: EditText
    private lateinit var btnCalcularTmb: Button
    private lateinit var editIdade: EditText


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
        editSexo = findViewById(R.id.edit_mf)
        btnCalcularTmb = findViewById(R.id.btn_calcular_tmb)
        editIdade = findViewById(R.id.edit_idade)

        //Abrir nova tela
        btnCalcular.setOnClickListener {
            val intent = Intent(this, ImcActivity::class.java)

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
            val intent = Intent(this, AguaActivity::class.java)

            val peso = editPeso.text.toString()

            if(peso.isNotEmpty()) {
                intent.putExtra("peso", peso.toDouble())
            }

            startActivity(intent)
        }

        //Abrir nova tela TMB
        btnCalcularTmb.setOnClickListener {
            val intent = Intent(this, TbmActivity::class.java)

            val sexo = editSexo.text.toString()
            val peso = editPeso.text.toString()
            val altura = editAltura.text.toString()
            val idade = editIdade.text.toString()

            if (peso.isNotEmpty() && altura.isNotEmpty() && sexo.isNotEmpty() && idade.isNotEmpty()){
                intent.putExtra("peso", peso.toDouble())
                intent.putExtra("altura", altura.toDouble())
                intent.putExtra("idade", idade.toDouble())
                intent.putExtra("sexo", sexo)
            }

            startActivity(intent)
        }

    }
}