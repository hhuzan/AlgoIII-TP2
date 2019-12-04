package algochess.gui.vista;


import algochess.gui.controller.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;



public class AlgoChess extends Application {

    String mainTheme = "sounds/introSong.mp3";
    Media sound = new Media(getClass().getClassLoader().getResource(mainTheme).toString());

    String playTheme = "sounds/15_crytalscar_phase2_loop.wav";
    Media soundPlay = new Media(getClass().getClassLoader().getResource(playTheme).toString());

    String soundOnMouseEntered = "sounds/68_ui-generic_button_01.wav";
    Media soundPlayOnMouseEntered = new Media(getClass().getClassLoader().getResource(soundOnMouseEntered).toString());

    MediaPlayer mediaPlayerOnButton = new MediaPlayer(soundPlayOnMouseEntered);

    MediaPlayer mediaPlayer2 = new MediaPlayer(soundPlay);

    MediaPlayer mediaPlayer = new MediaPlayer(sound);

    private Stage stage;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        try {

            this.stage = stage;
            crearEscenaBienvenidos();
            stage.show();


        } catch (Exception ex) {
            System.out.println(ex);
            // exceptionHandler = new ExceptionHandler();
            // exceptionHandler.manageException(ex);
        }
    }

    private Scene crearEscenaEleccionJugadores(Stage stage, MediaPlayer mediaPlayer, MediaPlayer mediaPlayer2, AlgoChess algoChess) {
        ContenedorJugadores contenedorJugadores = new ContenedorJugadores(stage, mediaPlayer, mediaPlayer2, algoChess);
        Scene escenaJugadores = new Scene(contenedorJugadores, 1120, 660);

        return escenaJugadores;
    }

    public void crearEscenaBienvenidos(){

        VBox welcomeContainer = new VBox(20);
        HBox musicContainter = new HBox(20);
        welcomeContainer.setAlignment(Pos.CENTER);
        musicContainter.setAlignment(Pos.BOTTOM_CENTER);

        Image logo = new Image("images/GAME_LOGO.png");
        ImageView logoView = new ImageView();
        logoView.setImage(logo);
        logoView.setFitWidth(300);
        logoView.setPreserveRatio(true);
        logoView.setSmooth(true);
        logoView.setCache(true);

        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setVolume(0.5);
        mediaPlayer2.setVolume(0.5);
        mediaPlayer.setCycleCount(mediaPlayer.INDEFINITE);
        mediaPlayer2.setCycleCount(mediaPlayer2.INDEFINITE);

        Button botonEntrar = new Button();
        botonEntrar.setText("Jugar");

        Button botonInstrucciones = new Button();
        botonInstrucciones.setText("Instrucciones");

        Button botonSalir = new Button();
        botonSalir.setText("Salir");

        Button botonPlay = new Button();
        botonPlay.setText("Reanudar musica");

        Button botonStop = new Button();
        botonStop.setText("Parar musica");

        Button botonPause = new Button();
        botonPause.setText("Pausar musica");

        Scene proximaEscena = crearEscenaEleccionJugadores(stage, mediaPlayer, mediaPlayer2, this);

        BotonProximaEscenaHandler botonEntrarHandler = new BotonProximaEscenaHandler(stage, proximaEscena);
        MusicaOverButtonHandler botonMusicaOverButton = new MusicaOverButtonHandler(mediaPlayerOnButton);
        MusicaOverButtonOnMouseExited botonMusicaOverButtonOnMouseExited = new MusicaOverButtonOnMouseExited(mediaPlayerOnButton);
        BotonInstruccionesHandler botonInstruccionesHandler = new BotonInstruccionesHandler();

        botonInstrucciones.setOnMouseEntered(botonMusicaOverButton);
        botonInstrucciones.setOnMouseExited(botonMusicaOverButtonOnMouseExited);
        botonInstrucciones.setOnAction(botonInstruccionesHandler);

        botonSalir.setOnAction(new BotonSalirHandler());
        botonSalir.setOnMouseEntered(botonMusicaOverButton);
        botonSalir.setOnMouseExited(botonMusicaOverButtonOnMouseExited);

        botonEntrar.setOnAction(botonEntrarHandler);
        botonEntrar.setOnMouseEntered(botonMusicaOverButton);
        botonEntrar.setOnMouseExited(botonMusicaOverButtonOnMouseExited);

        BotonPlayMusicaHandler botonPlayMusicaHandler = new BotonPlayMusicaHandler(mediaPlayer);
        botonPlay.setOnAction(botonPlayMusicaHandler);
        botonPlay.setOnMouseEntered(botonMusicaOverButton);
        botonPlay.setOnMouseExited(botonMusicaOverButtonOnMouseExited);

        BotonStopMusicaHandler botonStopMusicaHandler = new BotonStopMusicaHandler(mediaPlayer);
        botonStop.setOnAction(botonStopMusicaHandler);
        botonStop.setOnMouseEntered(botonMusicaOverButton);
        botonStop.setOnMouseExited(botonMusicaOverButtonOnMouseExited);

        BotonPausarMusicaHandler botonPausarMusicaHandler = new BotonPausarMusicaHandler(mediaPlayer);
        botonPause.setOnAction(botonPausarMusicaHandler);
        botonPause.setOnMouseEntered(botonMusicaOverButton);
        botonPause.setOnMouseExited(botonMusicaOverButtonOnMouseExited);

        Image fondo = new Image("images/chess.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(fondo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT, new BackgroundSize(1, 1, true, true, false, false));

        musicContainter.getChildren().addAll(botonPlay, botonPause, botonStop);
        welcomeContainer.getChildren().addAll(logoView, botonEntrar, botonInstrucciones, botonSalir, musicContainter);

        welcomeContainer.setBackground(new Background(imagenDeFondo));

        Scene escenaBienvenidos = new Scene(welcomeContainer, 1120, 660);

       this.stage.setScene(escenaBienvenidos);
    }


}