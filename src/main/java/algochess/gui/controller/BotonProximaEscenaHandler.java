package algochess.gui.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class BotonProximaEscenaHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private Scene proximaEscena;

    public BotonProximaEscenaHandler(Stage stage, Scene proximaEscena) {
        this.stage = stage;
        this.proximaEscena = proximaEscena;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.setScene(proximaEscena);
    }
}