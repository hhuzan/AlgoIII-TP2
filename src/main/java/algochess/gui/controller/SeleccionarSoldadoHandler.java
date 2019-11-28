package algochess.gui.controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import algochess.engine.juego.Juego;


public class SeleccionarSoldadoHandler implements EventHandler<MouseEvent> {
	private Juego juego;
//	private ContenedorPrincipal contenedorPrincipal;


	public SeleccionarSoldadoHandler(Juego juego) {
		this.juego = juego;
//		this.contenedorPrincipal = contenedorPrincipal;
	}
	
    @Override
    public void handle(MouseEvent event) {
    	juego.seleccionarSodado();
//		contenedorPrincipal.refrescar();
    }
}