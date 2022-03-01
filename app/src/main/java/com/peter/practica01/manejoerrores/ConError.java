package com.peter.practica01.manejoerrores;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.peter.practica01.R;

public class ConError extends AppCompatActivity {


    ManejoError error = new ManejoError();

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.grafica_barras);
        setContentView(R.layout.errores);

        Button btnErrores = findViewById(R.id.btnErrores);


        /* LLENANDO LA TABLA  */



        btnErrores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                setContentView(R.layout.errores_lexicos_sintacticos);



                error.limpiarErrores();
            }
        });




        System.out.println("*-/*/*/*/ entro a la clase ejecutar grafica */*/**");
            //gra2();

    }

    public  void llenarDatos(){
        setContentView(R.layout.errores);
        TableLayout contenidoError;
        contenidoError = findViewById(R.id.contenidoErrores);
        setContentView(R.layout.tabla_errores);
        for(int i = 0; i<error.obtenerError().size();i++){

            View registro = LayoutInflater.from(this).inflate(R.layout.item_table_layout_pg, null, false);
            TextView lexema = registro.findViewById(R.id.lexema);
            TextView linea = registro.findViewById(R.id.fila);
            TextView columna = registro.findViewById(R.id.columna);
            TextView tipo = registro.findViewById(R.id.tipo);
            TextView info = registro.findViewById(R.id.info);

            lexema.setText(ManejoError.errores.get(i)[0][0]);
            linea.setText(ManejoError.errores.get(i)[0][1]);
            columna.setText(ManejoError.errores.get(i)[0][2]);
            tipo.setText(ManejoError.errores.get(i)[0][3]);
            info.setText(ManejoError.errores.get(i)[0][4]);

            contenidoError.addView(registro);
        }
    }
//

}
