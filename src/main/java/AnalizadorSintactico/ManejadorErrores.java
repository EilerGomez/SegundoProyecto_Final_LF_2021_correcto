/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalizadorSintactico;

import Vista.InterfazGrafica;

/**
 *
 * @author HP
 */
public class ManejadorErrores {
    public void mostrarErroresLexicosEnArea(String descripcionError){
        InterfazGrafica.AreaSalida.setText(InterfazGrafica.AreaSalida.getText() +  descripcionError);
    }
    public void mostrarErroresSintacticos(int linea, int columna, String descripcion){
        String mensaje=descripcion + " en la linea: " + linea + "; columna: " + (columna-1) + "\n";
        InterfazGrafica.AreaSalida.setText(InterfazGrafica.AreaSalida.getText() +  mensaje );
        InterfazGrafica.limpiarTablaTokens();
    }
}
