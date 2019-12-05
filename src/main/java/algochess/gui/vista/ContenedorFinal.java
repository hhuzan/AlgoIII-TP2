	package algochess.gui.vista;

import java.util.Map;
import java.util.HashMap;

import algochess.gui.controller.BotonVolverHandler;
import algochess.gui.controller.MusicaOverButtonHandler;
import algochess.gui.controller.MusicaOverButtonOnMouseExited;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.media.Media;
import javafx.scene.paint.Color;
import javafx.scene.media.MediaPlayer;
import javafx.event.EventHandler;
import javafx.util.Duration;

	public class ContenedorFinal extends VBox {

	Stage stage;
	AlgoChess algoChess;

	public ContenedorFinal(Stage stage, Musica musica, AlgoChess algoChess) {
		super();
		this.stage = stage;
		this.algoChess = algoChess;


		setAlignment(Pos.CENTER);
		setSpacing(50);

		musica.reproducirSonidoAlFinalizarPartida();


		Image fondo = new Image("images/finJuego.jpg");
		BackgroundImage imagenDeFondo = new BackgroundImage(fondo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
				BackgroundPosition.DEFAULT, new BackgroundSize(1, 1, true, true, false, false));
		setBackground(new Background(imagenDeFondo));

		Label label = new Label("El juego ha terminado");
		label.setTextFill(Color.web("#ffffff"));

        Button botonSalir = new Button();
        botonSalir.setText("Salir");
        botonSalir.setOnMouseEntered(new MusicaOverButtonHandler(musica));
		botonSalir.setOnMouseExited(new MusicaOverButtonOnMouseExited(musica));
        botonSalir.setOnAction((ActionEvent e) -> {
			System.exit(0);
		});

        Button botonVolverAJugar = new Button();
        botonVolverAJugar.setText("Volver al inicio");
		botonVolverAJugar.setOnMouseEntered(new MusicaOverButtonHandler(musica));
		botonVolverAJugar.setOnMouseExited(new MusicaOverButtonOnMouseExited(musica));
        botonVolverAJugar.setOnAction(new BotonVolverHandler(algoChess));

		this.getChildren().addAll(botonSalir, botonVolverAJugar);
	}
}