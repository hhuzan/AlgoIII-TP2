package algochess.gui.vista;

import java.lang.reflect.Constructor;
import java.util.Map;

import algochess.engine.facciones.Faccion;
import algochess.engine.juego.Juego;
import algochess.engine.tablero.Casillero;
import algochess.engine.entidades.Entidad;
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
import javafx.beans.binding.Bindings;

public class VistaCasillero extends StackPane {
	private final int fila;
	private final int columna;
	private Juego juego;
	private VistaEntidad vistaEntidad;
	private int tamanio;
	private Background backgroundColor;

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
		this.tamanio = tamanio;
		setOnMouseClicked(new SeleccionarCasilleroHandler(juego, contenedorCompras, fila, columna));

		Map<Class, String> vistaDict = Map.of(
			 Catapulta.class, 	"algochess.gui.vista.VistaCatapulta",
			 Jinete.class, 		"algochess.gui.vista.VistaJinete",
			 Curandero.class, 	"algochess.gui.vista.VistaCurandero",
			 Soldado.class, 	"algochess.gui.vista.VistaSoldado"
		);

		String nombreClase = vistaDict.get(casillero.getEntidad().getClass()); 
		
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

	// TODO: Ver de hacer intrefaz contenedor o padre
	VistaCasillero(int fila, int columna, int tamanio, Casillero casillero, Juego juego,
			ContenedorPrincipal contenedorPrincipal) {
		super();

		if (casillero.getFaccion() == Faccion.ALIADOS) 
			backgroundColor = new Background(new BackgroundFill(Color.LIGHTPINK, CornerRadii.EMPTY, Insets.EMPTY));
		else 
			backgroundColor = new Background(new BackgroundFill(Color.AQUAMARINE, CornerRadii.EMPTY, Insets.EMPTY));
		setBackground(backgroundColor);

		setStyle("-fx-border-color: transparent;");
		setPrefSize(tamanio, tamanio);
		this.juego = juego;
		this.fila = fila;
		this.columna = columna;
		this.tamanio = tamanio;

		Map<Class, String> vistaDict = Map.of(
			 Catapulta.class, 	"algochess.gui.vista.VistaCatapulta",
			 Jinete.class, 		"algochess.gui.vista.VistaJinete",
			 Curandero.class, 	"algochess.gui.vista.VistaCurandero",
			 Soldado.class, 	"algochess.gui.vista.VistaSoldado"
		);

		String nombreClase = vistaDict.get(casillero.getEntidad().getClass()); 
		
		if(nombreClase != null) {
			try {
				Class<?> clase = Class.forName(nombreClase);
				Constructor<?> constructor = clase.getConstructor(VistaCasillero.class, Faccion.class);
				vistaEntidad = (VistaEntidad) constructor.newInstance(this, casillero.getEntidad().getPropietario().getFaccion());

			} catch (Exception e) {
				System.out.println(e);
			}
		}

		setOnMouseClicked(event -> {
			Entidad entidad = juego.obtenerEntidadSeleccionada();
			System.out.println("Entidad");
			System.out.println(entidad);
			if(entidad != null) {
				System.out.println("Habiamos seleccionado una entidad antes");
				juego.liberarEntidadSeleccionada();
				System.out.println("Liberamos la entidad seleccionada");
				contenedorPrincipal.refrescar(entidad);
				System.out.println("Finalizamos de refrescar box derecha");
			} else {
				System.out.println("Seleccionamos la entidad tocada");
	    		try {
	    			juego.seleccionarEntidad(fila, columna);
	    			contenedorPrincipal.refrescar();
	    			System.out.println("Finalizamos de refrescar");
	    		} catch(Exception ex) {
	    			System.out.println(ex);
	    		}
			}

			//requestFocus();
		});

		backgroundProperty().bind( Bindings
            .when( focusedProperty() )
            .then( new Background( new BackgroundFill( Color.RED, CornerRadii.EMPTY, Insets.EMPTY ) ))
            .otherwise( backgroundColor  )
        );
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

	/*
	private void generarCasillero(int fila, int columna, Casillero casillero, Juego juego, Contenedor contenedor) {
		setStyle("-fx-border-color: transparent;");
		setPrefSize(tamanio, tamanio);
		this.juego = juego;
		this.fila = fila;
		this.columna = columna;
		this.contenedor = contenedor;
		this.tamanio = tamanio;
		setOnMouseClicked(new SeleccionarCasilleroHandler(juego, contenedor, fila, columna));

		Map<Class, String> vistaDict = Map.of(
			 Catapulta.class, 	"algochess.gui.vista.VistaCatapulta",
			 Jinete.class, 		"algochess.gui.vista.VistaJinete",
			 Curandero.class, 	"algochess.gui.vista.VistaCurandero",
			 Soldado.class, 	"algochess.gui.vista.VistaSoldado"
		);

		String nombreClase = vistaDict.get(casillero.getEntidad().getClass()); 
		
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
	*/
}
