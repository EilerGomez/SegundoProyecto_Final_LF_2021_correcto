/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalizadorSintactico;

/**
 *
 * @author HP
 */
public class AnalizadorSintactico {
    String token="";
    String descripcion="";
    int estadoActual=0;
    int estadoTemporal=0;
    String pila="";
    
    public AnalizadorSintactico(){
        iniciarVariables();
    }
    String estructura="$";
    
    /*
        ID --> identificador
        NE --> numero entero
        ND --> Numero decimal
        PR --> palabra Reservada
        = --> signo igual
        ( --> apertura parentesis
        ) ---> cierre parentesis
        L --> Literal
    */
    
    String TablaAnalisisLL1 [][]= new String[10][16];

    public String getEstructura() {
        return estructura;
    }

    public void setEstructura(String estructura) {
        this.estructura = estructura;
    }
    public String getPila(){
        return pila;
    }
    public void setPila(String pila){
        this.pila=pila;
    }
    
    
    /*public void setToken(String token, String descripcion){
    //System.out.println(token);
    setEstructura(getEstructura() + "-" + token);
    System.out.println(getEstructura());
    }*/
    public void iniciarVariables(){
        //tabla de analisis LL1
        token="";
        pila="";
        TablaAnalisisLL1[0][1]="AS";
        TablaAnalisisLL1[0][3]="CECS";
        TablaAnalisisLL1[0][4]="CECS";
        TablaAnalisisLL1[0][5]="CECS";
        TablaAnalisisLL1[0][6]="CECS";
        TablaAnalisisLL1[0][7]="CECS";
        TablaAnalisisLL1[0][8]="CECS";
        TablaAnalisisLL1[0][9]="CECS";
        TablaAnalisisLL1[0][10]="CECS";
        TablaAnalisisLL1[0][15]="e";
        TablaAnalisisLL1[1][0]="e"; // e == epsilone
        TablaAnalisisLL1[1][1]="e";
        TablaAnalisisLL1[1][2]="e";
        TablaAnalisisLL1[1][3]="PC";
        TablaAnalisisLL1[1][4]="PC";
        TablaAnalisisLL1[1][5]="PC";
        TablaAnalisisLL1[1][6]="PC";
        TablaAnalisisLL1[1][7]="PC";
        TablaAnalisisLL1[1][8]="PC";
        TablaAnalisisLL1[1][9]="PC";
        TablaAnalisisLL1[1][10]="PC";
        TablaAnalisisLL1[1][15]="e";
        TablaAnalisisLL1[2][0]="L";
        TablaAnalisisLL1[2][1]="i";
        TablaAnalisisLL1[2][2]="n";
        TablaAnalisisLL1[3][3]="3"; //INICIAR
        TablaAnalisisLL1[3][4]="4";//FIN
        TablaAnalisisLL1[3][5]="5";//ESCRIBIR
        TablaAnalisisLL1[3][6]="6";//ENTONCES
        TablaAnalisisLL1[3][7]="7";//FALSO
        TablaAnalisisLL1[3][8]="8";//VERDADERO
        TablaAnalisisLL1[3][9]="9";//REPETIR
        TablaAnalisisLL1[3][10]="0";//SI
        TablaAnalisisLL1[4][1]="i=RP";
        TablaAnalisisLL1[5][0]="TM";
        TablaAnalisisLL1[5][1]="Tm";
        TablaAnalisisLL1[5][2]="TM";
        TablaAnalisisLL1[6][1]="FQ";
        TablaAnalisisLL1[6][2]="FQ";
        TablaAnalisisLL1[6][13]="FQ";
        TablaAnalisisLL1[7][3]="e";
        TablaAnalisisLL1[7][4]="e";
        TablaAnalisisLL1[7][5]="e";
        TablaAnalisisLL1[7][6]="e";
        TablaAnalisisLL1[7][7]="e";
        TablaAnalisisLL1[7][8]="e";
        TablaAnalisisLL1[7][9]="e";
        TablaAnalisisLL1[7][10]="e";
        TablaAnalisisLL1[7][11]="+TM";
        TablaAnalisisLL1[7][14]="e";
        TablaAnalisisLL1[8][3]="e";
        TablaAnalisisLL1[8][4]="e";
        TablaAnalisisLL1[8][5]="e";
        TablaAnalisisLL1[8][6]="e";
        TablaAnalisisLL1[8][7]="e";
        TablaAnalisisLL1[8][8]="e";
        TablaAnalisisLL1[8][9]="e";
        TablaAnalisisLL1[8][10]="e";
        TablaAnalisisLL1[8][11]="e";
        TablaAnalisisLL1[8][12]="*FQ";
        TablaAnalisisLL1[8][14]="e";
        TablaAnalisisLL1[9][1]="i";
        TablaAnalisisLL1[9][2]="n";
        TablaAnalisisLL1[9][13]="(R)";         
    }
    public void enviarToken(String token, String descripcion,int linea,int columna){
        boolean sugerirToken=false;
        int salir=0;
        if(!token.equals("Cm")){
            verificarPila(token);
            while(salir==0){
                try{ 
                    if(pop(getEstado(pila.charAt(pila.length()-1)),getNumToken(token),token)==true){
                        System.out.println(pila.charAt(pila.length()-1)+"  Aqui va x1");
                        reduce();
                        salir=1;
                    }else{
                        insertarAPila(shift(getEstado(pila.charAt(pila.length()-1)),getNumToken(token)));
                        System.out.println("insertando Inicio");
                        System.out.println(shift(getEstado(pila.charAt(pila.length()-1)),getNumToken(token)));
                        System.out.println("insertando Fin");
                    }
                    if(pila.equals("")){
                        System.out.println("Pila vacía");
                    }
                    System.out.println(getPila());
                  //shift(getEstado(pila.charAt(pila.length()-1)),getNumToken(token));
              }catch(StringIndexOutOfBoundsException ex){
                        
              }
            }
        }
    }
    public int getEstado(char estado){
        int cambio=-1;
        if(estado=='S'){
            cambio=0;
        }else if(estado=='C'){
            cambio=1;
        }else if(estado=='E'){
            cambio=2;
        }else if(estado=='P'){
            cambio=3;
        }else if(estado=='A'){
            cambio=4;
        }else if(estado=='R'){
            cambio=5;
        }else if(estado=='T'){
            cambio=6;
        }else if(estado=='M'){
            cambio=7;
        }else if(estado=='Q'){
            cambio=8;
        }else if(estado=='F'){
            cambio=9;
        }
        return cambio;
    }
    public int getNumToken(String token){
        int cambio=-1;
        if(token.equals("L")){
            cambio=0;
        }else if(token.equals("i")){
            cambio=1;
        }else if(token.equals("n")){
            cambio=2;
        }else if(token.equals("3")){
            cambio=3;
        }else if(token.equals("4")){
            cambio=4;
        }else if(token.equals("5")){
            cambio=5;
        }else if(token.equals("6")){
            cambio=6;
        }else if(token.equals("7")){
            cambio=7;
        }else if(token.equals("8")){
            cambio=8;
        }else if(token.equals("9")){
            cambio=9;
        }else if(token.equals("0")){ //SI
            cambio=10;
        }else if(token.equals("+")){
            cambio=11;
        }else if(token.equals("*")){
            cambio=12;
        }else if(token.equals("(")){
            cambio=13;
        }else if(token.equals(")")){
            cambio=14;
        }else if(token.equals("$")){
            cambio=15;
        }
        return cambio;
    }
    public String shift(int linea, int columna){
        String derivacion="ERROR";
        if(linea >= 0 && columna >=0){            
        derivacion=TablaAnalisisLL1[linea][columna];
        }
        return derivacion;
    }
    public void insertarAPila(String estadosNormales){
        for(int x=estadosNormales.length()-1; x>=0;x--){
            setPila(getPila()+ estadosNormales.charAt(x));
        }
    }
    public boolean pop(int linea, int columna, String tokenLexico){
        boolean sonIguales=false;
        if(TablaAnalisisLL1[linea][columna].equals(tokenLexico)){
            sonIguales=true;
        }else{
            sonIguales=false;
        }
        System.out.println("Va en el pop:");
        System.out.println(TablaAnalisisLL1[linea][columna] + "-->"+tokenLexico);
        return sonIguales;
    }
    public void reduce(){
        String nuevaPila="";
        for(int x=0;x<getPila().length()-1;x++){
            nuevaPila += getPila().charAt(x);
        }
        setPila(nuevaPila);
        System.out.println("Va en el reduce");
    }
    public void verificarPila(String token){
        if(pila.equals("")){
            //pila="E$";                    
            insertarAPila("E$");
        }else if(pila.equals("$")){
            setPila("");
            insertarAPila("E$");
            //insertarAPila(token);
        }
        //System.out.println("Va en verificarPila");
        System.out.println(pila);
    }
}
