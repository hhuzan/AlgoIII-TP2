package algochess.gui.controller;

import algochess.gui.vista.FXDialogos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonInstruccionesHandler implements EventHandler<ActionEvent> {


    @Override
    public void handle(ActionEvent actionEvent) {

        FXDialogos.showInformation("Instrucciones", "Aca se muestran las instrucciones para jugar");

    }
}
