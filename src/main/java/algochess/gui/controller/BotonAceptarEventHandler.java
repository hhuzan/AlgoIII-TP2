package algochess.gui.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonAceptarEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    Scene proximaEscena;

    public BotonAceptarEventHandler(Stage stage, Scene proximaEscena) {
        this.stage = stage;
        this.proximaEscena = proximaEscena;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.setScene(proximaEscena);
        stage.setFullScreenExitHint("");
    }
}