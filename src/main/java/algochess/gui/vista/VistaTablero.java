package algochess.gui.vista;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import algochess.engine.tablero.Casillero;
import algochess.engine.tablero.Tablero;
import algochess.gui.vista.VistaCasillero;

public class VistaTablero {
	private Tablero tablero;
	private GridPane paneTablero;

	public VistaTablero(Tablero tablero) {
		this.tablero = tablero;
		GridPane paneTablero = new GridPane();
		int tam_casillero = 25;
		paneTablero.setPadding(new Insets(10, 10, 10, 10));
		paneTablero.setVgap(3);
		paneTablero.setHgap(3);

		Casillero[][] casilleros = tablero.getCasilleros();

		for (int fila = 0; fila < casilleros.length; fila++)
			for (int columna = 0; columna < casilleros[fila].length; columna++) {
				{
					VistaCasillero casillero = new VistaCasillero(fila, columna, tam_casillero, casilleros[fila][columna]);
					GridPane.setConstraints(casillero, columna, fila);
					paneTablero.getChildren().add(casillero);
				}
			}

		this.paneTablero = paneTablero; // TODO ver
	}

	public GridPane getTablero() {
		return paneTablero;
	}
}