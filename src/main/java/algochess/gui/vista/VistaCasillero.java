package algochess.gui.vista;

import algochess.engine.entidades.Catapulta;
import algochess.engine.entidades.Curandero;
import algochess.engine.entidades.Jinete;
import algochess.engine.entidades.Soldado;
import algochess.engine.facciones.Faccion;
import algochess.engine.juego.Juego;
import algochess.engine.tablero.Casillero;
import algochess.engine.tablero.Ocupado;
import algochess.gui.controller.SeleccionarCasilleroHandler;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

public class VistaCasillero extends StackPane {
	private final int fila;
	private final int columna;
	private Juego juego;
	private ContenedorCompras contenedorCompras;

	VistaCasillero(int fila, int columna, int tamanio, Casillero casillero, Juego juego,
			ContenedorCompras contenedorCompras) {
		super();
		if (casillero.getFaccion().toString() == "ALIADOS")
			setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, CornerRadii.EMPTY, Insets.EMPTY)));
		else
			setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, CornerRadii.EMPTY, Insets.EMPTY)));

		setPrefSize(tamanio, tamanio);
		this.juego = juego;
		this.fila = fila;
		this.columna = columna;
		this.contenedorCompras = contenedorCompras;

		setOnMouseClicked(new SeleccionarCasilleroHandler(juego, contenedorCompras, fila, columna));

		// TODO refactorizar con reflexion
		Image image = null;

		Rectangle rectangulo = new Rectangle(tamanio, tamanio);
		if (casillero.getEstado().getEntidad() instanceof Jinete) {
			if (casillero.getEstado().getEntidad().getPropietario().getFaccion() == Faccion.ALIADOS)
				image = new Image("images/CaballoPink.png");
			else
				image = new Image("images/CaballoBlue.png");
		}
		if (casillero.getEstado().getEntidad() instanceof Soldado) {
			if (casillero.getEstado().getEntidad().getPropietario().getFaccion() == Faccion.ALIADOS)
				image = new Image("images/SoldadoPink.png");
			else
				image = new Image("images/SoldadoBlue.png");
		}
		if (casillero.getEstado().getEntidad() instanceof Curandero) {
			if (casillero.getEstado().getEntidad().getPropietario().getFaccion() == Faccion.ALIADOS)
				image = new Image("images/CuranderoPink.png");
			else
				image = new Image("images/CuranderoBlue.png");
		}
		if (casillero.getEstado().getEntidad() instanceof Catapulta) {
			if (casillero.getEstado().getEntidad().getPropietario().getFaccion() == Faccion.ALIADOS)
				image = new Image("images/CatapultaPink.png");
			else
				image = new Image("images/CatapultaBlue.png");
		}
		if (image != null) {
			rectangulo.setFill(new ImagePattern(image));
			getChildren().add(rectangulo);
		}

	}

	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}

}
