package algochess.gui.controller;

import algochess.engine.juego.Juego;
import algochess.gui.vista.AlgoChess;
import algochess.gui.vista.ContenedorCompras;
import algochess.gui.vista.Musica;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;


public class BotonComenzarJuegoHandler implements EventHandler<ActionEvent> {

	private Stage stage;
	private TextField nombre1;
	private TextField nombre2;
	private Musica musica;
	private AlgoChess algoChess ;


	public BotonComenzarJuegoHandler(Stage stage, TextField nombreJugador_1, TextField nombreJugador_2, Musica musica, AlgoChess algoChess) {
		this.stage = stage;
		this.nombre1 = nombreJugador_1;
		this.nombre2 = nombreJugador_2;
		this.musica = musica;
		this.algoChess = algoChess;

	}

	@Override
	public void handle(ActionEvent actionEvent) {

		musica.pararIntro();
		musica.reproducirMusicaBatalla();
		Juego juego = new Juego(nombre1.getText(), nombre2.getText());
		ContenedorCompras contenedorCompras = new ContenedorCompras(stage, juego, musica, algoChess);
		Scene escenaPrincipal = new Scene(contenedorCompras, 1120, 660);

		stage.setScene(escenaPrincipal);
	}
}