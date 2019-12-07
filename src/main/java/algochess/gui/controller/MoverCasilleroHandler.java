package algochess.gui.controller;

import algochess.engine.juego.Juego;
import algochess.gui.vista.Musica;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import algochess.gui.vista.ContenedorPrincipal;
import algochess.gui.ExceptionHandler;

public class MoverCasilleroHandler implements EventHandler<ActionEvent> {

	private int filaOrigen;
	private int filaDestino;
	private int colOrigen;
	private int colDestino;
	private ExceptionHandler exHandler;
	private ContenedorPrincipal contenedor;
	private Juego juego;
	private Musica musica;

	public MoverCasilleroHandler(ContenedorPrincipal contenedor, Juego juego, int filaOrigen, int colOrigen, int filaDestino, int colDestino) {
		this.juego = juego;
		this.filaOrigen = filaOrigen;
		this.filaDestino = filaDestino;
		this.colOrigen = colOrigen;
		this.colDestino = colDestino;
		this.contenedor = contenedor;
		this.exHandler = new ExceptionHandler();
		this.musica = new Musica();
	}

	@Override
	public void handle(ActionEvent actionEvent) {

		musica.reproducirSonidoDeMover();

		try {
			juego.mover(filaOrigen, colOrigen, filaDestino, colDestino);
			contenedor.refrescar();
		} catch (Exception ex) {
			exHandler.manageException(ex);
		}

	}
}