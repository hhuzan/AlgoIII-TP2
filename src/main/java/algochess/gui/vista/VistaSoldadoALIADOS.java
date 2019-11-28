package algochess.gui.vista;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class VistaSoldadoALIADOS implements VistaEntidad {

	public VistaSoldadoALIADOS(VistaCasillero vistaCasillero) {
		Image image;
		image = new Image("images/SoldadoPink.png");
		int tamanio= vistaCasillero.getTamanio();
		Rectangle rectangulo = new Rectangle(tamanio, tamanio);
		rectangulo.setFill(new ImagePattern(image));
		vistaCasillero.getChildren().add(rectangulo);
	}

}
