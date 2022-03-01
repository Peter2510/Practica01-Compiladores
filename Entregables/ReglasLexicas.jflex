/*primer seccion: codigo de usuario*/

package com.peter.practica01.leerarchivo;
import java_cup.runtime.*;
import com.peter.practica01.manejoerrores.ManejoError;
import static com.peter.practica01.manejoerrores.ManejoError.errores;


%%

/*segunda seccion: configuracion*/

%class Lexico
%unicode
%public
%line
%cup
%column
%state COMENTARIO 


WhiteSpace = [\r|\n|\r\n] | [ \t\f] | [\n]
definicion = (def|Def)
barras = "Barras"
pie = "Pie"
titulo = "titulo"
ejeX = "ejex"
ejeY = "ejey"
etiquetas = "etiquetas"
valores = "valores"
unir = "unir"
porcentaje= "Porcentaje"
cantidad  = "Cantidad"
tipo = "tipo"
total = "total"
extra = "extra"
ejecutar = "Ejecutar"
corcheteAbierto = "["
corcheteCerrado = "]"
llaveAbierta = "{"
llaveCerrada = "}"
parentesisAbierto = "("
parentesisCerrado = ")"
letra = [a-zA-Z]
entero = [0-9]+
comillaDoble = \"


/* texto = (({letra})+({entero})*({letra})*|({letra})*({entero})*({letra})+|(({letra})))+ */
/* texto = (({letra})+({entero})*|{entero}{letra}({entero})*)+ */

simbolo = ("!"|"="|"$"|"%"|"&"|"?"|"¡"|"_"|">"|"<"|"¿"|".")+

cadenas = (({letra})({entero})* | {letra}{entero}({letra})* | {entero}({letra})+({entero})*)+

texto = (({cadenas})({simbolo})* | {cadenas}{simbolo}({cadenas})* | {simbolo}({cadenas})+({simbolo})*| {entero}{simbolo}({entero})* | {simbolo}({entero})+({simbolo})*)+




decimal = ({entero})+(".")({entero})+
dosPuntos = ":"
puntoComa = ";"
coma = ","
mas = "+"
menos = "-"
multiplicacion = "*"
division = "/"




%{

    ManejoError error = new ManejoError(); 


%}


%eof{
    
    System.out.println("Termino la lectura");
    if(error.obtenerError().size()>0){
        for(int i = 0; i<error.obtenerError().size();i++){
          System.out.println((String) errores.get(i)[0][0]);
          System.out.println((String) errores.get(i)[0][1]);
          System.out.println((String) errores.get(i)[0][2]);
          System.out.println((String) errores.get(i)[0][3]);
          System.out.println((String) errores.get(i)[0][4]);

        }
    }else{
      System.out.println("Sin errores");
    }
    
%eof}

%%


/*tercer seccion: reglase lexicas*/

<YYINITIAL> {corcheteCerrado}    {return new Symbol(sym.CORCHETECERRADO,yyline+1,yycolumn+1,new String(yytext()));}    

<YYINITIAL> {corcheteAbierto}    {return new Symbol(sym.CORCHETEABIERTO,yyline+1,yycolumn+1,new String(yytext()));}    

<YYINITIAL> {WhiteSpace}    {/* se ignora */}

<YYINITIAL> {definicion}    { return new Symbol(sym.DEF,yyline+1,yycolumn+1,new String(yytext()));}    

<YYINITIAL> {porcentaje}    { return new Symbol(sym.PORCENTAJE,yyline+1,yycolumn+1,new String(yytext()));}    

<YYINITIAL> {cantidad}    { return new Symbol(sym.CANTIDAD,yyline+1,yycolumn+1,new String(yytext()));}        

<YYINITIAL> {llaveAbierta} {return new Symbol(sym.LLAVEABIERTA,yyline+1,yycolumn+1,new String(yytext()));}    

<YYINITIAL> {llaveCerrada} {return new Symbol(sym.LLAVECERRADA,yyline+1,yycolumn+1,new String(yytext()));}    

<YYINITIAL> {barras} {return new Symbol(sym.BARRAS,yyline+1,yycolumn+1,new String(yytext()));}    

