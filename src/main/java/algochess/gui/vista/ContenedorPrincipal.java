package algochess.gui.vista;

import java.util.List;
import java.util.ArrayList;
import java.util.Observer;
import java.util.Observable;

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
import javafx.scene.control.ToggleButton;
import javafx.event.ActionEvent;
import algochess.gui.vista.VistaTablero;
import algochess.gui.controller.ComprarEntidadEventHandler;
import algochess.engine.juego.Juego;
import algochess.engine.tablero.Tablero;
import algochess.engine.jugador.Jugador;
import algochess.engine.facciones.Faccion;
import algochess.engine.entidades.Entidad;
import algochess.engine.entidades.Curandero;
import algochess.engine.entidades.Catapulta;
import algochess.engine.entidades.Soldado;
import algochess.engine.entidades.Jinete;
import algochess.engine.entidades.NulaEntidad;

public class ContenedorPrincipal extends HBox implements Observer {

    Stage stage;
    int aceptados = 0;

    public ContenedorPrincipal(Stage stage, Juego juego, Jugador aliado, Jugador enemigo, Tablero tablero) {
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
        VistaTablero tableroVista = new VistaTablero();

        compraJugadorColumnaUno.setAlignment(Pos.CENTER_LEFT);

        for(String path : imagePaths) {
            Image image = new Image(path);
            ImageView imageView = new ImageView();
            imageView.setImage(image);
            imageView.setFitWidth(100);
            imageView.setPreserveRatio(true);
            imageView.setSmooth(true);
            imageView.setCache(true);
            ToggleButton toggleButton = new ToggleButton();
            toggleButton.setGraphic(imageView);
            toggleButton.setPadding(new Insets(-1,-1,-1,-1));
            toggleButton.setOnAction((ActionEvent e) -> {
                Entidad entidad = crearEntidad(path, imagePaths);
            });
            compraJugadorColumnaUno.getChildren().add(toggleButton);
        }

        // TODO: Handlers para los casilleros con toggle selected + entidad
        crearObservadores(aliado, enemigo, tablero, this);

        compraJugadorColumnaDos.setAlignment(Pos.CENTER_RIGHT);

        compraJugadorColumnaDos.getChildren().addAll(new Button("Hola"), new Button("Chau"));

        this.getChildren().addAll(compraJugadorColumnaUno, tableroVista.getTablero(), compraJugadorColumnaDos);
    }

    public Entidad crearEntidad(String path, String[] imagePaths) {
        if(path == imagePaths[1]) { // jinete
            return new Jinete();
        } else if (path == imagePaths[2]) { // soldado
            return new Soldado();
        } else if (path == imagePaths[3]) { // curandero
            return new Curandero();
        } else if (path == imagePaths[4]) { // catapulta
            return new Catapulta();
        }

        return new NulaEntidad();
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Observing: caught something");
        System.out.println(" got " + ((Integer) arg).intValue() + "$$$$");
    }

    public void crearObservadores(Jugador aliado, Jugador enemigo, Tablero tablero, Observer observer) {
        aliado.addObserver(observer);
        enemigo.addObserver(observer);
        tablero.addObserver(observer);

    }
}