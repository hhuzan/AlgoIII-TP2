package algochess.gui.controller;

import algochess.engine.juego.Juego;
import algochess.gui.vista.ContenedorCompras;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import algochess.gui.vista.ContenedorPrincipal;
import javafx.stage.Stage;
import algochess.gui.ExceptionHandler;

public class CurarCasilleroHandler implements EventHandler<ActionEvent> {

	private int filaOrigen;
	private int filaDestino;
	private int colOrigen;
	private int colDestino;
	private ContenedorPrincipal contenedor;
	private ExceptionHandler exHandler;
	private Juego juego;

	public CurarCasilleroHandler(ContenedorPrincipal contenedor, Juego juego, int filaOrigen, int colOrigen, int filaDestino, int colDestino) {
		this.juego = juego;
		this.filaOrigen = filaOrigen;
		this.filaDestino = filaDestino;
		this.colOrigen = colOrigen;
		this.colDestino = colDestino;
		this.contenedor = contenedor;
		this.exHandler = new ExceptionHandler();
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		try {
			juego.curar(filaOrigen, colOrigen, filaDestino, colDestino);
			contenedor.refrescar();
		} catch (Exception ex) {
			exHandler.manageException(ex);
		}
	}
}