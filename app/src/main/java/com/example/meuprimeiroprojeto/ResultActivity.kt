package com.example.meuprimeiroprojeto

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textview_classificação)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()

        /* Tabela IMC
        Menor que 18,5      Abaixo do peso 0
        Entre 18,5 e 24,9   Normal 0
        Entre 25,0 e 29,9   Sobrepeso I
        Entre 30,0 e 39,9   Obesidade II
        Maior que 30 e 39,9 Obesidade III
         */

        var classificacao = ""
        classificacao = if (result < 18.5f) {
            "ABAIXO DO PESO"
        } else if (result >= 18.5f && result <= 24.9f ){
            "NORMAL"
        }else if (result >= 25f && result <= 29.9f ) {
            "SOBREPESO"
        }else if (result >= 30f && result <= 39.9f) {
            "OBESIDADE"
        }else {
            "OBESIDADE GRAVE"
        }

            tvClassificacao.text = getString(R.string.message_classificacao, classificacao)
        }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }




    }
