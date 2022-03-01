package com.peter.practica01.Inicial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.peter.practica01.R
import com.peter.practica01.graficar.mostrarArchivo


class PantallaOpciones : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_opciones)

        val btnGrafi = findViewById<Button>(R.id.bntGraficar)

        btnGrafi.setOnClickListener{
            Log.d("Graficar","boton select archivo")
            val intent:Intent = Intent(this,mostrarArchivo::class.java)
            startActivity(intent)
        }
    }
}