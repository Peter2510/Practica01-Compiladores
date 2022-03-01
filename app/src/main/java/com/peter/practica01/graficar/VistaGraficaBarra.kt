package com.peter.practica01.graficar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anychart.AnyChart
import com.anychart.AnyChartView
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry


import com.peter.practica01.R
import com.peter.practica01.leerarchivo.Datos


class VistaGraficaBarra : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    crearGrafica()

    }



    fun crearGrafica(){

        var datos:Datos = Datos()

        setContentView(R.layout.grafica_barras)
        var barra : AnyChartView?=null
        barra=findViewById(R.id.Barra)

        /* Se crea la grafica barras */
        val grafica = AnyChart.column()

        /* Se agregan los valores */

        val data : MutableList<DataEntry> = mutableListOf()
        var s = 0;



            var etiqueta = ""+ Datos.ejex[Datos.arrayUniones[0][0][0]] + ""
            var valor = Datos.ejey[Datos.arrayUniones[0][0][1]]

        println("/*/**/*/*/Etiqueta en la posiconi 0 " + etiqueta)
        println("*/*/*/*/*/valor en la posicoin 0 " + valor)



        data.add(ValueDataEntry("Joses",25))
        data.add(ValueDataEntry("Marias",2))

        /* se agrega el titulo a la grafica */

        var titulo =  " " +datos.titulo.get(0) + " "

        grafica.title(titulo)

        /* se agregan los datos a la grafica*/
        grafica.data(data)

        /* se agrega la grafica a la vista */
        barra.setChart(grafica)



    }

}