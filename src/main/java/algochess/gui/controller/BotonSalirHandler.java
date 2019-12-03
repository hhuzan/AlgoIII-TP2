package algochess.gui.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonSalirHandler implements EventHandler<ActionEvent> {



    public BotonSalirHandler(){

    }


    @Override
    public void handle(ActionEvent actionEvent) {
        System.exit(0);
    }
}
