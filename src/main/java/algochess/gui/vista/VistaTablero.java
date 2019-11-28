package algochess.gui.vista;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import algochess.engine.tablero.Tablero;
import algochess.gui.vista.VistaCasillero;

public class VistaTablero {
    private GridPane paneTablero;

    public VistaTablero() {
        GridPane paneTablero = new GridPane();
        int tam_casillero = 25;
        int columnas = 20;
        int filas = 20;
        paneTablero.setPadding(new Insets(10,10,10,10));
        paneTablero.setVgap(3);
        paneTablero.setHgap(3);

        /*faccion1*/
        for(int y=0; y < filas/2 ;y++){
            for(int x = 0; x < columnas; x++){
                VistaCasillero casillero = new VistaCasillero(y+1, x+1, tam_casillero, Color.LIGHTPINK);
                GridPane.setConstraints(casillero, x, y);
                paneTablero.getChildren().add(casillero);
            }
        }

        /*faccion2*/
        for(int y= filas/2; y < filas; y++){
            for(int x = 0; x < columnas;x++){
                VistaCasillero casillero = new VistaCasillero(y+1, x+1, tam_casillero, Color.AQUAMARINE);
                GridPane.setConstraints(casillero, x, y);
                paneTablero.getChildren().add(casillero);
            }
        }

        this.paneTablero = paneTablero;
    }

    public GridPane getTablero() {
        return paneTablero;
    }
}