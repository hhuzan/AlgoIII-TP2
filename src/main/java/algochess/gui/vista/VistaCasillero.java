package algochess.gui.vista;

import java.lang.reflect.Constructor;

import algochess.engine.facciones.Faccion;
import algochess.engine.juego.Juego;
import algochess.engine.tablero.Casillero;
import algochess.gui.controller.SeleccionarCasilleroHandler;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class VistaCasillero extends StackPane {
	private final int fila;
	private final int columna;
	private Juego juego;
	private ContenedorCompras contenedorCompras;
	private VistaEntidad vistaEntidad;
	private int tamanio;

	VistaCasillero(int fila, int columna, int tamanio, Casillero casillero, Juego juego,
			ContenedorCompras contenedorCompras) {
		super();

		if (casillero.getFaccion() == Faccion.ALIADOS)
			setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, CornerRadii.EMPTY, Insets.EMPTY)));
		else
			setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, CornerRadii.EMPTY, Insets.EMPTY)));

		setPrefSize(tamanio, tamanio);
		this.juego = juego;
		this.fila = fila;
		this.columna = columna;
		this.contenedorCompras = contenedorCompras;
		this.tamanio = tamanio;
		setOnMouseClicked(new SeleccionarCasilleroHandler(juego, contenedorCompras, fila, columna));

		String nombreClase = "algochess.gui.vista.Vista" + casillero.getEstado().getEntidad().getClass().getSimpleName()
				+ casillero.getEstado().getEntidad().getPropietario().getFaccion();

		try {
			Class<?> clase = Class.forName(nombreClase);
			Constructor<?> constructor = clase.getConstructor(VistaCasillero.class);
			vistaEntidad = (VistaEntidad) constructor.newInstance(this);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}

	public int getTamanio() {
		return tamanio;
	}
}
