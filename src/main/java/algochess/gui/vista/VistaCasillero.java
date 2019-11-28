package algochess.gui.vista;

import algochess.engine.entidades.Catapulta;
import algochess.engine.entidades.Curandero;
import algochess.engine.entidades.Jinete;
import algochess.engine.entidades.Soldado;
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
	private ContenedorPrincipal contenedorPrincipal;

	VistaCasillero(int fila, int columna, int tamanio, Casillero casillero, Juego juego,
			ContenedorPrincipal contenedorPrincipal) {
		super();
		if (casillero.getFaccion().toString() == "ALIADOS")
			setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, CornerRadii.EMPTY, Insets.EMPTY)));
		else
			setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, CornerRadii.EMPTY, Insets.EMPTY)));

		setPrefSize(tamanio, tamanio);
		this.juego = juego;
		this.fila = fila;
		this.columna = columna;
		this.contenedorPrincipal = contenedorPrincipal;

		setOnMouseClicked(new SeleccionarCasilleroHandler(juego, contenedorPrincipal, fila, columna));

		//TODO refactorizar con reflexion
		if (casillero.getEstado().getEntidad() instanceof Jinete ) {
			Rectangle rectangulo = new Rectangle(tamanio, tamanio);
			Image image = new Image("images/CaballoPink.png");
			rectangulo.setFill(new ImagePattern(image));
			getChildren().add(rectangulo);
		}
		if (casillero.getEstado().getEntidad() instanceof Soldado ) {
			Rectangle rectangulo = new Rectangle(tamanio, tamanio);
			Image image = new Image("images/SoldadoPink.png");
			rectangulo.setFill(new ImagePattern(image));
			getChildren().add(rectangulo);
		}
		if (casillero.getEstado().getEntidad() instanceof Curandero ) {
			Rectangle rectangulo = new Rectangle(tamanio, tamanio);
			Image image = new Image("images/CuranderoPink.png");
			rectangulo.setFill(new ImagePattern(image));
			getChildren().add(rectangulo);
		}
		if (casillero.getEstado().getEntidad() instanceof Catapulta ) {
			Rectangle rectangulo = new Rectangle(tamanio, tamanio);
			Image image = new Image("images/CatapultaPink.png");
			rectangulo.setFill(new ImagePattern(image));
			getChildren().add(rectangulo);
		}

	}

	// --
	/*
	 * Casillero(int fila_, int columna_, int tamanio, javafx.scene.paint.Color
	 * color){ super(); fila = fila_; columna = columna_; setWidth(tamanio);
	 * setHeight(tamanio); setFill(color);
	 * 
	 * /*setOnMouseClicked(new EventHandler<MouseEvent>() {
	 * 
	 * @Override public void handle(MouseEvent mouseEvent) { (fila_+", "+columna_);
	 * Image image = new Image("sample/dog.jpg"); setFill(new ImagePattern(image));
	 * } });
	 */

	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}

}
