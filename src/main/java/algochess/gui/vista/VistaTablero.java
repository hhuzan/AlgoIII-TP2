package algochess.gui.vista;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
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
		
		for (int y=0;y<casilleros.length;y++) {
			for (int x=0;x<casilleros[y].length;x++)
			{
				VistaCasillero casillero = new VistaCasillero(y + 1, x + 1, tam_casillero, casilleros[x][y]);
				GridPane.setConstraints(casillero, x, y);
				paneTablero.getChildren().add(casillero);
			}
		}
		

		this.paneTablero = paneTablero; // TODO ver
	}

	public GridPane getTablero() {
		return paneTablero;
	}
}