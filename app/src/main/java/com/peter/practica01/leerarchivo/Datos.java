package com.peter.practica01.leerarchivo;

import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Datos {

    public static ArrayList titulo = new ArrayList();
    public static ArrayList ejex = new ArrayList();
    public static ArrayList ejey = new ArrayList();
    private static int contador=0;
    private static int contadorBarras=0;
    public static ArrayList<int[][]> arrayUniones = new ArrayList<int[][]>();

    public void Datos(){

    }

    public void addTitulo(String cadena){
        titulo.add(cadena);
    }

    public void addEjex(String cadena){
        ejex.add(cadena);
    }

    public void addEjey(double numero){

        ejey.add(numero);
    }

    public void unir(int VEjex, int VEjey){
        /*
        if(VEjex<ejex.size()&&VEjey<ejey.size()){
           return "Se unen: " + ejex.get(VEjex) + " con " + ejey.get(VEjey) ;
        }else{
            return "Error en la union";
        } */

            try {
                //if(VEjex<ejex.size()&&VEjey<ejey.size()){
                int[][] uniones = new int [2][2];

                uniones[0][0] = VEjex;
                uniones[0][1] = VEjey;

                arrayUniones.add(uniones);

                //System.out.println("******Union x " + ejex.get(arrayUniones.get(contador)[0][0]) + " Union y " + ejey.get(arrayUniones.get(contador)[0][1]));

                //System.out.println( "x " + arrayUniones.get(contador)[0][0] +" y "+arrayUniones.get(contador)[0][1]  );

                //System.out.println("Tamaño del arrya list: "  + arrayUniones.size());
                contador++;
                //}else{
                //  System.out.println("vlines");
                //}


            }catch (Exception d){
                System.out.println("Error");
            }
    }


    public ArrayList getUniones(){
        return arrayUniones;
    }


    public ArrayList getTitulo() {
        return titulo;
    }

    public ArrayList getEjex() {
        return ejex;
    }

    public ArrayList getEjey() {
        return ejey;
    }


    public void LimpiarArrays(){
        titulo.clear();
        ejex.clear();
        ejey.clear();
        arrayUniones.clear();
        contadorBarras=0;
    }

    public int obtenerContador(){
        return contadorBarras;
    }

    public void cambiarContador(){
        contadorBarras++;
    }

    public void ceroContador(){
        contadorBarras=0;
    }

}
