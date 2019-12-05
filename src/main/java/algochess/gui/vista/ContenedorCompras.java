package algochess.gui.vista;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
import algochess.engine.entidades.Soldado;
import algochess.engine.entidades.Jinete;
import algochess.engine.entidades.Catapulta;
import algochess.engine.entidades.Curandero;
import algochess.gui.PathEntidadFactory;


public class ContenedorCompras extends HBox {

	private Stage stage;
	private Juego juego;
	private VBox boxIzquierdo;
	private VBox boxDerecho;
	private MediaPlayer mediaPlayer;

	public ContenedorCompras(Stage stage, Juego juego, MediaPlayer mediaPlayer) {
		super();
		this.stage = stage;
		this.juego = juego;
		this.mediaPlayer = mediaPlayer;

		setAlignment(Pos.CENTER);
		setSpacing(50);
		refrescar();
		
		Image fondo = new Image("images/Mono2.jpg");
		BackgroundImage imagenDeFondo = new BackgroundImage(fondo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
				BackgroundPosition.DEFAULT, new BackgroundSize(1, 1, true, true, false, false));
		setBackground(new Background(imagenDeFondo));
	}

	public void refrescar() {
		this.getChildren().clear();
		armarColumnaIzquierda();
		armarColumnaDerecha();
		VistaTablero tableroVista = new VistaTablero(juego, this);
		this.getChildren().addAll(boxIzquierdo, tableroVista.getPaneTablero(), boxDerecho);		
	}

	private void armarColumnaDerecha() {
		boxDerecho = new VBox(30);
		boxDerecho.setAlignment(Pos.CENTER);

		Label lblNombre = new Label(juego.getJugadorActual().getNombre());
		lblNombre.setFont(Font.font("Amble CN", FontWeight.BOLD, 18));
		lblNombre.setStyle("-fx-margin-bottom: 20px;");
		boxDerecho.getChildren().add(lblNombre);

		Label lbl1 = new Label("Disponible:");
		lbl1.setFont(Font.font("Amble CN", FontWeight.BOLD, 16));
		boxDerecho.getChildren().add(lbl1);
		
		Label lblMonto = new Label("$" + juego.getJugadorActual().obtenerBalance());
		lblMonto.setFont(Font.font("Amble CN", FontWeight.BOLD, 16));
		boxDerecho.getChildren().add(lblMonto);

		String color;
		if (juego.getFaccionActual() == Faccion.ALIADOS)
			color = "LIGHTPINK";
		else
			color = "AQUAMARINE";

		boxDerecho.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 8;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 8;" + "-fx-border-color: " + color + ";");

	}

	private void armarColumnaIzquierda() {
		boxIzquierdo = new VBox(12);
		boxIzquierdo.setAlignment(Pos.CENTER);
		String color;
		if (juego.getFaccionActual() == Faccion.ALIADOS)
			color = "LIGHTPINK";
		else
			color = "AQUAMARINE";

		boxIzquierdo.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 8;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 8;" + "-fx-border-color: " + color + ";");

		String[] imagePaths = new String[] {  	"images/CaballoNeutro.png", "images/SoldadoNeutro.png", 
												"images/CuranderoNeutro.png", "images/CatapultaNeutro.png" };

		Image shopImage = new Image("images/SHOP_ICON.png");
		ImageView shopView = new ImageView();
		shopView.setImage(shopImage);
		shopView.setFitWidth(100);
		shopView.setPreserveRatio(true);
		shopView.setSmooth(true);
		shopView.setCache(true);
		boxIzquierdo.getChildren().add(shopView);

		PathEntidadFactory entityFactory = new PathEntidadFactory();
		for (String path : imagePaths) {
			Image image = new Image(path);
			ImageView imageView = new ImageView();
			imageView.setImage(image);
			imageView.setFitWidth(100);
			imageView.setPreserveRatio(true);
			imageView.setSmooth(true);
			imageView.setCache(true);
			ToggleButton toggleButton = new ToggleButton();
			toggleButton.setGraphic(imageView);
			toggleButton.setPadding(new Insets(-1, -1, -1, -1));
			toggleButton.setOnAction((ActionEvent e) -> {
				juego.seleccionarEntidad(entityFactory.create(path));
			});
			boxIzquierdo.getChildren().add(toggleButton);
		}
		Button btnPasar = new Button();
		btnPasar.setText("Pasar Turno");
		btnPasar.setOnAction((ActionEvent e) -> {
			boolean finished = juego.cambiarTurno();
			if(finished) {
				System.out.println("------------------ FIN COMPRAS ------------------");
				ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, juego, mediaPlayer);
				Scene escenaPrincipal = new Scene(contenedorPrincipal, 1120, 660);

				stage.setScene(escenaPrincipal);
			}

			refrescar();
		});
		boxIzquierdo.getChildren().add(btnPasar);

	}
}