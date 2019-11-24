package algochess.gui.vista;

import java.util.List;
import java.util.ArrayList;

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

        String[] imagePaths = new String[] {
            "images/SHOP_ICON.png",
            "images/CaballoNeutro.png",
            "images/SoldadoNeutro.png",
            "images/CuranderoNeutro.png",
            "images/CatapultaNeutro.png"
        };

    	this.stage = stage;
        this.setAlignment(Pos.CENTER);
    	this.setSpacing(50);

        VBox compraJugadorColumnaUno = new VBox(20);
        VBox compraJugadorColumnaDos = new VBox(20);
        TableroVista tablero = new TableroVista();

        compraJugadorColumnaUno.setAlignment(Pos.CENTER_LEFT);

        for(String path : imagePaths) {
            Image image = new Image(path);
            ImageView imageView = new ImageView();
            imageView.setImage(image);
            imageView.setFitWidth(100);
            imageView.setPreserveRatio(true);
            imageView.setSmooth(true);
            imageView.setCache(true);
            Button button = new Button();
            button.setGraphic(imageView);
            button.setPadding(new Insets(-1,-1,-1,-1));
            compraJugadorColumnaUno.getChildren().add(button);
        }

        
        compraJugadorColumnaDos.setAlignment(Pos.CENTER_RIGHT);

        compraJugadorColumnaDos.getChildren().addAll(new Button("Hola"), new Button("Chau"));

        this.getChildren().addAll(compraJugadorColumnaUno, tablero.getTablero(), compraJugadorColumnaDos);
    }
}