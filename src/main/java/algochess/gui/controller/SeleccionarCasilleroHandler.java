package algochess.gui.controller;

import algochess.engine.juego.Juego;
import algochess.gui.vista.ContenedorCompras;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import algochess.gui.ExceptionHandler;
import algochess.excepciones.ColocarEntidadException;
import algochess.excepciones.DineroInsuficienteException;

public class SeleccionarCasilleroHandler implements EventHandler<MouseEvent> {
	private Juego juego;
	private ContenedorCompras contenedorCompras;
	private int fila;
	private int columna;
	private ExceptionHandler exHandler;

	public SeleccionarCasilleroHandler(Juego juego, ContenedorCompras contenedorPrincipal, int fila, int columna) {
		this.juego = juego;
		this.contenedorCompras = contenedorPrincipal;
		this.fila = fila;
		this.columna = columna;
		this.exHandler = new ExceptionHandler();
	}
	
    @Override
    public void handle(MouseEvent event) {
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