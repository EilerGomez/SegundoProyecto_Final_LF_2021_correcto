/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalizadorSintactico;

import Vista.InterfazGrafica;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class AnalisisSintactico {
    ArrayList<String> escritos;
    String arregloTokens;
    int estadoActual=0;
    int estadoTemporal=0;
    int contadorEscritos=0;
    int contadorTabulaciones=0;
    int matrizAnalisisLL1[][];
    String descrpcionErroresSintacticos[];
    int correccionDeEstados[];
    int cantidadVecesRepetir=0;
    public String resultado="";
    public String resultadoError="";
    boolean hayErrores=false;
    boolean mostrarCondicion=false;
    ManejadorErrores manejoError=new ManejadorErrores();
    int linea=0;
    int columna=0;
    
    public AnalisisSintactico(){
        inicializarVariebles();
        escritos = new ArrayList<String>();
        arregloTokens="";
        estadoActual=0;
        hayErrores=false;
        estadoTemporal=0;
        contadorEscritos=0;
        
        resultado="";
        resultadoError="";
        matrizAnalisisLL1=new int[27][17];
        descrpcionErroresSintacticos=new String[27];
        correccionDeEstados= new int[27];
        //estructura repetir
        matrizAnalisisLL1[0][9] = 1;
        matrizAnalisisLL1[1][2] = 2;
        matrizAnalisisLL1[2][3] = 3;
        matrizAnalisisLL1[3][5]=4;
        matrizAnalisisLL1[4][0]=5;
        matrizAnalisisLL1[4][16]=5;
        matrizAnalisisLL1[4][2]=5;
        matrizAnalisisLL1[5][4]=3;
        matrizAnalisisLL1[3][4]=6;
        
        //estructuraEscribir
        matrizAnalisisLL1[0][5]=7; 
        matrizAnalisisLL1[7][0]=8;
        matrizAnalisisLL1[7][16]=8;
        matrizAnalisisLL1[7][2]=8;
        matrizAnalisisLL1[8][4]=9;
        //estructura condicional
        matrizAnalisisLL1[0][10]=17;
        matrizAnalisisLL1[17][7]=18;
        matrizAnalisisLL1[17][8]=18;
        matrizAnalisisLL1[18][6]=19;
        matrizAnalisisLL1[19][5]=20;
        matrizAnalisisLL1[20][0]=21;
        matrizAnalisisLL1[21][4]=22;
        matrizAnalisisLL1[22][4]=23;
        //Asignacion
        matrizAnalisisLL1[0][1]=10;
        matrizAnalisisLL1[10][15]=11;
        matrizAnalisisLL1[11][1]=12;
        matrizAnalisisLL1[11][2]=12;
        matrizAnalisisLL1[12][4]=24;//estado de aceptacion
        matrizAnalisisLL1[12][11]=13;
        matrizAnalisisLL1[13][1]=12;
        matrizAnalisisLL1[13][2]=12;
        matrizAnalisisLL1[12][12]=16;
        matrizAnalisisLL1[16][1]=12;
        matrizAnalisisLL1[16][2]=12;
        matrizAnalisisLL1[12][13]=14;
        matrizAnalisisLL1[14][1]=15;
        matrizAnalisisLL1[14][2]=15;
        matrizAnalisisLL1[15][11]=25;
        matrizAnalisisLL1[15][12]=25;
        matrizAnalisisLL1[25][1]=26;
        matrizAnalisisLL1[25][2]=26;
        matrizAnalisisLL1[26][14]=12;
        matrizAnalisisLL1[16][13]=14;
        matrizAnalisisLL1[13][13]=14;
        matrizAnalisisLL1[11][13]=14;
        //descripcion de errores:
        descrpcionErroresSintacticos[0]="Se esperaban las posibles palabras: REPETIR, ESCRIBIR, SI o el terminal (id)";
        descrpcionErroresSintacticos[1]="Se esperaba un número entero";
        descrpcionErroresSintacticos[2]="Se esperaba la palabra reservada INICIAR";
        descrpcionErroresSintacticos[3]="Se esperban las palabras ESCRIBIR O FIN";
        descrpcionErroresSintacticos[4]="Se esperaba un token literal";
        descrpcionErroresSintacticos[5]="Se esperaba la palabra reservada FIN";
        descrpcionErroresSintacticos[7]="Se esperaba un token literal";
        descrpcionErroresSintacticos[8]="Se esperaba la palabra reservada FIN";
        descrpcionErroresSintacticos[10]="Se esperaba un signo igual a (=)";
        descrpcionErroresSintacticos[11]="Se esperaba un id o un numero";
        descrpcionErroresSintacticos[12]="Se esperaba la palabra reservada FIN o un signo +, un (, o un signo *";
        descrpcionErroresSintacticos[13]="Se esperaba un id o un numero";
        descrpcionErroresSintacticos[14]="Se esperaba un id o un numero";
        descrpcionErroresSintacticos[15]="Se esperaba un signo + o un signo *";
        descrpcionErroresSintacticos[25]="Se esperaba un id o un numero";
        descrpcionErroresSintacticos[26]="Se esperaba un cierre de parentesis)";
        descrpcionErroresSintacticos[16]="Se esperaba un id o un numero";
        descrpcionErroresSintacticos[17]="Se esperaba la palabra reservada VERDADERO o FALSO";
        descrpcionErroresSintacticos[18]="Se esperaba la palabra reservada ENTONCES";
        descrpcionErroresSintacticos[19]="Se esperaba la palabra reservada ESCRIBIR";
        descrpcionErroresSintacticos[20]="Se esperaba un literal para escribir";
        descrpcionErroresSintacticos[21]="Se esperaba la palabra reservada FIN";
        descrpcionErroresSintacticos[22]="Se esperaba la palabra reservada FIN";
        //correccionestados
        correccionDeEstados[0]=0;
        correccionDeEstados[1]=2;
        correccionDeEstados[2]=3;
        correccionDeEstados[3]=4;
        correccionDeEstados[4]=5;
        correccionDeEstados[5]=3;
        correccionDeEstados[7]=8;
        correccionDeEstados[8]=9;
        correccionDeEstados[10]=11;
        correccionDeEstados[11]=12;
        correccionDeEstados[12]=24;
        correccionDeEstados[13]=12;
        correccionDeEstados[16]=12;
        correccionDeEstados[14]=15;
        correccionDeEstados[15]=25;
        correccionDeEstados[25]=26;
        correccionDeEstados[26]=12;
        correccionDeEstados[17]=18;
        correccionDeEstados[18]=19;
        correccionDeEstados[19]=20;
        correccionDeEstados[20]=21;
        correccionDeEstados[21]=22;
        correccionDeEstados[22]=23;
        
    }
    public void inicializarVariebles(){
       estadoActual=0;
       estadoTemporal=0;
       contadorEscritos=0;
       contadorTabulaciones=0;
       cantidadVecesRepetir=0;
       mostrarCondicion=false;
       escritos = new ArrayList<String>();
    }
     public String getResultado() {
        return resultado;
    }

    public void setResultado(String resutado) {
        this.resultado = resutado;
    }
 
    public void enviarToken(int numToken, String contenido, int numLinea, int numColumna, String descripcion){
        this.linea=numLinea;
        this.columna=numColumna;
        System.out.println(numToken);
        if(numToken==-4000||numToken==17){
            System.out.println("ignorando tabulaciones y comentarios");
            if(numToken==-4000){
               
                if(estadoActual==3){
                    contadorTabulaciones=contadorTabulaciones;
                }else{
                     contadorTabulaciones++;
                }
            }
        }else if(numToken<0 && numToken != -4000){
            hayErrores=true;
            manejoError.mostrarErroresLexicosEnArea(descripcion);
            estadoActual=corregirEstadoActual();
        }
        else{
            if(numToken==0 || numToken==16){
                contadorEscritos++;
                escritos.add(contenido);
                System.out.println("agregando contenido al arraylist" + contenido);
            }else if(numToken==8){
                mostrarCondicion=true;
            }else if(numToken==7){
                mostrarCondicion=false;
            }else if(numToken==2){
                if(estadoActual==7|| estadoActual==4){
                    contadorEscritos++;
                    escritos.add(contenido);
                }else{
                    cantidadVecesRepetir=Integer.parseInt(contenido);
                }
                
            }
            if(estadoActual==9){
                cumplirCondiciones(numToken);
            }else{
                int estadoTemporal=verificarSiguienteEstado(numToken);
                estadoActual=estadoTemporal;
            }
        }
        if(hayErrores==true){
            InterfazGrafica.limpiarTablaTokens();
        }
    }
    public int verificarSiguienteEstado(int caracter){
        int resultado = -1;
        
            resultado=matrizAnalisisLL1[estadoActual][caracter];
            if(resultado>0){
                
            }else{
                resultado=-1;
            }
            System.out.println("Estado actual: " + estadoActual + ", caracter: " + caracter + "transicion A: " + resultado);     
                
        return verificarResultado(resultado);
    }
    public void cumplirCondiciones(int numToken){
        System.out.println("cumpliendo las condiciones");
        if(numToken==9){
            String salida="";
            String tabulaciones="";
            for(int i=0; i<contadorEscritos; i++){
                 System.out.println(escritos.get(i));                 
                 for(int x=0;x<escritos.get(i).length();x++){
                     salida+=escritos.get(i).charAt(x);
                 }
                 for(int j=0;j<contadorTabulaciones;j++){
                     tabulaciones=tabulaciones+"\t";
                 }
                 setResultado(getResultado() + "\n" +(tabulaciones+salida));
            } 
            InterfazGrafica.AreaSalida.setText(InterfazGrafica.AreaSalida.getText() +  getResultado());
            setResultado("");
            vaciarArrayEscritos();            
        }else if(numToken==23){
            String salida="";
            String tabulaciones="";
            if(mostrarCondicion==true){
                    for(int i=0; i<contadorEscritos; i++){
                        System.out.println(escritos.get(i));                 
                        for(int x=0;x<escritos.get(i).length();x++){
                            salida+=escritos.get(i).charAt(x);
                        }
                       
                        setResultado(getResultado() + "\n" +("\t\t"+salida));
                    }
                    InterfazGrafica.AreaSalida.setText(InterfazGrafica.AreaSalida.getText() +  getResultado());
            }else{
                
            }
            setResultado("");
            vaciarArrayEscritos();
        }else if(numToken==6){
            String salida_0="";
            String tabulaciones="";
            String salidaFinal="";
            for(int i=0; i<contadorEscritos; i++){
                 //System.out.println(escritos.get(i));                 
                 for(int x=0;x<escritos.get(i).length();x++){
                    salida_0+=escritos.get(i).charAt(x);
                 }
                 
                 System.out.println(salida_0);
                 
                 for(int j=0;j<0;j++){
                    tabulaciones=tabulaciones+"\t";
                 }
                 setResultado(getResultado() + "\n" +("\t"+salida_0));
                 salida_0="";
            } 
            //System.out.println(getResultado());
            for(int x=0; x<cantidadVecesRepetir; x++){
                salidaFinal=salidaFinal + getResultado();
            }
            InterfazGrafica.AreaSalida.setText(InterfazGrafica.AreaSalida.getText() +  salidaFinal);
            setResultado("");
            vaciarArrayEscritos();
        }else if(numToken==24){
            System.out.println("Asignacion completada");
            setResultado("");
        }
        inicializarVariebles();
    }
    public int verificarResultado(int resultado){
        int estadoFinal=-1;
        if(resultado==9&& hayErrores==false){
            cumplirCondiciones(resultado);
            estadoFinal=0;
        }else if(resultado==23 &&hayErrores==false){
            cumplirCondiciones(resultado);
            estadoFinal=0;
        }else if(resultado==6  &&hayErrores==false){
            cumplirCondiciones(resultado);
            estadoFinal=0;
        }else if(resultado==24&&hayErrores==false){
            cumplirCondiciones(resultado);
            estadoFinal=0;
        }else if((resultado==24||resultado==6||resultado==23 || resultado==9)&&hayErrores==true){
            estadoFinal=0;
        }
        else{
            estadoFinal=resultado;
        }
        if(estadoFinal==-1&&hayErrores==false){
            hayErrores=true;
            InterfazGrafica.AreaSalida.setText("");
            //que imprima errores de sintaxis
            //que borre la tabla de tokens y recuento
            estadoFinal=corregirEstadoActual();
        }else if(estadoFinal==-1&&hayErrores==true){
            hayErrores=true;
            estadoFinal=corregirEstadoActual();
        }
        return estadoFinal;
    }
    public void verificarSalida(){
        if(hayErrores==false){
            InterfazGrafica.AreaSalida.setText(InterfazGrafica.AreaSalida.getText() + getResultado());
        }
    }
    public void vaciarArrayEscritos(){
        for(int i =0; i<escritos.size();i++){
            escritos.remove(i);
        }
    }
    public int corregirEstadoActual(){
        int estadoa=correccionDeEstados[estadoActual];
        manejoError.mostrarErroresSintacticos(linea, columna,descrpcionErroresSintacticos[estadoActual]);
        return estadoa;
    }
}
