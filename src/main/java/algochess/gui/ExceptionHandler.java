package algochess.gui;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import algochess.excepciones.JugadorPerdioException;

public class ExceptionHandler  {

    public void manageException(Exception ex) {
    	System.out.println("Entre aca");
        System.out.println(ex);
        Alert alert = createAlert(ex);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    private Alert createAlert(Exception ex) {
        Alert alert = new Alert(AlertType.ERROR, ex.toString(), ButtonType.OK);
    	return alert;
    }
}