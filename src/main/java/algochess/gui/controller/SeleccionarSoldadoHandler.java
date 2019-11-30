package algochess.gui.controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import algochess.engine.juego.Juego;


public class SeleccionarSoldadoHandler implements EventHandler<MouseEvent> {
	private Juego juego;
//	private ContenedorCompras contenedorCompras;


	public SeleccionarSoldadoHandler(Juego juego) {
		this.juego = juego;
//		this.contenedorCompras = contenedorCompras;
	}
	
    @Override
    public void handle(MouseEvent event) {
    	juego.seleccionarSoldado();
//		contenedorCompras.refrescar();
    }
}