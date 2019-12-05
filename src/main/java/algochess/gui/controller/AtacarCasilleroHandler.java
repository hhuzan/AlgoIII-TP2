package algochess.gui.controller;

import algochess.engine.juego.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import algochess.gui.ExceptionHandler;
import algochess.gui.vista.ContenedorPrincipal;
import algochess.excepciones.EntidadDeMismaFaccionException;
import algochess.excepciones.EntidadFueraDeAlcanceException;
import algochess.excepciones.JugadorPerdioException;

public class AtacarCasilleroHandler implements EventHandler<ActionEvent> {

	private int filaOrigen;
	private int filaDestino;
	private int colOrigen;
	private int colDestino;
	private ExceptionHandler exHandler;
	private Juego juego;
	private ContenedorPrincipal contenedor;

	public AtacarCasilleroHandler(ContenedorPrincipal contenedor, Juego juego, int filaOrigen, int colOrigen, int filaDestino, int colDestino) {
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
			juego.atacar(filaOrigen, colOrigen, filaDestino, colDestino);
			contenedor.refrescar();
		} catch (EntidadDeMismaFaccionException ex) {
			exHandler.manageException(ex);
		} catch (EntidadFueraDeAlcanceException ex) {
			exHandler.manageException(ex);
		} catch(JugadorPerdioException ex) {
			contenedor.refrescar();
			contenedor.finalizarJuego(ex.getJugador());
		}
	}
}