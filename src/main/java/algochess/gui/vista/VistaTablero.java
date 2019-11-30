package algochess.gui.vista;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import algochess.engine.facciones.Faccion;
import algochess.engine.juego.Juego;
import algochess.engine.tablero.Casillero;
import algochess.gui.vista.VistaCasillero;

public class VistaTablero {
	private GridPane paneTablero;

	public VistaTablero(Juego juego, ContenedorCompras contenedorPrincipal) {

		GridPane paneTablero = new GridPane();
		int tam_casillero = 25;
		paneTablero.setPadding(new Insets(10, 10, 10, 10));
		paneTablero.setVgap(3);
		paneTablero.setHgap(3);

		Casillero[][] casilleros = juego.getTablero().getCasilleros();
		String color;

		for (int fila = 0; fila < casilleros.length; fila++)
			for (int columna = 0; columna < casilleros[fila].length ; columna++) {
				{
					VistaCasillero casillero = new VistaCasillero(fila, columna, tam_casillero,
							casilleros[fila][columna], juego, contenedorPrincipal);
					GridPane.setConstraints(casillero, columna, fila);
					paneTablero.getChildren().add(casillero);

					color = fila < (casilleros.length / 2) ? "LIGHTPINK" : "AQUAMARINE";
					paneTablero.setStyle(	"-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 8;"
					+ "-fx-border-insets: 5;" + "-fx-border-radius: 8;" + "-fx-border-color: " + color + ";");
				}
			}
		this.paneTablero = paneTablero;
	}

	public GridPane getPaneTablero() {
		return paneTablero;
	}
}