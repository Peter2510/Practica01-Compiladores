package com.peter.practica01.manejoerrores;

import java.util.ArrayList;

public class ManejoError {

    public static ArrayList<String[][]> errores = new ArrayList<String[][]>();

    public ManejoError(){

    }

    public void agregarError(String lexema, String linea, String columna, String tipo, String info){

        String[][] dato = new String [2][6];

        dato[0][0] = lexema;
        dato[0][1] = linea;
        dato[0][2] = columna;
        dato[0][3] = tipo;
        dato[0][4] = info;

        errores.add(dato);
    }

    public ArrayList obtenerError(){

        return errores;
    }

    public void limpiarErrores(){
        errores.clear();
    }


}
