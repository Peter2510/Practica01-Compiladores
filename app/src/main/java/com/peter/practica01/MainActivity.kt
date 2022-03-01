package com.peter.practica01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.peter.practica01.Inicial.PantallaOpciones

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnIniciar = findViewById<Button>(R.id.btnIniciar)

        btnIniciar.setOnClickListener {
            Log.d("Iniciando","Boton iniciar")
            val intent:Intent = Intent(this,PantallaOpciones::class.java)
            startActivity(intent)
        }





    }
}