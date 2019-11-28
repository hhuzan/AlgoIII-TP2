package algochess.gui.vista;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import algochess.gui.controller.BotonComenzarJuegoHandler;

public class ContenedorJugadores extends VBox {
//	Juego juego;
	private Stage stage;

	public ContenedorJugadores(Stage stage) {

		super();

		this.stage = stage;
		this.setAlignment(Pos.CENTER);
		this.setSpacing(50);

		HBox jugadorContainer = new HBox(20);
		jugadorContainer.setAlignment(Pos.CENTER);

		VBox jugadorUnoContainer = new VBox(20);
		VBox jugadorDosContainer = new VBox(20);
		jugadorUnoContainer.setAlignment(Pos.CENTER);
		jugadorDosContainer.setAlignment(Pos.CENTER);

		Image jugadorUnoBackground = new Image("images/BACKGROUND_PLAYER_PINK_CHOOSE_NAME.png");
		ImageView jugadorUnoBackgroundView = new ImageView();
		jugadorUnoBackgroundView.setImage(jugadorUnoBackground);
		jugadorUnoBackgroundView.setFitWidth(100);
		jugadorUnoBackgroundView.setPreserveRatio(true);
		jugadorUnoBackgroundView.setSmooth(true);
		jugadorUnoBackgroundView.setCache(true);

		Image jugadorDosBackground = new Image("images/BACKGROUND_PLAYER_BLUE_CHOOSE_NAME.png");
		ImageView jugadorDosBackgroundView = new ImageView();
		jugadorDosBackgroundView.setImage(jugadorDosBackground);
		jugadorDosBackgroundView.setFitWidth(100);
		jugadorDosBackgroundView.setPreserveRatio(true);
		jugadorDosBackgroundView.setSmooth(true);
		jugadorDosBackgroundView.setCache(true);

		TextField nombreJugador_1 = new TextField("Jugador 1");
		TextField nombreJugador_2 = new TextField("Jugador 2");

		Button botonAceptar = new Button();
		botonAceptar.setText("Aceptar");


		BotonComenzarJuegoHandler botonAceptarHandler = new BotonComenzarJuegoHandler(stage,
				nombreJugador_1, nombreJugador_2);
		botonAceptar.setOnAction(botonAceptarHandler);

		jugadorUnoContainer.getChildren().addAll(jugadorUnoBackgroundView, nombreJugador_1);
		jugadorDosContainer.getChildren().addAll(jugadorDosBackgroundView, nombreJugador_2);

		jugadorContainer.getChildren().addAll(jugadorUnoContainer, jugadorDosContainer);

		this.getChildren().addAll(jugadorContainer, botonAceptar);
		Image fondo = new Image("images/chess.png");
		BackgroundImage imagenDeFondo = new BackgroundImage(fondo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
				BackgroundPosition.DEFAULT, new BackgroundSize(1, 1, true, true, false, false));
		setBackground(new Background(imagenDeFondo));

	}
}