package algochess.gui.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import algochess.engine.juego.Juego;

public class BotonComenzarJuegoHandler implements EventHandler<ActionEvent> {

    Stage stage;
    Scene proximaEscena;
    Juego juego;
    String jugador;
    TextField jugadorAliado;
    TextField jugadorEnemigo;

    public BotonComenzarJuegoHandler(Stage stage, Scene proximaEscena, Juego juego, TextField jugadorAliado, TextField jugadorEnemigo) {
        this.stage = stage;
        this.proximaEscena = proximaEscena;
        this.juego = juego;
        this.jugadorAliado = jugadorAliado;
        this.jugadorEnemigo = jugadorEnemigo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.setScene(proximaEscena);
        juego.iniciarPartida(jugadorAliado.getText(), jugadorEnemigo.getText());
        System.out.println(jugadorAliado.getText());
        System.out.println(jugadorEnemigo.getText());
    }
}