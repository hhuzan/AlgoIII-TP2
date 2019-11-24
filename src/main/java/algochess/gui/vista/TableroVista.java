package algochess.gui.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import algochess.gui.controller.BotonAceptarEventHandler;
import algochess.gui.vista.CasilleroVista;

public class TableroVista {
    private GridPane tablero;

    public TableroVista() {
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
                CasilleroVista casillero = new CasilleroVista(y+1, x+1, tam_casillero, Color.LIGHTPINK);
                GridPane.setConstraints(casillero, x, y);
                tablero.getChildren().add(casillero);
            }
        }

        /*faccion2*/
        for(int y= filas/2; y < filas; y++){
            for(int x = 0; x < columnas;x++){
                CasilleroVista casillero = new CasilleroVista(y+1, x+1, tam_casillero, Color.AQUAMARINE);
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