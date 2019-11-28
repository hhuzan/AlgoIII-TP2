package algochess.gui.vista;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import algochess.gui.controller.BotonProximaEscenaHandler;

public class AlgoChess extends Application {
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

            Scene escenaBienvenidos = new Scene(welcomeContainer, 1200, 600);
            stage.setScene(escenaBienvenidos);

            stage.show();

        } catch (Exception ex) {
            // exceptionHandler = new ExceptionHandler();
            // exceptionHandler.manageException(ex);
        }
    }

    private Scene crearEscenaEleccionJugadores(Stage stage) {
        ContenedorJugadores contenedorJugadores = new ContenedorJugadores(stage);
        Scene escenaJugadores = new Scene(contenedorJugadores, 1200, 600);

        return escenaJugadores;
    }

}