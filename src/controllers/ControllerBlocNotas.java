/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import views.ViewBlocNotas;
import models.ModelBlocNotas;

/**
 *clase que tiene el objeto de modelo y vista del bloc de notas y realiza un evento acorde a cada accion que realicemos
 * @author manl_
 */
public class ControllerBlocNotas {
    ModelBlocNotas modelBlocnotas;
    ViewBlocNotas viewBlocnotas;

    ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()== viewBlocnotas.jMI_abrir)
             jmi_abrir_actionPerformed();   
            else if(e.getSource()== viewBlocnotas.jMI_guardar)
                jki_guardar_actionPerformed();
        }
    };
    /**
     * metodo que lee el archivo de texto y lo muestra en el area de texto
     */
    public void jmi_abrir_actionPerformed(){
        modelBlocnotas.openFile();
        if (modelBlocnotas.getPath() == null)
            viewBlocnotas.jta_texto.setText(null);
        else{
            modelBlocnotas.readFile();
            viewBlocnotas.jta_texto.setText(modelBlocnotas.getLinea());
        }
    }
    /**
     * metodo que guarda todo el texto en una variable de tipo cadena y lo guarda en el archivo de texto 
     */
    public void jki_guardar_actionPerformed(){
        modelBlocnotas.setMessage(viewBlocnotas.jta_texto.getText());
        modelBlocnotas.writeFile();
    }
    
    /**
     * constructor que permite la interaccion de los modelos y las vistas para su manipulacion
     * @param modelBlocnotas objeto modelo que contiene variables y metodos para leer y agregar texto el archivo
     * @param viewBlocnotas  objeto vista que permite visualizar el archivo de texto 
     */
     public ControllerBlocNotas(ModelBlocNotas modelBlocnotas, ViewBlocNotas viewBlocnotas) {
        this.modelBlocnotas = modelBlocnotas;
        this.viewBlocnotas = viewBlocnotas;
        this.viewBlocnotas.jMI_abrir.addActionListener(al);
        this.viewBlocnotas.jMI_guardar.addActionListener(al);
        initComponents();
    }
     /**
      * metodo que permite la visualizacion de la aplicacion de java
      */
     public void initComponents(){
         this.viewBlocnotas.setVisible(true);
     }
}
