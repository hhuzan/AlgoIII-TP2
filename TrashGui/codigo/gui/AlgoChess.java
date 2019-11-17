

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.paint.Color;
import org.w3c.dom.css.Rect;
import java.awt.*;
import java.util.Stack;


public class AlgoChess extends Application  {
    private static final int TAMANIO_CASILLERO = 45;
    private static final int COLUMNAS = 20;
    private static final int FILAS = 20;

    public static void main(String[] args) {
        launch(args);
    }

    /*private BorderPane crearVentanaPrincipal(){
        BorderPane panel = new BorderPane();
        /*panel.setTop(new Label("Top"));
        panel.setBottom(new Label("Bottom"));
        panel.setLeft(new Label("Left"));
        panel.setRight(new Label("Right"));
        panel.setCenter(new Label("Center"));
        return panel;
    }*/

    private GridPane crearVentaDeEntidades(){
        /*Se crea el panel de ventas y su configura el padding*/
        GridPane ventas = new GridPane();
        ventas.setPadding(new Insets(10,10,10,10));
        ventas.setVgap(20);
        ventas.setHgap(20);

        /*Se crean containers para los items*/

        Rectangle soldadoContainer = new Rectangle(TAMANIO_CASILLERO*2,TAMANIO_CASILLERO*2);
        Rectangle caballoContainer = new Rectangle(TAMANIO_CASILLERO*2,TAMANIO_CASILLERO*2);
        Rectangle curanderoContainer = new Rectangle(TAMANIO_CASILLERO*2,TAMANIO_CASILLERO*2);
        Rectangle catapultaContainer = new Rectangle(TAMANIO_CASILLERO*2,TAMANIO_CASILLERO*2);

        /* Se colocan las imagenes en los conteiners respectivos*/
        Image soldadoNeutroImg = new Image("images/SoldadoNeutro.png");
        Image caballoNeutroImg = new Image("images/CaballoNeutro.png");
        Image curanderoNeutroImg = new Image("images/CuranderoNeutro.png");
        Image catapultaNeutroImg = new Image("images/CatapultaNeutro.png");


        soldadoContainer.setFill(new ImagePattern(soldadoNeutroImg));
        caballoContainer.setFill(new ImagePattern(caballoNeutroImg));
        curanderoContainer.setFill(new ImagePattern(curanderoNeutroImg));
        catapultaContainer.setFill(new ImagePattern(catapultaNeutroImg));

        /*Se agregan los containers al panel de ventas*/

        GridPane.setConstraints(soldadoContainer,0,0);
        GridPane.setConstraints(caballoContainer,0,1);
        GridPane.setConstraints(curanderoContainer,0,2);
        GridPane.setConstraints(catapultaContainer,0,3);

        ventas.getChildren().addAll(soldadoContainer,caballoContainer,curanderoContainer,catapultaContainer);

        return ventas;
    }



    private GridPane crearTablero(){
        GridPane tablero = new GridPane();
        tablero.setPadding(new Insets(10,10,10,10));
        tablero.setVgap(2);
        tablero.setHgap(2);

        /*faccion1*/
        for(int y=0;y<FILAS/2;y++){
            for(int x = 0; x<COLUMNAS;x++){
                Casillero casillero = new Casillero(y+1,x+1,TAMANIO_CASILLERO, Color.LIGHTPINK);
                GridPane.setConstraints(casillero,x,y);
                tablero.getChildren().add(casillero);
            }
        }

        /*faccion2*/
        for(int y=FILAS/2;y<FILAS;y++){
            for(int x = 0; x<COLUMNAS;x++){
                Casillero casillero = new Casillero(y+1,x+1,TAMANIO_CASILLERO, Color.AQUAMARINE);
                GridPane.setConstraints(casillero,x,y);
                tablero.getChildren().add(casillero);
            }
        }


        return tablero;
    }

    @Override
    public void start(Stage ventana) throws Exception{

        /*Layout JUEGO*/
        BorderPane panel = new BorderPane();

        /*Layout TABLERO */
        GridPane tablero = crearTablero();
        /*Layout VENTAS DE ENTIDADES*/
        GridPane ventas = crearVentaDeEntidades();

        ventas.setAlignment(Pos.CENTER);
        panel.setLeft(ventas);
        panel.setCenter(tablero);

        /*Escena */
        Scene escena = new Scene(panel, 1600,1000);


        /* Ventana */
        ventana.setTitle("AlgoChess");
        ventana.setScene(escena);
        ventana.show();

    }






}
