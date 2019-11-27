package algochess.gui.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

import algochess.engine.entidades.Catapulta;
import algochess.engine.entidades.Curandero;
import algochess.engine.entidades.Jinete;
import algochess.engine.entidades.Soldado;
import algochess.engine.juego.Juego;

public class ComprarEntidadEventHandler implements EventHandler<ActionEvent> {

    String entidadStr;
    Juego juego;

    public ComprarEntidadEventHandler(String entidad, Juego juego) {
        this.entidadStr = entidad;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(entidadStr == "jinete") {
            Jinete jinete = new Jinete();
            // juego.comprarEntidad(jinete);

        } else if(entidadStr == "soldado") {
            Soldado soldado = new Soldado();
            // juego.comprarEntidad(soldado);

        } else if(entidadStr == "catapulta") {
            Catapulta catapulta = new Catapulta();
            // juego.comprarEntidad(catapulta);

        } else if(entidadStr == "curandero") {
            Curandero curandero = new Curandero();
            // juego.comprarEntidad(curandero);

        }
    }
}