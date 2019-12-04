package algochess.gui.controller;

import algochess.gui.vista.AlgoChess;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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
