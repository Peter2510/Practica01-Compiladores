package com.peter.practica01.graficar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.peter.practica01.R
import com.peter.practica01.leerarchivo.Datos
import com.peter.practica01.leerarchivo.Llamada
import com.peter.practica01.manejoerrores.ConError
import com.peter.practica01.manejoerrores.ManejoError
import com.peter.practica01.reportes.Errores
import com.peter.practica01.reportes.SinError


class mostrarArchivo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_archivo)

        val ManejoError = ManejoError()
        val Datos = Datos()

        val textoIngresado = findViewById<EditText>(R.id.textoIngresado)
        val btnContinuar =  findViewById<Button>(R.id.btnContinuar)

        btnContinuar.setOnClickListener{
            if (textoIngresado.text.length<=0){
                Toast.makeText(this,"Ingresa texto para continuar",Toast.LENGTH_LONG).show()
        }else{
            Log.d("Continuar","Leido:${textoIngresado.text}")

                var llamada = Llamada()
                //llamada.Llamada1(textoIngresado.getText().toString())
                //llamada.cup(textoIngresado.getText().toString())
                llamada.Analisis(textoIngresado.getText().toString())

                println("A punto de hcaer la comparacion")
                println("tamaño array error "+ManejoError.obtenerError().size)
                if(ManejoError.obtenerError().size>0){
                    /*val pantalla2: Intent = Intent(this, ConError::class.java)
                    startActivity(pantalla2)
                    println("SE ENCONTRARON ERRORES, HOLA DESDE MOSTRAR ARCHIVOS")*/
                    val pantallaerror : Intent = Intent(this,Errores::class.java)
                    startActivity(pantallaerror)

                }else{
                    val intent: Intent = Intent(this, EjecutarGrafica::class.java)
                    startActivity(intent)
                    println("no hay error")

                }

            }
        }
    }
}