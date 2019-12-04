package algochess.gui;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class ExceptionHandler  {

    public void manageException(Exception ex) {
        System.out.println(ex);
        Alert alert = new Alert(AlertType.ERROR, ex.toString(), ButtonType.OK);
        alert.setHeaderText(null);
        alert.showAndWait();
    }
}