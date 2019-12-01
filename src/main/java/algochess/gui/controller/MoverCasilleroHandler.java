package algochess.gui.controller;

import algochess.engine.juego.Juego;
import algochess.gui.vista.ContenedorCompras;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import algochess.gui.ExceptionHandler;

public class MoverCasilleroHandler implements EventHandler<ActionEvent> {

	private int filaOrigen;
	private int filaDestino;
	private int colOrigen;
	private int colDestino;
	private ExceptionHandler exHandler;
	private Juego juego;

	public MoverCasilleroHandler(Juego juego, int filaOrigen, int colOrigen, int filaDestino, int colDestino) {
		this.juego = juego;
		this.filaOrigen = filaOrigen;
		this.filaDestino = filaDestino;
		this.colOrigen = colOrigen;
		this.colDestino = colDestino;
		this.exHandler = new ExceptionHandler();
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		try {
			// juego.atacar(filaOrigen, colOrigen, filaDestino, colDestino);
		} catch (Exception ex) {
			System.out.println(ex);
			// exHandler.manageException(ex);
		}
	}
}