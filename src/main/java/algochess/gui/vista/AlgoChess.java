package algochess.gui.vista;

import algochess.gui.controller.BotonPausarMusicaHandler;
import algochess.gui.controller.BotonPlayMusicaHandler;
import algochess.gui.controller.BotonStopMusicaHandler;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import algochess.gui.controller.BotonProximaEscenaHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;



public class AlgoChess extends Application {

    String mainTheme = "sounds/introSong.mp3";     // For example
    Media sound = new Media(getClass().getClassLoader()
            .getResource(mainTheme).toString());

    MediaPlayer mediaPlayer = new MediaPlayer(sound);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        try {


            stage.setTitle("AlgoChess - V 0.3");

            VBox welcomeContainer = new VBox(20);
            welcomeContainer.setAlignment(Pos.CENTER);

            Image logo = new Image("images/GAME_LOGO.png");
            ImageView logoView = new ImageView();
            logoView.setImage(logo);
            logoView.setFitWidth(300);
            logoView.setPreserveRatio(true);
            logoView.setSmooth(true);
            logoView.setCache(true);

            mediaPlayer.setAutoPlay(true);
            mediaPlayer.setVolume(0.5);


            Button botonEntrar = new Button();
            botonEntrar.setText("Jugar");
            
            Button botonInstrucciones = new Button();
            botonInstrucciones.setText("Instrucciones");

            Button botonSalir = new Button();
            botonSalir.setText("Salir");

            Button botonPlay = new Button();
            botonPlay.setText("Play");

            Button botonStop = new Button();
            botonStop.setText("Stop");

            Button botonPause = new Button();
            botonPause.setText("Pause");

            Scene proximaEscena = crearEscenaEleccionJugadores(stage);

            BotonProximaEscenaHandler botonEntrarHandler = new BotonProximaEscenaHandler(stage, proximaEscena);
            botonEntrar.setOnAction(botonEntrarHandler);

            BotonPlayMusicaHandler botonPlayMusicaHandler = new BotonPlayMusicaHandler(mediaPlayer);
            botonPlay.setOnAction(botonPlayMusicaHandler);

            BotonStopMusicaHandler botonStopMusicaHandler = new BotonStopMusicaHandler(mediaPlayer);
            botonStop.setOnAction(botonStopMusicaHandler);

            BotonPausarMusicaHandler botonPausarMusicaHandler = new BotonPausarMusicaHandler(mediaPlayer);
            botonPause.setOnAction(botonPausarMusicaHandler);

           welcomeContainer.getChildren().addAll(logoView, botonEntrar, botonInstrucciones, botonSalir, botonPlay, botonPause, botonStop);


    		Image fondo = new Image("images/chess.png");
    		BackgroundImage imagenDeFondo = new BackgroundImage(fondo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
    				BackgroundPosition.DEFAULT, new BackgroundSize(1, 1, true, true, false, false));
    		welcomeContainer.setBackground(new Background(imagenDeFondo));

            
            Scene escenaBienvenidos = new Scene(welcomeContainer, 1120, 660);
            stage.setScene(escenaBienvenidos);


            stage.show();




        } catch (Exception ex) {
            System.out.println(ex);
            // exceptionHandler = new ExceptionHandler();
            // exceptionHandler.manageException(ex);
        }
    }

    private Scene crearEscenaEleccionJugadores(Stage stage) {
        ContenedorJugadores contenedorJugadores = new ContenedorJugadores(stage);
        Scene escenaJugadores = new Scene(contenedorJugadores, 1120, 660);

        return escenaJugadores;
    }

}