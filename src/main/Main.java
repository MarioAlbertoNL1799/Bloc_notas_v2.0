/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import models.ModelBlocNotas;
import views.ViewBlocNotas;
import controllers.ControllerBlocNotas;
/**
 *clase que maneja el modelo MVC para visualizar un archivo de texto y agregar datos
 * @author manl_
 */
public class Main {

    /**
     * metodo que une al controlador, visualizador y modelos.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ModelBlocNotas modelBlocnotas = new ModelBlocNotas();
        ViewBlocNotas viewBlocnotas = new ViewBlocNotas();
        ControllerBlocNotas controllerBlocnotas = new ControllerBlocNotas(modelBlocnotas, viewBlocnotas);
        
    }
    
}
