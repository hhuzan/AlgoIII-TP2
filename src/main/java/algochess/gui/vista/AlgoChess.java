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

    private Scene crearEscenaEleccionJugadores(Stage stage, Musica musica, AlgoChess algoChess) {
        ContenedorJugadores contenedorJugadores = new ContenedorJugadores(stage, musica, algoChess);
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

        /*mediaPlayer.setAutoPlay(true);
        mediaPlayer.setVolume(0.5);
        mediaPlayer2.setVolume(0.5);
        mediaPlayer.setCycleCount(mediaPlayer.INDEFINITE);
        mediaPlayer2.setCycleCount(mediaPlayer2.INDEFINITE);

         */
        Musica musica = new Musica();

        musica.reproducirIntro();

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

        Scene proximaEscena = crearEscenaEleccionJugadores(stage,musica, this);

        BotonProximaEscenaHandler botonEntrarHandler = new BotonProximaEscenaHandler(stage, proximaEscena);
        MusicaOverButtonHandler botonMusicaOverButton = new MusicaOverButtonHandler(musica);
        MusicaOverButtonOnMouseExited botonMusicaOverButtonOnMouseExited = new MusicaOverButtonOnMouseExited(musica);
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

        BotonPlayMusicaHandler botonPlayMusicaHandler = new BotonPlayMusicaHandler(musica);
        botonPlay.setOnAction(botonPlayMusicaHandler);
        botonPlay.setOnMouseEntered(botonMusicaOverButton);
        botonPlay.setOnMouseExited(botonMusicaOverButtonOnMouseExited);

        BotonStopMusicaHandler botonStopMusicaHandler = new BotonStopMusicaHandler(musica);
        botonStop.setOnAction(botonStopMusicaHandler);
        botonStop.setOnMouseEntered(botonMusicaOverButton);
        botonStop.setOnMouseExited(botonMusicaOverButtonOnMouseExited);

        BotonPausarMusicaHandler botonPausarMusicaHandler = new BotonPausarMusicaHandler(musica);
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