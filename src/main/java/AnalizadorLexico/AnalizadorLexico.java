/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalizadorLexico;

import AnalizadorSintactico.AnalisisSintactico;
import AnalizadorSintactico.AnalizadorSintactico;
import Vista.InterfazGrafica;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class AnalizadorLexico {
    int estadoActual;
    String palabra="";
    String tokenFinal="";
    int posicion =0;
    int matrizTransiciones[][] = new int[14][14];
    int estadosFinalizacion[] = new int[45];
    String descripcionFinalizacion[] = new String[45];
    int numLinea;
    int errores[]=new int[2];
    String mensaje="S";
    String descripcion="";
    String resultadoObtenido="";
    AnalizadorSintactico sint = new AnalizadorSintactico();
    AnalisisSintactico sintaxis = new AnalisisSintactico();
    
    /* public static void main(String args[]) {
    AnalizadorLexico analizadorTokens = new AnalizadorLexico();
    analizadorTokens.iniciarAnalizador("holaaaaa_7 ", 0);
    }*/
    
    
    public AnalizadorLexico() {
    //entrada=this.areaEntrada;
    /*  Scanner teclado = new Scanner(System.in);
    iniciarVariables();
    
    
    System.out.println("Ingrese la palabra: ");
    palabra = teclado.nextLine();
    while (posicion < palabra.length()) {
    getToken();
    }*/
    }
    // public void iniciarAnalizador(String entrada, int numLine) {
    public void iniciarAnalizador(String entrada, int numLine){
        //Scanner teclado = new Scanner(System.in);
        iniciarVariables();


        //System.out.println("Ingrese la palabra: ");
        //palabra = teclado.nextLine();
        this.numLinea=numLine;
        this.palabra=entrada;
        while (posicion < palabra.length()) {
          //System.out.println(getToken());
          sintaxis.enviarToken(getToken(), tokenFinal,numLinea,posicion,descripcion);
        }
    }
     public String getResultadoObtenido() {
        return this.resultadoObtenido;
    }
    public void setResultadoObtenido(String resultadoObtenido) {
        this.resultadoObtenido = resultadoObtenido;
    }

    
    public void iniciarVariables(){
         /*
            0-->letra; 1--> número; 2-->punto
            3--> operador; 4-->puntuación 
            5--> agrupacion
            7--> guinBajo
            8--> signo menos
            matrizTransiciones[NumEstado][caracter]
            resultado=1 --> aceptación; 
            9 --> palabras reservadas
            10--> apertura comillas
            11 --> cierre comillas
            12 --> signo divicion
            13 --> comentario 
            14 --> signo igual (=)
         */
         mensaje="S";
         posicion=0;
         resultadoObtenido="";
         //analizador de identificador
         matrizTransiciones[0][7]=1;
         matrizTransiciones[0][0]=1;
         matrizTransiciones[1][7]=1;
         matrizTransiciones[1][0]=1;
         matrizTransiciones[1][1]=1;
         //analizador numeros enteros y decimales, negativos o positivos
        matrizTransiciones[0][8] = 8; //estado 8 donde va el signo menos 
        matrizTransiciones[8][1] = 3;
        matrizTransiciones[0][1] = 3;
        matrizTransiciones[3][1] = 3;
        matrizTransiciones[3][2] = 4;
        matrizTransiciones[4][1] = 5;
        matrizTransiciones[5][1] = 5;
        //análisis token operadores
        matrizTransiciones[0][3] = 2;
        matrizTransiciones[2][3] = 2;
        //matrizTransiciones[12][3]=2;
        //análisis token puntuación
        matrizTransiciones[0][4] = 6;
        matrizTransiciones[6][4] = 6;
        matrizTransiciones[0][2] = 6;
        matrizTransiciones[6][2] = 6;

        //análisis token agrupación
        matrizTransiciones[0][5] = 7;
        matrizTransiciones[7][5] = 7;
        
        // análisis de los literales
        matrizTransiciones[0][10]=10;
        matrizTransiciones[10][0]=10;
        matrizTransiciones[10][1]=10;
        matrizTransiciones[10][2]=10;
        matrizTransiciones[10][3]=10;
        matrizTransiciones[10][4]=10;
        matrizTransiciones[10][5]=10;
        matrizTransiciones[10][7]=10;
        matrizTransiciones[10][8]=10;
        matrizTransiciones[10][10]=11;
        matrizTransiciones[10][12]=10;
        
        //Comentarios
        matrizTransiciones[0][12]=12;
        matrizTransiciones[12][12]=13;
        matrizTransiciones[13][0]=13;
        matrizTransiciones[13][1]=13;
        matrizTransiciones[13][2]=13;
        matrizTransiciones[13][3]=13;
        matrizTransiciones[13][4]=13;
        matrizTransiciones[13][5]=13;
        matrizTransiciones[13][7]=13;
        matrizTransiciones[13][8]=13;
        matrizTransiciones[13][10]=13;
        matrizTransiciones[13][12]=13;

        //analisis de errores:
        matrizTransiciones[1][2] = -2;
        matrizTransiciones[2][4] = -3;
        matrizTransiciones[2][0] = -31;
        matrizTransiciones[2][2] = -3;
        matrizTransiciones[2][5] = -4;
        matrizTransiciones[1][3] = -5;
        matrizTransiciones[1][4] = -6;
        matrizTransiciones[1][5] = -7;

        matrizTransiciones[3][0] = -8;
        matrizTransiciones[3][3] = -9;
        matrizTransiciones[3][4] = -10;
        matrizTransiciones[3][5] = -11;

        matrizTransiciones[4][0] = -12;
        matrizTransiciones[4][2] = -13;
        matrizTransiciones[4][3] = -14;
        matrizTransiciones[4][4] = -15;
        matrizTransiciones[4][5] = -16;

        matrizTransiciones[5][0] = -17;
        matrizTransiciones[5][2] = -18;
        matrizTransiciones[5][3] = -19;
        matrizTransiciones[5][4] = -20;
        matrizTransiciones[5][5] = -21;

        matrizTransiciones[6][0] = -22;
        matrizTransiciones[6][1] = -23;
        matrizTransiciones[6][3] = -24;
        matrizTransiciones[6][5] = -25;

        matrizTransiciones[7][0] = -26;
        matrizTransiciones[7][1] = -27;
        matrizTransiciones[7][2] = -28;
        matrizTransiciones[7][3] = -29;
        matrizTransiciones[7][4] = -30;
        
        matrizTransiciones[8][0] = -33;
        matrizTransiciones[8][2] = -33;
        matrizTransiciones[8][3] = 2;
        matrizTransiciones[8][4] = -33;
        matrizTransiciones[8][5] = -33;
        matrizTransiciones[8][7] = -33;
        matrizTransiciones[8][10] = -33;
        matrizTransiciones[8][12] = -33;
        matrizTransiciones[8][8] = 2;
        matrizTransiciones[1][8]=-33;
        matrizTransiciones[2][8]=-33;
        matrizTransiciones[4][8]=-33;
        matrizTransiciones[5][8]=-33;
        
        matrizTransiciones[12][3]= 2;
        matrizTransiciones[12][0]=-34;
        matrizTransiciones[12][1]=-34;
        matrizTransiciones[12][2]=-34;
        matrizTransiciones[12][4]=-34;
        matrizTransiciones[12][5]=-34;
        matrizTransiciones[12][7]=-34;
        matrizTransiciones[12][8]=2;
        matrizTransiciones[12][10]=-34;
        matrizTransiciones[3][12]=-5;
        matrizTransiciones[1][12]=-5;
        matrizTransiciones[6][12]=-3;
        matrizTransiciones[7][12]=-4;
        matrizTransiciones[4][12]=-14;

        
        //descripciones:
        //palabras reservadas
        estadosFinalizacion[38]=9;
        descripcionFinalizacion[38]="Palabra Reservada";
        //signo igual a (=)
        estadosFinalizacion[43]=14;
        descripcionFinalizacion[43]="Signo igual";
        //tabulacion
        estadosFinalizacion[44]=15;
        descripcionFinalizacion[44]="Tab";
        //identificador
        estadosFinalizacion[0] = 1;
        descripcionFinalizacion[0] = "identificador(id)";
        //numero entero:
        estadosFinalizacion[1] = 3;
        descripcionFinalizacion[1] = "Numero entero";
        //numero decimal:
        estadosFinalizacion[2] = 5;
        descripcionFinalizacion[2] = "Numero decimal";
        //operadores
        estadosFinalizacion[3] = 2;
        descripcionFinalizacion[3] = "Signos de Operación";
        //puntuación
        estadosFinalizacion[4] = 6;
        descripcionFinalizacion[4] = "Signos de puntuación";
        //agrupacion
        estadosFinalizacion[5] = 7;
        descripcionFinalizacion[5] = "Signos de agrupación";
        //literales:
        estadosFinalizacion[40]=11;
        descripcionFinalizacion[40]="Literal";
        //comentarios
        estadosFinalizacion[41]=13;
        descripcionFinalizacion[41]="Comentario";
        //errores:
        estadosFinalizacion[6] = -2;
        descripcionFinalizacion[6] = "#Error, el punto no es válido";

        estadosFinalizacion[7] = -3;
        descripcionFinalizacion[7] = "#Error, los grupos de operación y puntuación están juntos.";

        estadosFinalizacion[8] = -4;
        descripcionFinalizacion[8] = "#Error, los grupos de operación y agrupación están juntos.";

        estadosFinalizacion[9] = -5;
        descripcionFinalizacion[9] = "#Error, numero-letra está agrupada con un signo de operación";

        estadosFinalizacion[10] = -6;
        descripcionFinalizacion[10] = "#Error, numero-letra está agrupada con signo de puntuación";

        estadosFinalizacion[11] = -7;
        descripcionFinalizacion[11] = "#Error, numero-letra está agrupada con signo de agrupación";

        estadosFinalizacion[12] = -8;
        descripcionFinalizacion[12] = "#Error, La letras están combinadas con números";

        estadosFinalizacion[13] = -9;
        descripcionFinalizacion[13] = "#Error, numeros y operador estan juntos";

        estadosFinalizacion[14] = -10;
        descripcionFinalizacion[14] = "#Error, numeros y signos de puntuacion están juntos";

        estadosFinalizacion[15] = -11;
        descripcionFinalizacion[15] = "#Error, numeros y signos de agrupación están juntos";

        estadosFinalizacion[16] = -12;
        descripcionFinalizacion[16] = "#Error, letra después del punto('.')";

        estadosFinalizacion[17] = -13;
        descripcionFinalizacion[17] = "#Error, dos puntos juntos.";

        estadosFinalizacion[18] = -14;
        descripcionFinalizacion[18] = "#Error, Operador después del punto";

        estadosFinalizacion[19] = -15;
        descripcionFinalizacion[19] = "#Error, signo de puntuación después del punto";

        estadosFinalizacion[20] = -16;
        descripcionFinalizacion[20] = "#Error, signo de agrupación después del punto";

        estadosFinalizacion[21] = -17;
        descripcionFinalizacion[21] = "#Error, Letra después del número";

        estadosFinalizacion[22] = -18;
        descripcionFinalizacion[22] = "#Error, dos puntos en un mismo token de números";

        estadosFinalizacion[23] = -19;
        descripcionFinalizacion[23] = "#Error, operador después del decimal";

        estadosFinalizacion[24] = -20;
        descripcionFinalizacion[24] = "#Error, signo de puntuación después del decimal";

        estadosFinalizacion[25] = -21;
        descripcionFinalizacion[25] = "#Error, signo de agrupación después del decimal";

        estadosFinalizacion[26] = -22;
        descripcionFinalizacion[26] = "#Error, letra después del signo de puntuación";

        estadosFinalizacion[27] = -23;
        descripcionFinalizacion[27] = "#Error, número después del signo de puntuación";

        estadosFinalizacion[28] = -24;
        descripcionFinalizacion[28] = "#Error, operador despúes del signo de puntuación";

        estadosFinalizacion[29] = -25;
        descripcionFinalizacion[29] = "#Error, signo de agrupación después del signo de puntuación";

        estadosFinalizacion[30] = -26;
        descripcionFinalizacion[30] = "#Error, letra después del signo de agrupación";

        estadosFinalizacion[31] = -27;
        descripcionFinalizacion[31] = "#Error, número después del signo de agrupación";

        estadosFinalizacion[32] = -28;
        descripcionFinalizacion[32] = "#Error, punto después del signo de agrupación";

        estadosFinalizacion[33] = -29;
        descripcionFinalizacion[33] = "#Error, operador después del signo de agrupación";

        estadosFinalizacion[34] = -30;
        descripcionFinalizacion[34] = "#Error, signo de puntuación después de signo de agrupación";
        
        estadosFinalizacion[35]=-31;
        descripcionFinalizacion[35]="#Error, letra después del signo de agrupación";
        
        estadosFinalizacion[36]=-32;
        descripcionFinalizacion[36]="#Error, el caracter es inválido";
        
        estadosFinalizacion[39]=-33;
        descripcionFinalizacion[39]="#Error, caracteres invalidos despues o antes del signo menos";
        
        estadosFinalizacion[37]=4;
        descripcionFinalizacion[37]="#Error, no se completaron caracteres despúes del punto";
        
        estadosFinalizacion[42]=-34;
        descripcionFinalizacion[42]="#Error, caracteres inapropiados despues del signo /";
    }
    
     public int getSiguienteEstado(int estadoActual, int caracter) {
        int resultado = -1;
        if (estadoActual >= 0 && caracter <= 13) {
            try {
                resultado = matrizTransiciones[estadoActual][caracter];
                if(resultado<0){
                    errores[0]=posicion+1;
                }
                
                
            } catch (ArrayIndexOutOfBoundsException e) {
                resultado = -32;
                 errores[0]=posicion+1;
            }
        }else if(estadoActual<-1){
            resultado=estadoActual;
        }
        return resultado;
    }
       public int getIntCaracter(char caracter) {
        int resultado = -1;
        if (Character.isDigit(caracter)) {
            resultado = 1;
        } else if ((caracter >= 'a' && caracter <= 'z') || (caracter >= 'A' && caracter <= 'Z')) {
            resultado = 0;
        } else if (caracter == '.') {
            resultado = 2;
        } else if (caracter == '+' || caracter == '*' || caracter == '%' || caracter=='>' || caracter=='<' || caracter=='=') {
            resultado = 3;
        } else if (caracter == '.' || caracter == ',' || caracter == ';' || caracter == ':' || String.valueOf(caracter).equals("'")) {
            resultado = 4;
        } else if (caracter == '(' || caracter == ')' || caracter == '[' || caracter == ']' || caracter == '{' || caracter == '}') {
            resultado = 5;
        } else if(caracter == '-'){
            resultado = 8;
        } else if(caracter == '_'){
            resultado = 7;
        }else if(caracter=='"'){
            resultado=10;
        }else if(caracter== '/'){
            resultado=12;
        }

        return resultado;
    }
    public String getEstadoAceptacion(int i) {
        String res = "S";
        int indice = 0;
        for (int estadoAceptacion : estadosFinalizacion) {
            if (estadoAceptacion == i) {
                res = descripcionFinalizacion[indice];
            }
            /*if(estadoAceptacion==4){
            errores[0]=posicion;
            }*/
            indice++;
        }
        return res;
    }
    public int getToken() {
        estadoActual = 0;
        boolean seguirLeyendo = true;
        char tmp;
        String token = "";

        while ((seguirLeyendo) && (posicion < palabra.length())) {
            if (Character.isSpaceChar(tmp = palabra.charAt(posicion))|| String.valueOf(tmp).equals("\t") || String.valueOf(tmp).equals("\n")) {
                if(estadoActual!=10 && estadoActual!=13){
                    seguirLeyendo=false;
                }else{
                    seguirLeyendo=true;
                    token+=tmp;
                }
               
            } else {
                // para mi automata
                int estadoTemporal = getSiguienteEstado(estadoActual, getIntCaracter(tmp));
                //System.out.println("Estado actual " + estadoActual + " caracter "+ tmp + " transicion a "+estadoTemporal);
                token+=tmp;
                estadoActual = estadoTemporal;

              //System.out.println(tmp);
            }
            posicion++;
        }
        verificarToken(token);
        try{
            char caracter1;
            if(getEstadoAceptacion(estadoActual).equals(null)||getEstadoAceptacion(estadoActual).equals("S")){
            } else {
                //System.out.println("*********Termino en el estado "+ getEstadoAceptacion(estadoActual) + " token actual : "+token);
                caracter1=getEstadoAceptacion(estadoActual).charAt(0);
                if(caracter1=='#'){
                    /* char primerCaracter=mensaje.charAt(0);
                    if(primerCaracter=='('){
                    mensaje = mensaje + "\n" + "(" + getEstadoAceptacion(estadoActual) + "; en la línea: " + numLinea + "; en la columna: " + errores[0]+ "); token: " + token;
                    }else{*/
                        mensaje="(" + getEstadoAceptacion(estadoActual) + "; en la línea: " + numLinea + "; en la columna: " + errores[0]+ "); token: " + token + "\n";
                        InterfazGrafica.limpiarTablaTokens();
                    
                }else{
                    /*  if(mensaje.equals("S")||mensaje.equals("//No hay errores")){
                    mensaje="//No hay errores";
                    }else{
                    }*/  
                    mensaje=getEstadoAceptacion(estadoActual);
                    Object ror[]={token,getEstadoAceptacion(estadoActual),numLinea,posicion-1};
                    InterfazGrafica.agregarReporteToken(ror);
                }
                descripcion=mensaje;
                setResultadoObtenido(getResultadoObtenido()+"\n"+enviarToken(estadoActual,token));
                tokenFinal=evaluarLexema(token);
                //System.out.println(enviarToken(estadoActual,token));
                //sint.enviarToken(enviarToken(estadoActual,token), token,numLinea,posicion);
                //System.out.println("terminó el analixadorSintactico");
               //System.out.print(getEstadoAceptacion(estadoActual) + ", ");
            }
        }catch(NullPointerException e){
            
        } 
        // verificar el estado de aceptación
        
       // System.out.println(enviarToken(estadoActual,token));
        return enviarToken(estadoActual,token);

    }
    public void verificarToken(String token){
       if(token.equals("FIN")|| token.equals("ESCRIBIR")||token.equals("REPETIR")||token.equals("INICIAR")||token.equals("SI")||token.equals("VERDADERO")
               ||token.equals("FALSO")||token.equals("ENTONCES")){
           estadoActual=9;
       }else if(token.equals("=")){
           estadoActual=14;
       }
    }
    public int enviarToken(int estadoActual, String palabra){
        String token="!";
        int numToken=-4000;
        switch(estadoActual){
            case 1: 
                //token = "i";
                numToken=1;
                break;
            case 2:
                switch(palabra){
                    case "+":
                       // token="+";
                        numToken=11;                        
                        break;
                    case "*":
                        //token="*";
                        numToken=12;
                        break;
                    default :
                        //token="O"; //O --> OPERACION
                        break;
                }
                break;
            case 3:
               // token="n";
                if(palabra.charAt(0)=='-'){
                    numToken=16;
                }else{
                    numToken=2;
                }
                break;
            case 5:
              //  token="n";
                break;
            case 7:
                switch (palabra) {
                    case "(":
                       // token="(";
                        numToken=13;
                        break;
                    case ")":
                       // token=")";
                        numToken=14;
                        break;
                    default:
                       // token="G"; //AGRUPACION
                        break;
                }
                break;
            case 9:
                if(palabra.equals("INICIAR")){
                   // token="3";
                   numToken=3;
                }else if(palabra.equals("FIN")){
                    //token="4";
                    numToken=4;
                }else if(palabra.equals("ESCRIBIR")){
                    //token="5";
                    numToken=5;
                }else if(palabra.equals("ENTONCES")){
                    //token="6";
                    numToken=6;
                }else if(palabra.equals("FALSO")){
                    //token="7";
                    numToken=7;
                }else if(palabra.equals("VERDADERO")){
                    //token="8";
                    numToken=8;
                }else if(palabra.equals("REPETIR")){
                    //token="9";
                    numToken=9;
                }else if(palabra.equals("SI")){
                    //token="0";
                    numToken=10;
                }
                
                break;
            case 11:
                //token = "L";
                numToken=0;
                break;
            case 13:
                //token = "Cm";
                numToken=17;
                break;
            case 14: 
                //token="=";
                numToken=15;
                break;
                
            default:
                token="!";
                break;
        }
        if(estadoActual<0){
            numToken=estadoActual;
        }else if(palabra.equals("\t")){
            numToken=18;
        }
        return numToken;
    }
    public String evaluarLexema(String token){
        String tokenFinal="";
        if(estadoActual==11){
            for(int i=1;i<token.length()-1;i++){
                tokenFinal += token.charAt(i);
            }
        }else{
            tokenFinal=token;
        }
        return tokenFinal;
    }
}
