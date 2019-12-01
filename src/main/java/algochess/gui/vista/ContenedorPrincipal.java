package algochess.gui.vista;

import java.util.Map;
import java.util.HashMap;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.event.ActionEvent;
import algochess.gui.vista.VistaTablero;
import algochess.engine.facciones.Faccion;
import algochess.engine.juego.Juego;
import algochess.engine.entidades.Entidad;
import algochess.engine.entidades.Jinete;
import algochess.engine.entidades.Catapulta;
import algochess.engine.entidades.Curandero;
import algochess.engine.entidades.Soldado;
import algochess.gui.controller.AtacarCasilleroHandler;
import algochess.gui.controller.CurarCasilleroHandler;
import algochess.gui.controller.MoverCasilleroHandler;
import javafx.event.EventHandler;

public class ContenedorPrincipal extends HBox {

	private String colorAliados = "LIGHTPINK";
	private String colorEnemigos = "AQUAMARINE";
	private Stage stage;
	private Juego juego;
	private VBox boxIzquierdo;
	private VBox boxDerecho;
	private HashMap<Faccion, String> colorFaccion = new HashMap<Faccion, String>();
	private int filaOrigen;
	private int filaDestino;
	private int columnaOrigen;
	private int columnaDestino;		

	public ContenedorPrincipal(Stage stage, Juego juego) {
		super();
		this.stage = stage;
		this.juego = juego;
		colorFaccion.put(Faccion.ALIADOS, colorAliados);
		colorFaccion.put(Faccion.ENEMIGOS, colorEnemigos);

		setAlignment(Pos.CENTER);
		setSpacing(50);
		refrescar();
		
		Image fondo = new Image("images/Mono2.jpg");
		BackgroundImage imagenDeFondo = new BackgroundImage(fondo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
				BackgroundPosition.DEFAULT, new BackgroundSize(1, 1, true, true, false, false));
		setBackground(new Background(imagenDeFondo));
	}

	public void refrescar(int fila, int columna) {
		this.filaOrigen = fila;
		this.columnaOrigen = columna;
		this.getChildren().clear();
		armarColumnaIzquierda();
		armarColumnaDerecha();
		VistaTablero tableroVista = new VistaTablero(juego, this);
		this.getChildren().addAll(boxIzquierdo, tableroVista.getPaneTablero(), boxDerecho);		
	}

	public void refrescar() {
		this.getChildren().clear();
		armarColumnaIzquierda();
		armarColumnaDerecha();
		VistaTablero tableroVista = new VistaTablero(juego, this);
		this.getChildren().addAll(boxIzquierdo, tableroVista.getPaneTablero(), boxDerecho);		
	}

	public void refrescar(Entidad entidad, int fila, int columna) {
		this.filaDestino = fila;
		this.columnaDestino = columna;
		Map<Class, String[]> optionDict = Map.of(
			 Catapulta.class, 	new String[]{"Atacar"},
			 Jinete.class, 		new String[]{"Atacar", "Mover"},
			 Curandero.class, 	new String[]{"Curar", "Mover"},
			 Soldado.class, 	new String[]{"Atacar", "Mover"}
		);

		String[] options = optionDict.get(entidad.getClass());
		this.getChildren().clear();
		armarColumnaIzquierda();
		armarColumnaDerecha(options);
		VistaTablero tableroVista = new VistaTablero(juego, this);
		this.getChildren().addAll(boxIzquierdo, tableroVista.getPaneTablero(), boxDerecho);		
	}

	private void armarColumnaDerecha() {
		boxDerecho = new VBox(30);
		boxDerecho.setAlignment(Pos.CENTER);
		
		// TODO: Ver de gettear entidades y cantidad de entidades para mostrar

		boxDerecho.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 8;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 8;" + "-fx-border-color: " + 
				colorFaccion.get(juego.getFaccionActual()) + ";");

	}

	private void armarColumnaDerecha(String[] options) {
		boxDerecho = new VBox(30);
		boxDerecho.setAlignment(Pos.CENTER);

		Map<String, EventHandler<ActionEvent>> optionDict = Map.of(
			 "Atacar", 	new AtacarCasilleroHandler(this, juego, filaOrigen, columnaOrigen, filaDestino, columnaDestino),
			 "Mover", 	new MoverCasilleroHandler(juego, filaOrigen, columnaOrigen, filaDestino, columnaDestino),
			 "Curar",	new CurarCasilleroHandler(juego, filaOrigen, columnaOrigen, filaDestino, columnaDestino)
		);	


		for (String option : options) {
			Button button = new Button(option);
			button.setOnAction(optionDict.get(option));
			boxDerecho.getChildren().add(button);	
		}

		boxDerecho.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 8;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 8;" + "-fx-border-color: " + 
				colorFaccion.get(juego.getFaccionActual()) + ";");


	}

	private void armarColumnaIzquierda() {
		boxIzquierdo = new VBox(12);
		boxIzquierdo.setAlignment(Pos.CENTER);

		boxIzquierdo.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 8;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 8;" + "-fx-border-color: " + 
				colorFaccion.get(juego.getFaccionActual()) + ";");

		Button btnPasar = new Button();

		btnPasar.setText("Pasar Turno");
		btnPasar.setOnAction((ActionEvent e) -> {
			boolean finished = juego.cambiarTurno();
			if(finished) {
				System.out.println("Termina el juego");
			}

			refrescar();
		});
		
		boxIzquierdo.getChildren().add(btnPasar);

	}
}