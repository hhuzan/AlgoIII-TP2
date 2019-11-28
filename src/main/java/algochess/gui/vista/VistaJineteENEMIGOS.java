package algochess.gui.vista;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class VistaJineteENEMIGOS implements VistaEntidad {

	public VistaJineteENEMIGOS(VistaCasillero vistaCasillero) {
		Image image;
		image = new Image("images/CaballoBlue.png");
		int tamanio= vistaCasillero.getTamanio();
		Rectangle rectangulo = new Rectangle(tamanio, tamanio);
		rectangulo.setFill(new ImagePattern(image));
		vistaCasillero.getChildren().add(rectangulo);
	}

}
