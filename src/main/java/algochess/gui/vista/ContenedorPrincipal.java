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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import algochess.gui.vista.TableroVista;

import algochess.gui.controller.BotonAceptarEventHandler;

public class ContenedorPrincipal extends HBox {

    Stage stage;
    int aceptados = 0;

    public ContenedorPrincipal(Stage stage) {

    	super();

    	this.stage = stage;
        this.setAlignment(Pos.CENTER);
    	this.setSpacing(50);

        VBox compraJugadorUno = new VBox(20);
        VBox compraJugadorDos = new VBox(20);
        TableroVista tablero = new TableroVista();

        compraJugadorUno.setAlignment(Pos.CENTER_LEFT);
        compraJugadorDos.setAlignment(Pos.CENTER_RIGHT);


        compraJugadorUno.getChildren().addAll(new Button("Hola"), new Button("Chau"));
        compraJugadorDos.getChildren().addAll(new Button("Hola"), new Button("Chau"));

        this.getChildren().addAll(compraJugadorUno, tablero.getTablero(), compraJugadorDos);
    }
}