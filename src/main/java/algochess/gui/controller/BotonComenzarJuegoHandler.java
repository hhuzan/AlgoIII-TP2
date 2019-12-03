package algochess.gui.controller;

import algochess.engine.juego.Juego;
import algochess.gui.vista.ContenedorCompras;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.scene.media.Media;


public class BotonComenzarJuegoHandler implements EventHandler<ActionEvent> {

	private Stage stage;
	private TextField nombre1;
	private TextField nombre2;

	MediaPlayer mediaPlayer;
	MediaPlayer mediaPlayer2;

	public BotonComenzarJuegoHandler(Stage stage, TextField nombreJugador_1, TextField nombreJugador_2, MediaPlayer mediaPlayer, MediaPlayer mediaplayer2) {
		this.stage = stage;
		this.nombre1 = nombreJugador_1;
		this.nombre2 = nombreJugador_2;
		this.mediaPlayer = mediaPlayer;
		this.mediaPlayer2 = mediaplayer2;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		mediaPlayer.stop();
		mediaPlayer2.play();
		Juego juego = new Juego(nombre1.getText(), nombre2.getText());
		ContenedorCompras contenedorCompras = new ContenedorCompras(stage, juego);
		Scene escenaPrincipal = new Scene(contenedorCompras, 1120, 660);

		stage.setScene(escenaPrincipal);
	}
}