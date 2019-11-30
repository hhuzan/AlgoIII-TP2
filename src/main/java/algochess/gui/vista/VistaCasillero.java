package algochess.gui.vista;

import java.lang.reflect.Constructor;
import java.util.Map;

import algochess.engine.facciones.Faccion;
import algochess.engine.juego.Juego;
import algochess.engine.tablero.Casillero;
import algochess.engine.entidades.Soldado;
import algochess.engine.entidades.Jinete;
import algochess.engine.entidades.Catapulta;
import algochess.engine.entidades.Curandero;
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
	private ContenedorPrincipal contenedorPrincipal;
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

		Map<Class, String> vistaDict = Map.of(
			 Catapulta.class, 	"algochess.gui.vista.VistaCatapulta",
			 Jinete.class, 		"algochess.gui.vista.VistaJinete",
			 Curandero.class, 	"algochess.gui.vista.VistaCurandero",
			 Soldado.class, 	"algochess.gui.vista.VistaSoldado"
		);

		String nombreClase = vistaDict.get(casillero.getEntidad().getClass()); 
		
		System.out.println(nombreClase);
		if(nombreClase != null) {
			try {
				Class<?> clase = Class.forName(nombreClase);
				Constructor<?> constructor = clase.getConstructor(VistaCasillero.class, Faccion.class);
				vistaEntidad = (VistaEntidad) constructor.newInstance(this, casillero.getEntidad().getPropietario().getFaccion());

			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	VistaCasillero(int fila, int columna, int tamanio, Casillero casillero, Juego juego,
			ContenedorPrincipal contenedorPrincipal) {
		super();

		if (casillero.getFaccion() == Faccion.ALIADOS)
			setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, CornerRadii.EMPTY, Insets.EMPTY)));
		else
			setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, CornerRadii.EMPTY, Insets.EMPTY)));

		setPrefSize(tamanio, tamanio);
		this.juego = juego;
		this.fila = fila;
		this.columna = columna;
		this.contenedorPrincipal = contenedorPrincipal;
		this.tamanio = tamanio;
		setOnMouseClicked(new SeleccionarCasilleroHandler(juego, contenedorPrincipal, fila, columna));

		Map<Class, String> vistaDict = Map.of(
			 Catapulta.class, 	"algochess.gui.vista.VistaCatapulta",
			 Jinete.class, 		"algochess.gui.vista.VistaJinete",
			 Curandero.class, 	"algochess.gui.vista.VistaCurandero",
			 Soldado.class, 	"algochess.gui.vista.VistaSoldado"
		);

		String nombreClase = vistaDict.get(casillero.getEntidad().getClass()); 
		
		System.out.println(nombreClase);
		if(nombreClase != null) {
			try {
				Class<?> clase = Class.forName(nombreClase);
				Constructor<?> constructor = clase.getConstructor(VistaCasillero.class, Faccion.class);
				vistaEntidad = (VistaEntidad) constructor.newInstance(this, casillero.getEntidad().getPropietario().getFaccion());

			} catch (Exception e) {
				System.out.println(e);
			}
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
