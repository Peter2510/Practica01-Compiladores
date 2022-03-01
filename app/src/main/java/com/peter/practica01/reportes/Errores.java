package com.peter.practica01.reportes;

import android.graphics.Color;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.peter.practica01.R;
import com.peter.practica01.manejoerrores.ManejoError;


import java.util.ArrayList;


public class Errores extends AppCompatActivity {
    private TableLayout tabla1,tabla2,tabla3;
    private String[]headerErrores={"Lexema","Linea","Columna","Tipo","Descripcion"};
    private ArrayList<String[][]> errors=new ArrayList<String[][]>();
    private TextView txtmostrar;
    private TextView txt2;
    private TextView txt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reportes);

        txt2 =(TextView) findViewById(R.id.txt1);
        tabla1=(TableLayout) findViewById(R.id.txt2);
        txtmostrar=(TextView) findViewById(R.id.txt3);
        tabla3=(TableLayout) findViewById(R.id.tablaReporteErrores);
        txt3=(TextView) findViewById(R.id.txtError);
        tabla2=(TableLayout) findViewById(R.id.tablaGeneral);

        TablaDinamica mostarError=new TablaDinamica(tabla3,getApplicationContext());
        if(ManejoError.errores.size() ==0){
            System.out.println("hola");
        }else{
            mostarError.addHeader(headerErrores);
            mostarError.addData(getErrores());
            mostarError.disenio(Color.WHITE);
            txt3.setVisibility(View.GONE);
            tabla1.setVisibility(View.GONE);
            tabla2.setVisibility(View.GONE);
            mostarError.colorDato2(Color.WHITE,Color.WHITE);
            mostarError.linea(Color.BLACK);
            mostarError.colorHead(Color.BLACK);
            mostarError.colorData(Color.BLACK);
            txtmostrar.setVisibility(View.GONE);
        }
        ManejoError n = new ManejoError();
        n.limpiarErrores();
    }

    private ArrayList<String[][]> getErrores(){
        for (int i=0;i<ManejoError.errores.size();i++){
            errors.add(ManejoError.errores.get(i));
        }
        return errors;
    }
}
