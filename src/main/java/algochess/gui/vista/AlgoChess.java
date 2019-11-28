package algochess.gui.vista;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Color;
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
import algochess.gui.controller.BotonProximaEscenaHandler;
import algochess.gui.vista.VistaCasillero;
import algochess.engine.juego.Juego;
import algochess.engine.jugador.Jugador;
import algochess.engine.tablero.Tablero;
import algochess.excepciones.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import algochess.gui.ExceptionHandler;

public class AlgoChess extends Application {
    private static final int TAMANIO_CASILLERO = 25;
    private static final int COLUMNAS = 20;
    private static final int FILAS = 20;
    private ExceptionHandler exceptionHandler;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        try {
            stage.setTitle("AlgoChess - V 1.0");

            VBox welcomeContainer = new VBox(20);
            welcomeContainer.setAlignment(Pos.CENTER);

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

            Button botonSalir = new Button();
            botonSalir.setText("Salir");

            Scene proximaEscena = crearEscenaEleccionJugadores(stage);

            BotonProximaEscenaHandler botonEntrarHandler = new BotonProximaEscenaHandler(stage, proximaEscena);
            botonEntrar.setOnAction(botonEntrarHandler);

            welcomeContainer.getChildren().addAll(logoView, botonEntrar, botonInstrucciones, botonSalir);

            Scene escenaBienvenidos = new Scene(welcomeContainer, 1280, 720);
            stage.setScene(escenaBienvenidos);

            stage.show();

        } catch (Exception ex) {
            // exceptionHandler = new ExceptionHandler();
            // exceptionHandler.manageException(ex);
        }
    }

    private Scene crearEscenaEleccionJugadores(Stage stage) {
        ContenedorJugadores contenedorJugadores = new ContenedorJugadores(stage);
        Scene escenaJugadores = new Scene(contenedorJugadores, 1280, 720);

        return escenaJugadores;
    }

}