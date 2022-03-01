package com.peter.practica01.graficar;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Column;
import com.peter.practica01.R;
import com.peter.practica01.leerarchivo.Datos;
import java.util.ArrayList;



import static com.peter.practica01.leerarchivo.Datos.*;

public class EjecutarGrafica extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.grafica_barras);
        setContentView(R.layout.sin_error);

        Button btnGrafica = findViewById(R.id.grafica);
        Button btnOcurrencia = findViewById(R.id.ocurrencias);
        Button btndefinidos = findViewById(R.id.btnErrores);

        btnGrafica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gra2();
            }
        });

        btnOcurrencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btndefinidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.graficos_definidos);
                TextView txt = findViewById(R.id.cantidadBarras);
                Datos dato = new Datos();
                txt.setText("" + dato.obtenerContador());
                dato.ceroContador();
            }
        });



        System.out.println("*-/*/*/*/ entro a la clase ejecutar grafica */*/**");
            //gra2();

    }

    public void gra2() {

        try{

        Datos dato = new Datos();
        setContentView(R.layout.grafica_barras);

        AnyChartView barra = findViewById(R.id.Barra);
        Cartesian cartesian = AnyChart.column();



        /*
        String d = (String) ejex.get(arrayUniones.get(contador)[0][0]);
        double g = (Double) ejey.get(arrayUniones.get(contador)[0][0]); */


//        double doubleValue = Double.parseDouble(g);


        ArrayList data = new ArrayList();

        for (int i = 0; i < dato.getUniones().size(); i++) {
            data.add(new ValueDataEntry((String) ejex.get(arrayUniones.get(i)[0][0]), (Double) ejey.get(arrayUniones.get(i)[0][1])));

        }

        Column column = cartesian.column(data);

        cartesian.title("" + dato.getTitulo().get(0));

        barra.setChart(cartesian);
        cartesian.animation(true);

        dato.LimpiarArrays();

    }catch (IndexOutOfBoundsException e){
            System.out.println(e);
            System.out.println("ERROR EN EL EJECUTAR GRAFICAS SLAÑ");
            setContentView(R.layout.grafica_pie);

        }

    }

}
