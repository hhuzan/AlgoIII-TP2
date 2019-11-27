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
import algochess.gui.Casillero;
import algochess.engine.juego.Juego;


public class AlgoChess extends Application  {
    private static final int TAMANIO_CASILLERO = 25;
    private static final int COLUMNAS = 20;
    private static final int FILAS = 20;

    public static void main(String[] args) {
        launch(args);
    }

    /*private BorderPane crearVentanaPrincipal(){
        BorderPane panel = new BorderPane();
        panel.setTop(new Label("Top"));
        panel.setBottom(new Label(  "Bottom"));
        panel.setLeft(new Label("Left"));
        panel.setRight(new Label("Right"));
        panel.setCenter(new Label("Center"));
        return panel;
    }*/

    private GridPane crearVentaDeEntidades(){

        GridPane ventas = new GridPane();
        ventas.setPadding(new Insets(10,10,10,10));
        ventas.setVgap(20);
        ventas.setHgap(20);

        Rectangle soldadoContainer = new Rectangle(TAMANIO_CASILLERO*2,TAMANIO_CASILLERO*2);
        Rectangle caballoContainer = new Rectangle(TAMANIO_CASILLERO*2,TAMANIO_CASILLERO*2);
        Rectangle curanderoContainer = new Rectangle(TAMANIO_CASILLERO*2,TAMANIO_CASILLERO*2);
        Rectangle catapultaContainer = new Rectangle(TAMANIO_CASILLERO*2,TAMANIO_CASILLERO*2);

        Image soldadoNeutroImg = new Image("images/SoldadoNeutro.png");
        Image caballoNeutroImg = new Image("images/CaballoNeutro.png");
        Image curanderoNeutroImg = new Image("images/CuranderoNeutro.png");
        Image catapultaNeutroImg = new Image("images/CatapultaNeutro.png");

        soldadoContainer.setFill(new ImagePattern(soldadoNeutroImg));
        caballoContainer.setFill(new ImagePattern(caballoNeutroImg));
        curanderoContainer.setFill(new ImagePattern(curanderoNeutroImg));
        catapultaContainer.setFill(new ImagePattern(catapultaNeutroImg));

        GridPane.setConstraints(soldadoContainer,0,0);
        GridPane.setConstraints(caballoContainer,0,1);
        GridPane.setConstraints(curanderoContainer,0,2);
        GridPane.setConstraints(catapultaContainer,0,3);

        ventas.getChildren().addAll(soldadoContainer,caballoContainer,curanderoContainer,catapultaContainer);

        return ventas;
    }

    @Override
    public void start(Stage stage) {

        Juego juego = new Juego();

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

        Scene proximaEscena = crearEscenaEleccionJugadores(stage, juego);

        BotonProximaEscenaHandler botonEntrarHandler = new BotonProximaEscenaHandler(stage, proximaEscena);
        botonEntrar.setOnAction(botonEntrarHandler);

        welcomeContainer.getChildren().addAll(logoView, botonEntrar, botonInstrucciones, botonSalir);

        Scene escenaBienvenidos = new Scene(welcomeContainer, 1280, 720);
        stage.setScene(escenaBienvenidos);

        stage.show();
    }

    private Scene crearEscenaEleccionJugadores(Stage stage, Juego juego) {
        ContenedorJugadores contenedorJugadores = new ContenedorJugadores(stage, juego);
        Scene escenaJugadores = new Scene(contenedorJugadores, 1280, 720);

        return escenaJugadores;
    }

}
