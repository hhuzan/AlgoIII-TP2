	package algochess.gui.vista;

import java.util.Map;
import java.util.HashMap;
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

public class ContenedorFinal extends VBox {

	Stage stage;

	public ContenedorFinal(Stage stage) {
		super();
		this.stage = stage;

		setAlignment(Pos.CENTER);
		setSpacing(50);

		String mainTheme = "sounds/endGameSong.mp3";
    	Media sound = new Media(getClass().getClassLoader().getResource(mainTheme).toString());

    	MediaPlayer mediaPlayer = new MediaPlayer(sound);
    	mediaPlayer.play();

		Image fondo = new Image("images/finJuego.jpg");
		BackgroundImage imagenDeFondo = new BackgroundImage(fondo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
				BackgroundPosition.DEFAULT, new BackgroundSize(1, 1, true, true, false, false));
		setBackground(new Background(imagenDeFondo));

		Label label = new Label("El juego ha terminado");
		label.setTextFill(Color.web("#ffffff"));

        Button botonSalir = new Button();
        botonSalir.setText("Salir");
        botonSalir.setOnAction((ActionEvent e) -> {
			System.exit(0);
		});

		this.getChildren().add(botonSalir);
	}
}