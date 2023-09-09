/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import AnalizadorSintactico.AnalisisSintactico;
import Leer_Escribir_Archivos.ArchivosLeerEscribir;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class InterfazGrafica extends javax.swing.JFrame {
    ArchivosLeerEscribir arc;
    AnalisisSintactico sintaxis;
    java.awt.event.WindowEvent eventoInicioVentana;
    String lugarDeArchivo="none";
    String contenidoDelAreaEntrada="none";
    boolean cambiosGuardados=true;
    

    /**
     * Creates new form InterfazGrafica
     */
    public InterfazGrafica() {
        initComponents();
        formWindowOpenededTokens(eventoInicioVentana);
        iniciarVariables();
    }

    public void iniciarVariables(){
        arc= new ArchivosLeerEscribir();
        sintaxis = new AnalisisSintactico();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane3 = new javax.swing.JTabbedPane();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        AreaEntrada = new javax.swing.JTextArea();
        botonAnalizar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        AreaSalida = new javax.swing.JTextArea();
        ImportarArchivos = new javax.swing.JButton();
        BotonExportar = new javax.swing.JButton();
        botonGuardarCambios = new javax.swing.JButton();
        botonVaciarTexto = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnGuardarSalida = new javax.swing.JButton();
        botonAcercade = new javax.swing.JButton();
        botonDeshacerCambios = new javax.swing.JButton();
        botonNuevoAnalisis = new javax.swing.JButton();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaReporteTokens = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setName("Analizador Sintáctico"); // NOI18N

        AreaEntrada.setBackground(java.awt.Color.lightGray);
        AreaEntrada.setColumns(20);
        AreaEntrada.setRows(5);
        jScrollPane1.setViewportView(AreaEntrada);

        botonAnalizar.setBackground(java.awt.Color.green);
        botonAnalizar.setText("Analizar");
        botonAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnalizarActionPerformed(evt);
            }
        });

        AreaSalida.setEditable(false);
        AreaSalida.setBackground(new java.awt.Color(0, 0, 0));
        AreaSalida.setColumns(20);
        AreaSalida.setForeground(java.awt.Color.cyan);
        AreaSalida.setRows(5);
        jScrollPane2.setViewportView(AreaSalida);

        ImportarArchivos.setBackground(new java.awt.Color(0, 20, 173));
        ImportarArchivos.setForeground(new java.awt.Color(255, 255, 255));
        ImportarArchivos.setText("Importar");
        ImportarArchivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImportarArchivosActionPerformed(evt);
            }
        });

        BotonExportar.setBackground(new java.awt.Color(51, 255, 255));
        BotonExportar.setText("Guardar como");
        BotonExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonExportarActionPerformed(evt);
            }
        });

        botonGuardarCambios.setBackground(new java.awt.Color(255, 255, 0));
        botonGuardarCambios.setText("Guardar Cambios");
        botonGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarCambiosActionPerformed(evt);
            }
        });

        botonVaciarTexto.setBackground(new java.awt.Color(255, 51, 51));
        botonVaciarTexto.setForeground(new java.awt.Color(255, 255, 255));
        botonVaciarTexto.setText("Vaciar texto");
        botonVaciarTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVaciarTextoActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnGuardarSalida.setText("Guardar salida");
        btnGuardarSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarSalidaActionPerformed(evt);
            }
        });

        botonAcercade.setText("Acerca De");
        botonAcercade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAcercadeActionPerformed(evt);
            }
        });

        botonDeshacerCambios.setText("Deshacer cambios");
        botonDeshacerCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDeshacerCambiosActionPerformed(evt);
            }
        });

        botonNuevoAnalisis.setBackground(java.awt.Color.orange);
        botonNuevoAnalisis.setText("Nuevo");
        botonNuevoAnalisis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoAnalisisActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(botonAnalizar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(ImportarArchivos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(BotonExportar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(botonGuardarCambios, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(botonVaciarTexto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnGuardarSalida, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(botonAcercade, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(botonDeshacerCambios, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(botonNuevoAnalisis, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(btnGuardarSalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(botonAcercade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(botonNuevoAnalisis, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(botonDeshacerCambios, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(botonAnalizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ImportarArchivos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BotonExportar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(botonGuardarCambios, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                    .addComponent(botonVaciarTexto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(12, 12, 12))))))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(botonAnalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(ImportarArchivos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotonExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonGuardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonDeshacerCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonNuevoAnalisis, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonVaciarTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(botonAcercade, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardarSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Funcionalidad", jDesktopPane1);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reporte de tokens", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        tablaReporteTokens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tablaReporteTokens);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1312, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 892, Short.MAX_VALUE)
        );

        jDesktopPane2.setLayer(jPanel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Reportes", jDesktopPane2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("Analizador Sintáctico");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnalizarActionPerformed
        AreaSalida.setText("");
        limpiarTablaTokens();
        iniciarVariables();
        arc.leerArchivoAnalizando(AreaEntrada.getText(), InterfazGrafica.AreaSalida);
        //sintaxis.verificarSalida();
    }//GEN-LAST:event_botonAnalizarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.AreaSalida.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ImportarArchivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImportarArchivosActionPerformed
       if(cambiosGuardados==true){
        iniciarVariables();
        limpiarTablaTokens();
        abrirFileChooser();
       }else if(contenidoDelAreaEntrada.equals(AreaEntrada.getText())){
        iniciarVariables();
        limpiarTablaTokens();
        abrirFileChooser();
       }else{
            JOptionPane.showMessageDialog(null,"No has guardado los cambios"
                    + "\nSi desea no guardar los cambios presione "
                    + "\ndeshacer cambios; de lo contrario presione"
                    + "\nGuardar cambios");
       }
        
    }//GEN-LAST:event_ImportarArchivosActionPerformed

    private void botonGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarCambiosActionPerformed
        verificarSiHayLugarParaGuardar();
    }//GEN-LAST:event_botonGuardarCambiosActionPerformed

    private void btnGuardarSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarSalidaActionPerformed
         guardarArchivo(AreaSalida);
    }//GEN-LAST:event_btnGuardarSalidaActionPerformed

    private void BotonExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonExportarActionPerformed
        guardarArchivo(AreaEntrada);
    }//GEN-LAST:event_BotonExportarActionPerformed

    private void botonVaciarTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVaciarTextoActionPerformed
        AreaEntrada.setText("");
    }//GEN-LAST:event_botonVaciarTextoActionPerformed

    private void botonAcercadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAcercadeActionPerformed
        // TODO add your handling code here:
        mostrarDatosCreador();
    }//GEN-LAST:event_botonAcercadeActionPerformed

    private void botonDeshacerCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDeshacerCambiosActionPerformed
        if(cambiosGuardados==true || contenidoDelAreaEntrada.equals("none")){
            JOptionPane.showMessageDialog(null, "no se ha importado ningun archivo");
        }else{
            AreaEntrada.setText(contenidoDelAreaEntrada);
            JOptionPane.showMessageDialog(null, "Se han deshecho los cambios");
        }
    }//GEN-LAST:event_botonDeshacerCambiosActionPerformed

    private void botonNuevoAnalisisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoAnalisisActionPerformed
        if(cambiosGuardados==true){
            nuevoAnalisis();
        }else if(contenidoDelAreaEntrada.equals(AreaEntrada.getText())){
             nuevoAnalisis();
        }else{
               JOptionPane.showMessageDialog(null,"No has guardado los cambios"
                    + "\nSi desea no guardar los cambios presione "
                    + "\ndeshacer cambios; de lo contrario presione"
                    + "\nGuardar cambios");
        }
    }//GEN-LAST:event_botonNuevoAnalisisActionPerformed
     public void nuevoAnalisis(){
        lugarDeArchivo="none";
        contenidoDelAreaEntrada="none";
        cambiosGuardados=true;
        AreaEntrada.setText("");
        AreaSalida.setText("");
    }
    public void mostrarDatosCreador(){
        JOptionPane.showMessageDialog(null, "Nombre del creador: Eiler Rigoberto Gómez Figeroa"
                                            + "\nCarnet: 202031693 "
                                            + "\nEstudiante de: Ingeniería en Ciencias y Sistemas"
                                            + "\nEn: Centro Universitario de Occidente (USAC)"
                                            + "\nEdad: 18 años.");
    }
    public void abrirFileChooser(){
        JFileChooser jf= new JFileChooser();
        jf.showOpenDialog(this);
        File archivo = jf.getSelectedFile();
        AreaEntrada.setText("");
        //limpiarTablaTokens();
        //limpiarTablaErrores();
        //limpiarTablaRecuentoTokens();
        if(archivo !=null || !archivo.getName().equals("")){           
            //AreaSalida.setText(archivo.getAbsolutePath());
            lugarDeArchivo=archivo.getAbsolutePath();
            arc.leerArchivoDeEntrada(archivo.getAbsolutePath(),AreaEntrada,AreaSalida);               
        }
        contenidoDelAreaEntrada=AreaEntrada.getText();
        cambiosGuardados=false;
    }
    public void verificarSiHayLugarParaGuardar(){
        if(lugarDeArchivo.equals("none")){
            JOptionPane.showMessageDialog(null, "No has guardado el archivo "
                    + "\nO no has importado un archivo"
                    + "\nPor favor, guarda como o importa un archivo");
        }else if(lugarDeArchivo.charAt(0)=='C'){
            //guardarCambios
            arc.guardarArchivo(AreaEntrada.getText(),lugarDeArchivo);
            contenidoDelAreaEntrada=AreaEntrada.getText();
            cambiosGuardados=true;
            JOptionPane.showMessageDialog(null, "Cambios Guardados");
        }
    }
     public void guardarArchivo(JTextArea areaTexto){
        JFileChooser guardar = new JFileChooser();
        guardar.setApproveButtonText("Guardar");
        guardar.showSaveDialog(null);
        arc.guardarArchivo(areaTexto.getText(),guardar.getSelectedFile().toString());
    }
    
    public static void agregarReporteToken(Object ror[]){
         ((DefaultTableModel) tablaReporteTokens.getModel()).addRow(ror);
    }
    private void formWindowOpenededTokens(java.awt.event.WindowEvent event){
        DefaultTableModel modelo = (DefaultTableModel)tablaReporteTokens.getModel();
        modelo.addColumn("Lexema");
        modelo.addColumn("Token");
        modelo.addColumn("Fila");
        modelo.addColumn("Columna");
    }
    public static void limpiarTablaTokens(){
         DefaultTableModel modelo = (DefaultTableModel)tablaReporteTokens.getModel();
        for(int i=0; i<tablaReporteTokens.getRowCount();i++){
            modelo.removeRow(i);
            
            i-=1;
        }
    }   
    
    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextArea AreaEntrada;
    public static javax.swing.JTextArea AreaSalida;
    private javax.swing.JButton BotonExportar;
    private javax.swing.JButton ImportarArchivos;
    private javax.swing.JButton botonAcercade;
    private javax.swing.JButton botonAnalizar;
    private javax.swing.JButton botonDeshacerCambios;
    private javax.swing.JButton botonGuardarCambios;
    private javax.swing.JButton botonNuevoAnalisis;
    private javax.swing.JButton botonVaciarTexto;
    private javax.swing.JButton btnGuardarSalida;
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    public static javax.swing.JTable tablaReporteTokens;
    // End of variables declaration//GEN-END:variables
}