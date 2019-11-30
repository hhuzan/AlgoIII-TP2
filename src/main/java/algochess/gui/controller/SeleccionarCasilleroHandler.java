package algochess.gui.controller;

import algochess.engine.juego.Juego;
import algochess.gui.vista.ContenedorCompras;
import algochess.gui.vista.ContenedorPrincipal;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import algochess.gui.ExceptionHandler;
import algochess.excepciones.ColocarEntidadException;
import algochess.excepciones.DineroInsuficienteException;

public class SeleccionarCasilleroHandler implements EventHandler<MouseEvent> {
	private Juego juego;
	private ContenedorCompras contenedorCompras;
	private ContenedorPrincipal contenedorPrincipal;
	private int fila;
	private int columna;
	private ExceptionHandler exHandler;

	public SeleccionarCasilleroHandler(Juego juego, ContenedorCompras contenedorCompras, int fila, int columna) {
		this.juego = juego;
		this.contenedorCompras = contenedorCompras;
		this.contenedorPrincipal = null;
		this.fila = fila;
		this.columna = columna;
		this.exHandler = new ExceptionHandler();
	}

	public SeleccionarCasilleroHandler(Juego juego, ContenedorPrincipal contenedorPrincipal, int fila, int columna) {
		this.juego = juego;
		this.contenedorCompras = null;
		this.contenedorPrincipal = contenedorPrincipal;
		this.fila = fila;
		this.columna = columna;
		this.exHandler = new ExceptionHandler();
	}
	
    @Override
    public void handle(MouseEvent event) {
    	if(contenedorCompras == null) {
    		// Seleccion de casillero en desarrollo de juego
    		// try {
    		// 	juego.seleccionarEntidad(fila, columna);
    		// 	contenedorPrincipal.refrescar();
    		// } 
    	} else if(contenedorPrincipal == null) {
    		// Seleccion de casillero en fase inicial
	    	try {
				juego.comprarEntidad(fila, columna);
	    		contenedorCompras.refrescar();
	    	} catch(ColocarEntidadException ex) {
	    		exHandler.manageException(ex);
	    	} catch(DineroInsuficienteException ex) {
	    		exHandler.manageException(ex);
	    	}
    	}
    }
}