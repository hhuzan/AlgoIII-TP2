package algochess.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import algochess.gui.controller.BotonEntrarEventHandler;

public class ContenedorBienvenidos extends VBox {

    Stage stage;

    public ContenedorBienvenidos(Stage stage) {

    	super();

    	this.stage = stage;
    	this.setAlignment(Pos.CENTER);
    	this.setSpacing(20);

        Image logo = new Image("images/GAME_LOGO.png");
        ImageView logoView = new ImageView();
        logoView.setImage(logo);
        logoView.setFitWidth(300);
        logoView.setPreserveRatio(true);
        logoView.setSmooth(true);
        logoView.setCache(true);

    	Button botonEntrar = new Button();
        botonEntrar.setText("Jugar");
    	
    	Button botonInstrucciones = new Button();
        botonInstrucciones.setText("Instrucciones");

        Button botonOtraCosa = new Button();
        botonOtraCosa.setText("Otra cosa");

        Scene proximaEscena = crearEscenaEleccionJugadores(stage);

        BotonEntrarEventHandler botonEntrarHandler = new BotonEntrarEventHandler(stage, proximaEscena);
        botonEntrar.setOnAction(botonEntrarHandler);

        this.getChildren().addAll(logoView, botonEntrar, botonInstrucciones, botonOtraCosa);
    }

    private Scene crearEscenaEleccionJugadores(Stage stage) {
        ContenedorJugadores contenedorJugadores = new ContenedorJugadores(stage);
        Scene escenaJugadores = new Scene(contenedorJugadores, 640, 480);

        return escenaJugadores;
    }
}