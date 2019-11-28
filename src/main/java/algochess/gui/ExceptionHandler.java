package algochess.gui;

import algochess.excepciones.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class ExceptionHandler  {

    public void manageException(CasilleroOcupadoException ex) {

    }

    public void manageException(CasilleroVacioException ex) {
        
    }

    public void manageException(ColocarEntidadException ex) {
        System.out.println(ex);
        Alert alert = new Alert(AlertType.ERROR, ex.toString(), ButtonType.OK);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    public void manageException(DineroInsuficienteException ex) {
        
    }

    public void manageException(EntidadDeMismaFaccionException ex) {
        
    }

    public void manageException(JugadorPerdioException ex) {
        
    }

    public void manageException(NoEsTuTurnoException ex) {
        
    }
}