package algochess.gui.controller;

import algochess.engine.juego.Juego;
import algochess.gui.vista.ContenedorPrincipal;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class SeleccionarCasilleroHandler implements EventHandler<MouseEvent> {
	private Juego juego;
	private ContenedorPrincipal contenedorPrincipal;
	private int fila;
	private int columna;

	public SeleccionarCasilleroHandler(Juego juego,ContenedorPrincipal contenedorPrincipal,int fila,int columna) {
		this.juego = juego;
		this.contenedorPrincipal = contenedorPrincipal;
		this.fila = fila;
		this.columna = columna;
	}
	
    @Override
    public void handle(MouseEvent event) {
		juego.comprarEntidad(fila, columna);
    	contenedorPrincipal.refrescar();
    }
}