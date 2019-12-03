package algochess.gui.controller;

import algochess.gui.vista.AlgoChess;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonVolverHandler implements EventHandler<ActionEvent> {


    private AlgoChess algoChess;

    public BotonVolverHandler(AlgoChess algoChess){
        this.algoChess = algoChess;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        algoChess.crearEscenaBienvenidos();
    }
}
