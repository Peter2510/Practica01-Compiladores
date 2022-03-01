package com.peter.practica01.leerarchivo


import java.io.Reader
import java.io.StringReader

class Llamada {

    private var texto =" "

    /*public fun Llamada1(datos:String){

        texto = datos

        val lectura: Reader = StringReader(texto)

        val lexer = Lexico(lectura)

        try {
            val con = lexer.yylex()
            while (con != Lexico.YYEOF) {
                lexer.yylex()
            }
        } catch (ex: IOException) {
            println("Se encontro error")
        }
    } */


    public fun Analisis(datos:String){

        texto = datos

        val lectura: Reader = StringReader(texto)

        val parteLexica = Lexico(lectura)
        val sintacticoParser = Sintactico(parteLexica)
        try {
            sintacticoParser.parse()

        } catch (e: Exception) {
            e.printStackTrace()

        }
    }


}
