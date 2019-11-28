package algochess.gui.vista;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import algochess.gui.controller.BotonComenzarJuegoHandler;
import algochess.engine.juego.Juego;

public class ContenedorJugadores extends VBox {
//	Juego juego;
	Stage stage;
	int aceptados = 0;

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

		Image jugadorUnoBackground = new Image("images/BACKGROUND_PLAYER_BLUE_CHOOSE_NAME.png");
		ImageView jugadorUnoBackgroundView = new ImageView();
		jugadorUnoBackgroundView.setImage(jugadorUnoBackground);
		jugadorUnoBackgroundView.setFitWidth(100);
		jugadorUnoBackgroundView.setPreserveRatio(true);
		jugadorUnoBackgroundView.setSmooth(true);
		jugadorUnoBackgroundView.setCache(true);

		Image jugadorDosBackground = new Image("images/BACKGROUND_PLAYER_PINK_CHOOSE_NAME.png");
		ImageView jugadorDosBackgroundView = new ImageView();
		jugadorDosBackgroundView.setImage(jugadorDosBackground);
		jugadorDosBackgroundView.setFitWidth(100);
		jugadorDosBackgroundView.setPreserveRatio(true);
		jugadorDosBackgroundView.setSmooth(true);
		jugadorDosBackgroundView.setCache(true);

		TextField nombreJugador_1 = new TextField("Nombre jugador");
		TextField nombreJugador_2 = new TextField("Nombre jugador");

		Button botonAceptar = new Button();
		botonAceptar.setText("Aceptar");


		BotonComenzarJuegoHandler botonAceptarHandler = new BotonComenzarJuegoHandler(stage,
				nombreJugador_1, nombreJugador_2);
		botonAceptar.setOnAction(botonAceptarHandler);

		jugadorUnoContainer.getChildren().addAll(jugadorUnoBackgroundView, nombreJugador_1);
		jugadorDosContainer.getChildren().addAll(jugadorDosBackgroundView, nombreJugador_2);

		jugadorContainer.getChildren().addAll(jugadorUnoContainer, jugadorDosContainer);

		this.getChildren().addAll(jugadorContainer, botonAceptar);
	}
}