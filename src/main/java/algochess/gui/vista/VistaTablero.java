package algochess.gui.vista;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import algochess.engine.juego.Juego;
import algochess.engine.tablero.Casillero;
import algochess.gui.vista.VistaCasillero;

public class VistaTablero {
//	private Juego juego;
	private GridPane paneTablero;

	
	public VistaTablero(Juego juego, ContenedorPrincipal contenedorPrincipal) {
//		this.juego = juego;
		
		GridPane paneTablero = new GridPane();
		int tam_casillero = 25;
		paneTablero.setPadding(new Insets(10, 10, 10, 10));
		paneTablero.setVgap(3);
		paneTablero.setHgap(3);

		Casillero[][] casilleros = juego.getTablero().getCasilleros();

		for (int fila = 0; fila < casilleros.length; fila++)
			for (int columna = 0; columna < casilleros[fila].length; columna++) {
				{
					VistaCasillero casillero = new VistaCasillero(fila, columna, tam_casillero,
							casilleros[fila][columna], juego, contenedorPrincipal);
					GridPane.setConstraints(casillero, columna, fila);
					paneTablero.getChildren().add(casillero);
				}
			}

		this.paneTablero = paneTablero; // TODO ver
	}

	public GridPane getPaneTablero() {
		return paneTablero;
	}
}