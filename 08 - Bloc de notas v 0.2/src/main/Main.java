package main;

import models.ModelBlocDeNotas;
import models.ModelFondoPanel;
import views.ViewBlocDeNotas;
import controllers.ControllerBlocDeNotas;
/**
 *
 * @author Norberto
 */
public class Main {
    private static ModelBlocDeNotas modelBlocDeNotas;
    private static ViewBlocDeNotas viewBlocDeNotas;
    private static ControllerBlocDeNotas controllerBlocDeNotas;
    
    /** Clase principal que da inicio al Bloc de Notas Version 1
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        modelBlocDeNotas = new ModelBlocDeNotas();
        viewBlocDeNotas = new ViewBlocDeNotas();
        controllerBlocDeNotas = new ControllerBlocDeNotas(modelBlocDeNotas, viewBlocDeNotas);
    }
    
}