<YYINITIAL> {decimal} {return new Symbol(sym.DECIMAL,yyline+1,yycolumn+1,new Double(yytext()));}

<YYINITIAL> {pie} {return new Symbol(sym.PIE,yyline+1,yycolumn+1,new String(yytext()));}    

<YYINITIAL> {titulo} {return new Symbol(sym.TITULO,yyline+1,yycolumn+1,new String(yytext()));}    

<YYINITIAL> {ejeX} {return new Symbol(sym.EJEX,yyline+1,yycolumn+1,new String(yytext()));}    

<YYINITIAL> {ejeY} {return new Symbol(sym.EJEY,yyline+1,yycolumn+1,new String(yytext()));}    

<YYINITIAL> {etiquetas} {return new Symbol(sym.ETIQUETAS,yyline+1,yycolumn+1,new String(yytext()));}    

<YYINITIAL> {valores} {return new Symbol(sym.VALORES,yyline+1,yycolumn+1,new String(yytext()));}    

<YYINITIAL> {unir} {return new Symbol(sym.UNIR,yyline+1,yycolumn+1,new String(yytext()));}    

<YYINITIAL> {tipo} {return new Symbol(sym.TIPO,yyline+1,yycolumn+1,new String(yytext()));}    

<YYINITIAL> {total} {return new Symbol(sym.TOTAL,yyline+1,yycolumn+1,new String(yytext()));}    

<YYINITIAL> {extra} {return new Symbol(sym.EXTRA,yyline+1,yycolumn+1,new String(yytext()));}    

<YYINITIAL> {ejecutar} {return new Symbol(sym.EJECUTAR,yyline+1,yycolumn+1,new String(yytext()));}    

<YYINITIAL> {dosPuntos} {return new Symbol(sym.DOSPUNTOS,yyline+1,yycolumn+1,new String(yytext()));}    

<YYINITIAL> {puntoComa} {return new Symbol(sym.PUNTOCOMA,yyline+1,yycolumn+1,new String(yytext()));}    

<YYINITIAL> {coma} {return new Symbol(sym.COMA,yyline+1,yycolumn+1,new String(yytext()));}    

<YYINITIAL> {comillaDoble} {return new Symbol(sym.COMILLADOBLE,yyline+1,yycolumn+1,new String(yytext()));}      

<YYINITIAL> {mas} {return new Symbol(sym.MAS,yyline+1,yycolumn+1,new String(yytext()));}    

<YYINITIAL> {menos} {return new Symbol(sym.MENOS,yyline+1,yycolumn+1,new String(yytext()));}    

<YYINITIAL> {multiplicacion} {return new Symbol(sym.MULTIPLICACION,yyline+1,yycolumn+1,new String(yytext()));}    

<YYINITIAL> {division} {return new Symbol(sym.DIVISION,yyline+1,yycolumn+1,new String(yytext()));}    

<YYINITIAL> {parentesisAbierto} {return new Symbol(sym.PARENTESISABIERTO,yyline+1,yycolumn+1,new String(yytext()));}    

<YYINITIAL> {parentesisCerrado} {return new Symbol(sym.PARENTESISCERRADO,yyline+1,yycolumn+1,new String(yytext()));}    

<YYINITIAL> {entero} {return new Symbol(sym.ENTERO,yyline+1,yycolumn+1,new Integer(yytext()));}

<YYINITIAL> "#" {yybegin(COMENTARIO);
                 System.out.println("----Ingrese a un comentario---");
                 }

<COMENTARIO> [^\n] {
                  
                   }


<COMENTARIO> [\n] {
                    yybegin(YYINITIAL);
                    System.out.println("---sali del comenteario---");;
                   }
<YYINITIAL> {texto} {return new Symbol(sym.TEXTO,yyline+1,yycolumn+1,new String(yytext()));}

<YYINITIAL> {simbolo} {return new Symbol(sym.SIMBOLO,yyline+1,yycolumn+1,new String(yytext()));}

[^]             {       
                        error.agregarError(yytext(),yyline+1+"",yycolumn+1+"","Lexico","El simbolo no existe en el lenguaje");
                        return new Symbol(sym.P_ERROR,yyline+1,yycolumn+1,new String(yytext())); 
                        
                }