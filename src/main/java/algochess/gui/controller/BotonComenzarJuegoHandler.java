package algochess.gui.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import algochess.engine.juego.Juego;
import algochess.engine.jugador.Jugador;
import algochess.engine.tablero.Tablero;
    
public class BotonComenzarJuegoHandler implements EventHandler<ActionEvent> {

    Stage stage;
    Scene proximaEscena;
    Juego juego;
    Jugador jugadorAliado;
    Jugador jugadorEnemigo;
    Tablero tablero;

    public BotonComenzarJuegoHandler(Stage stage, Scene proximaEscena, Juego juego) {
        this.stage = stage;
        this.proximaEscena = proximaEscena;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.setScene(proximaEscena);
        juego.iniciarPartida("AA","BB");
    }
}