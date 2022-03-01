/* primer seccion: codigo de usuario */
package analizadorLexico;

import java.util.ArrayList;

%%

/*segunda seccion: configuracion*/

%class Lexico
%unicode 
%int
%line 
%state  
%column 
%public



WhiteSpace = [\r|\n|\r\n] | [ \t\f]
entero = [0-9]
consonante = [b|c|d|f|g|h|j|k|l|m|n|ñ|p|q|r|s|t|v|w|x|y|z|B|C|D|F|G|H|J|K|L|M|N|P|Q|R|S|T|V|W|X|Y|Z]
vocal = [a|e|i|o|u|A|E|I|O|U]


unaVocal = (({consonante})*{vocal}({consonante})*)
dosVocales = (({consonante}*){vocal}({consonante}*){vocal}({consonante}*))
tresVocales = (({consonante})*{vocal}({consonante})*{vocal}({consonante})*{vocal}({consonante})*)
cuatroVocales = (({consonante})*{vocal}({consonante})*{vocal}({consonante})*{vocal}({consonante})*{vocal})
cincoVocales =  (({consonante})*{vocal}({consonante})*{vocal}({consonante})*{vocal}({consonante})*{vocal}({consonante})*{vocal}({consonante})*)

numVocalUno = (({entero}){unaVocal})|({unaVocal}{entero})
numVocalDos = (({entero}){dosVocales}{entero})|({dosVocales}{entero})
numVocalTres=  (({entero}){tresVocales}{entero})|({tresVocales}{entero})
numVocalCuatro = (({entero}){cuatroVocales}{entero})|({cuatroVocales}{entero})
numVocalCinco = (({entero}){cincoVocales}{entero})|({cincoVocales}{entero})

%{
    
    private int unaVocal=0,dosVocales=0,tresVocales=0,cuatroVocales=0,cincoVocales=0,columna=0,fila=0,cantError=0;
        private String resultado=" ";
        private ArrayList<String> infoNumeros = new ArrayList(); 

        private void infoEntero(String dato,int fila, int columna){
            
            infoNumeros.add("Numero: "+ dato +" en la fila: "+ fila+ " columna " + columna);
            
        }

        private void unaVocalNumero(){
            unaVocal++;
        }

        private void dosVocalNumero(){
            dosVocales++;
        }

        private void tresVocalNumero(){
            
            tresVocales++;
        }

        private void cuatroVocalNumero(){
            cuatroVocales++;
        }

        private void cincoVocalNumero(){
            cincoVocales++;
        }

        public ArrayList<String> getArray(){
            return infoNumeros;
        }

        private void detectarEnteros(String dato, int fila, int columna){
            char charNum='o';
            for (int i = 0; i < dato.length(); i++) {
                charNum=dato.charAt(i);

                if(Character.isDigit(charNum)){
                     infoNumeros.add("Numero: "+ charNum +" en la fila: "+ fila+ " columna " + columna);
                }

                columna+=1;            
            }
        }

        private void contarUnaVocal(){
            unaVocal++;
        }
        
        private void contarDosVocales(){
            dosVocales++;
        }

        private void contarTresVocales(){
            tresVocales++;
        }
        
        private void contarCuatroVocales(){
            cuatroVocales++;
        }

        private void contarCincoVocales(){
            cincoVocales++;
        }

        public int getContadorUna(){
            return unaVocal;
        }

        public int getContadorDos(){
            return dosVocales;
        }

        public int getContadorTres(){
            return tresVocales;
        }

        public int getContadorCuatro(){
            return cuatroVocales;
        }

        public int getContadorCinco(){
            return cincoVocales;
        }

        private void errorDetectado(){
            cantError++;
            
        }

        public int conError(){
            return cantError;
        }
        
        

%}

%eof{
    
%eof}

%%

/*tercer seccion: reglas lexicas*/

{WhiteSpace}    {/* ignoramos */}

/* Entero */

 {entero} {infoEntero(yytext(),(yyline+1),(yycolumn+1));}

/* Una vocal */

({unaVocal}) {contarUnaVocal();}

/* Dos vocales */

({dosVocales}) {contarDosVocales();}

/* Tres vocales */

({tresVocales}) {contarTresVocales();}

/* Cuatro vocales */

({cuatroVocales}) {contarCuatroVocales();}

/* Cinco vocales */

({cincoVocales}) {contarCincoVocales();}

/* Un numero y una vocal */
({numVocalUno}) {detectarEnteros(yytext(),(yyline+1),(yycolumn+1)); unaVocalNumero();}

/* Un numero y una vocal */
({numVocalDos}) {detectarEnteros(yytext(),(yyline+1),(yycolumn+1)); dosVocalNumero();}

/* Un numero y una vocal */
({numVocalTres}) {detectarEnteros(yytext(),(yyline+1),(yycolumn+1)); tresVocalNumero();}

/* Un numero y una vocal */
({numVocalCuatro}) {detectarEnteros(yytext(),(yyline+1),(yycolumn+1)); cuatroVocalNumero();}

/* Un numero y una vocal */
({numVocalCinco}) {detectarEnteros(yytext(),(yyline+1),(yycolumn+1)); cincoVocalNumero();}

[^] {errorDetectado();}
