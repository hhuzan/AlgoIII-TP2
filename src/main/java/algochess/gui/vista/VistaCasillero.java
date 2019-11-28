package algochess.gui.vista;

import algochess.engine.tablero.Casillero;
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

	VistaCasillero(int fila_, int columna_, int tamanio, Casillero casillero) {
		super();
		if (casillero.getFaccion().toString() == "ALIADOS")
			setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, CornerRadii.EMPTY, Insets.EMPTY)));
		else
			setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, CornerRadii.EMPTY, Insets.EMPTY)));

		setPrefSize(tamanio, tamanio);
		fila = fila_;
		columna = columna_;

		setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				Rectangle rectangulo = new Rectangle(tamanio, tamanio);
				Image image = new Image("images/CaballoPink.png");
				rectangulo.setFill(new ImagePattern(image));
				getChildren().add(rectangulo);
			}
		});

	}

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
