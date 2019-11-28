package algochess.gui.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import algochess.engine.juego.Juego;

public abstract class ComprarEntidadEventHandler implements EventHandler<ActionEvent> {

    private String entidadStr;
    private Juego juego;

    public ComprarEntidadEventHandler(String entidad, Juego juego) {
        this.entidadStr = entidad;
        this.juego = juego;
    }
}