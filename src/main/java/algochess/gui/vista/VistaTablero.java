package algochess.gui.vista;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import algochess.engine.tablero.Tablero;
import algochess.gui.vista.VistaCasillero;

public class VistaTablero {
    private GridPane tablero;

    public VistaTablero() {
        GridPane tablero = new GridPane();
        int tam_casillero = 25;
        int columnas = 20;
        int filas = 20;
        tablero.setPadding(new Insets(10,10,10,10));
        tablero.setVgap(3);
        tablero.setHgap(3);

        /*faccion1*/
        for(int y=0; y < filas/2 ;y++){
            for(int x = 0; x < columnas; x++){
                VistaCasillero casillero = new VistaCasillero(y+1, x+1, tam_casillero, Color.LIGHTPINK);
                GridPane.setConstraints(casillero, x, y);
                tablero.getChildren().add(casillero);
            }
        }

        /*faccion2*/
        for(int y= filas/2; y < filas; y++){
            for(int x = 0; x < columnas;x++){
                VistaCasillero casillero = new VistaCasillero(y+1, x+1, tam_casillero, Color.AQUAMARINE);
                GridPane.setConstraints(casillero, x, y);
                tablero.getChildren().add(casillero);
            }
        }

        this.tablero = tablero;
    }

    public GridPane getTablero() {
        return tablero;
    }
}