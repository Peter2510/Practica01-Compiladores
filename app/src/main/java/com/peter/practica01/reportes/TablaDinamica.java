package com.peter.practica01.reportes;

import android.content.Context;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


import java.util.ArrayList;

public class TablaDinamica {
    private TableLayout tabla;

    private String[]header;
    private ArrayList<String[][]>data;
    private TableRow fila;
    private TextView columna;
    private int finalIn;
    private int colorF;
    private Context contextApp;
    private int index00;
    private boolean initC=false;
    private int ColorIni;

    public TablaDinamica(TableLayout tabla,Context context){
        this.tabla=tabla;
        this.contextApp=context;
    }
    private TableRow.LayoutParams datosOb(){
        TableRow.LayoutParams dat=new TableRow.LayoutParams();
        dat.setMargins(1,1,1,1);
        dat.weight=1;
        return dat;
    }
    public void addHeader(String[]header){
        this.header=header;
        crearHeader();
    }
    public void addData(ArrayList<String[][]>data){
        this.data=data;
        crearDatos();
    }

    private TableRow getFila1(int index){
        return (TableRow) tabla.getChildAt(index);

    }
    public void newFila(){
        fila=new TableRow(contextApp);
    }
    private void nuevaColumn(){
        columna=new TextView(contextApp);
        columna.setGravity(Gravity.CENTER);
        columna.setTextSize(18);

    }
    private void crearHeader(){
        finalIn=0;
        newFila();
        while (index00<header.length){
            nuevaColumn();
            columna.setText(header[index00++]);
            fila.addView(columna,datosOb());
        }
        tabla.addView(fila);
    }
    public void colorDato2(int color1,int color2){
        for (finalIn=1;finalIn<=data.size();finalIn++){
            initC=!initC;//cambio de true a false y viceversa
            for (index00=0;index00<=header.length;index00++){
                columna=getColumn(finalIn,index00);
                columna.setBackgroundColor((initC)?color1:color2);
            }
        }
        this.colorF=color1;
        this.ColorIni=color2;
    }
    private void crearDatos(){
        String info;

        for (finalIn=1;finalIn<=data.size();finalIn++){
            newFila();
            for (index00=0;index00<=header.length;index00++){
                nuevaColumn();
                String[][] filas=data.get(finalIn-1);
                info=(index00<filas.length)?filas[index00][index00]:"";
                columna.setText(info);
                fila.addView(columna,datosOb());
            }
            tabla.addView(fila);
        }
    }
    private TextView getColumn(int in1,int in2){
        fila=getFila1(in1);
        return (TextView) fila.getChildAt(in2);

    }
    public void disenio(int color){
        index00=0;
        while (index00<header.length){
            columna=getColumn(0,index00++);
            columna.setBackgroundColor(color);
        }
    }
    public void linea(int color){
        finalIn=0;
        while(finalIn<=data.size()){
            getFila1(finalIn++).setBackgroundColor(color);
        }
    }
    public void colorData(int color){
        for (finalIn=1;finalIn<= data.size();finalIn++){
            for (index00=0;index00<= header.length;index00++){
                getColumn(finalIn,index00).setTextColor(color);
            }
        }
    }
    public void colorHead(int color){
        index00=0;
        while(index00< header.length){
            getColumn(0,index00++).setTextColor(color);
        }
    }

}
