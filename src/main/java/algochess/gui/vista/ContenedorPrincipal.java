package algochess.gui.vista;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.util.Map;
import java.util.HashMap;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.Scene;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import algochess.engine.facciones.Faccion;
import algochess.engine.juego.Juego;
import algochess.engine.entidades.Entidad;
import algochess.engine.entidades.Jinete;
import algochess.engine.entidades.Catapulta;
import algochess.engine.entidades.Curandero;
import algochess.engine.entidades.Soldado;
import algochess.engine.jugador.Jugador;
import algochess.gui.controller.AtacarCasilleroHandler;
import algochess.gui.controller.CurarCasilleroHandler;
import algochess.gui.controller.MoverCasilleroHandler;
import javafx.event.EventHandler;
import java.lang.reflect.Field;
import java.util.List;
import java.util.ArrayList;
import javafx.scene.control.*;

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
	private Musica musica;
	private AlgoChess algoChess;

	public ContenedorPrincipal(Stage stage, Juego juego, Musica musica, AlgoChess algoChess) {
		super();
		this.stage = stage;
		this.juego = juego;
		this.musica = musica;
		this.algoChess = algoChess;
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

	public void datosEntidad(Entidad entidad, int fila, int columna) {
		this.filaOrigen = fila;
		this.columnaOrigen = columna;
		this.getChildren().clear();
		armarColumnaIzquierda(entidad);
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

	public void finalizarJuego(Jugador jugadorPerdedor) {
		Alert alert = new Alert(Alert.AlertType.WARNING, 
								"El jugador: " + jugadorPerdedor.getNombre() + " ha perdido la partida",
								ButtonType.OK);
        String title = "El juego ha terminado";
        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.showAndWait();
		
		musica.pararMusicaBatalla();
        ContenedorFinal contenedorFinal = new ContenedorFinal(stage, musica, algoChess);
		Scene escenaFinal = new Scene(contenedorFinal, 1120, 660);

		stage.setScene(escenaFinal);
	}
	
	private void armarColumnaDerecha() {
		boxDerecho = new VBox(30);
		boxDerecho.setAlignment(Pos.CENTER);
		
		// TODO: Ver de gettear entidades y cantidad de entidades para mostrar

		boxDerecho.setStyle("-fx-min-width: 150px; -fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 8;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 8;" + "-fx-border-color: " + 
				colorFaccion.get(juego.getFaccionActual()) + ";");

	}

	private void armarColumnaDerecha(String[] options) {
		boxDerecho = new VBox(30);
		boxDerecho.setAlignment(Pos.CENTER);

		Map<String, EventHandler<ActionEvent>> optionDict = Map.of(
			 "Atacar", 	new AtacarCasilleroHandler(this, juego, filaOrigen, columnaOrigen, filaDestino, columnaDestino),
			 "Mover", 	new MoverCasilleroHandler(this, juego, filaOrigen, columnaOrigen, filaDestino, columnaDestino),
			 "Curar",	new CurarCasilleroHandler(this, juego, filaOrigen, columnaOrigen, filaDestino, columnaDestino)
		);	


		for (String option : options) {
			Button button = new Button(option);
			button.setOnAction(optionDict.get(option));
			boxDerecho.getChildren().add(button);	
		}

		boxDerecho.setStyle("-fx-min-width: 150px; -fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 8;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 8;" + "-fx-border-color: " + 
				colorFaccion.get(juego.getFaccionActual()) + ";");


	}

	private void armarColumnaIzquierda() {
		boxIzquierdo = new VBox(12);
		boxIzquierdo.setAlignment(Pos.CENTER);

		boxIzquierdo.setStyle("-fx-min-width: 150px; -fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 8;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 8;" + "-fx-border-color: " + 
				colorFaccion.get(juego.getFaccionActual()) + ";");

		Label lblNombre = new Label(juego.getJugadorActual().getNombre());
		lblNombre.setFont(Font.font("Amble CN", FontWeight.BOLD, 24));

		Button btnPasar = new Button();

		btnPasar.setText("Pasar Turno");
		btnPasar.setOnAction((ActionEvent e) -> {
			boolean finished = juego.cambiarTurno();
			if(finished) {
				System.out.println("Termina el juego");
			}

			refrescar();
		});
		
		boxIzquierdo.getChildren().addAll(lblNombre, btnPasar);

	}

	private void armarColumnaIzquierda(Entidad entidad) {
		boxIzquierdo = new VBox(12);
		boxIzquierdo.setAlignment(Pos.CENTER);

		boxIzquierdo.setStyle("-fx-min-width: 150px; -fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 8;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 8;" + "-fx-border-color: " + 
				colorFaccion.get(juego.getFaccionActual()) + ";");

		Label lblNombre = new Label(juego.getJugadorActual().getNombre());
		lblNombre.setFont(Font.font("Amble CN", FontWeight.BOLD, 24));
		lblNombre.setStyle("-fx-margin-bottom: 30px;");
		boxIzquierdo.getChildren().add(lblNombre);

		List<Field> parentFields = new ArrayList<Field>();
		parentFields.add(this.getField(Entidad.class, "vida"));
		parentFields.add(this.getField(Entidad.class, "faccion"));
		parentFields.add(this.getField(Entidad.class, "costo"));
		parentFields.add(this.getField(Entidad.class, "posicion"));
		parentFields.add(this.getField(Entidad.class, "propietario"));
		
		List<String> careAttributes = new ArrayList<String>();
		careAttributes.add("puntosdevida");
		careAttributes.add("fila");
		careAttributes.add("columna");
		careAttributes.add("nombre");
		careAttributes.add("faccion");

		HashMap<String, String> entityData = new HashMap<String, String>();
		try {
			entityData = obtenerAtributos(entidad, careAttributes, parentFields);
		} catch (Exception ex) {
			// TODO: Usar exception handler
			System.out.println(ex);
		}

		HashMap<String, String> attributeAlias = new HashMap<String, String>();
		attributeAlias.put("columna", "Columna");
		attributeAlias.put("fila", "Fila");
		attributeAlias.put("puntosdevida", "Vida");
		attributeAlias.put("nombre", "Propietario");
		attributeAlias.put("faccion", "Faccion");

		Label lblEntidad = new Label(entidad.getClass().getSimpleName());
		if (!lblEntidad.getText().equals("NulaEntidad")){
			lblEntidad.setFont(Font.font("Amble CN", FontWeight.BOLD, 18));
			boxIzquierdo.getChildren().add(lblEntidad);
		}

		for (Map.Entry<String, String> entry : entityData.entrySet()) {
			Label label = new Label(attributeAlias.get(entry.getKey()) + ": " + entry.getValue());
			if(attributeAlias.get(entry.getKey()) == "Faccion")
				label.setFont(Font.font("Amble CN", FontWeight.BOLD, 16));
			boxIzquierdo.getChildren().add(label);
		}

		
		// for (Field field : entidad.getClass().getDeclaredFields()) {
		// 	try {
		// 		field.setAccessible(true);
		// 		Object value = field.get(entidad);
		// 		if(value != null) {
		// 			Label label = new Label(field.getName() + value);
		// 			boxIzquierdo.getChildren().add(label);
		// 		}
		// 	} catch(Exception ex) {
		// 		System.out.println(ex);
		// 	}
		// }

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

	private Field getField(Class<?> clazz, String name) {
	    Field field = null;
	    while (clazz != null && field == null) {
	        try {
	            field = clazz.getDeclaredField(name);
	        } catch (Exception e) {
	        	System.out.println("getField fail");
	        	System.out.println(e);
	        }
	        clazz = clazz.getSuperclass();
	    }
	    return field;
	}

	private HashMap<String, String> obtenerAtributos(Entidad entidad, List<String> careAttributes, List<Field> parentFields) {
		HashMap<String, String> entityData = new HashMap<String, String>();
		for (Field parentField : parentFields) {
			try {
				parentField.setAccessible(true);
				Object value = parentField.get(entidad);
				if(value != null) {
					for(Field valueField : value.getClass().getDeclaredFields()) {
						try {
							if(valueField != null) {
								valueField.setAccessible(true);
								Object _value = valueField.get(value);
								if(_value != null) {
									if(careAttributes.contains(valueField.getName()))
										entityData.put(valueField.getName(), _value.toString());
								}
							}
						} catch (Exception ex) {
							System.out.println(ex);
						}
					}
				}
			} catch(Exception ex) {
				System.out.println(ex);
			}
		}

		return entityData;
	}
}