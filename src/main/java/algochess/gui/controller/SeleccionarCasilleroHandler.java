package algochess.gui.controller;

import algochess.engine.juego.Juego;
import algochess.gui.vista.ContenedorCompras;
import algochess.gui.vista.VistaCasillero;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import algochess.gui.ExceptionHandler;


public class SeleccionarCasilleroHandler implements EventHandler<MouseEvent> {
	private Juego juego;
	private ContenedorCompras contenedorCompras;
	private int fila;
	private int columna;
	private ExceptionHandler exHandler;
	private boolean entidadSeleccionada;
	private VistaCasillero casillero;

	public SeleccionarCasilleroHandler(Juego juego, ContenedorCompras contenedorCompras, int fila, int columna) {
		this.juego = juego;
		this.contenedorCompras = contenedorCompras;
		this.fila = fila;
		this.columna = columna;
		this.exHandler = new ExceptionHandler();
		this.entidadSeleccionada = false;
	}

	// TODO: Ver como haces dos events separados y refactor 
    @Override
    public void handle(MouseEvent event) {
		System.out.println("Handler de contenedor compras");	
    	try {
			juego.comprarEntidad(fila, columna);
    		contenedorCompras.refrescar();
    	} catch (Exception ex) {
    		exHandler.manageException(ex);
    	}
    }
}