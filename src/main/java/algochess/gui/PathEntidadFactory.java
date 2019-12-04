package algochess.gui;

import algochess.engine.entidades.*;
import java.util.HashMap;
import java.util.function.Function;

public class PathEntidadFactory {
    private String jinete = "images/CaballoNeutro.png";
    private String soldado = "images/SoldadoNeutro.png";
    private String curandero = "images/CuranderoNeutro.png";
    private String catapulta = "images/CatapultaNeutro.png";

    public Entidad create(String path) {
        HashMap<String, Function<String, Entidad>> path2entidad = new HashMap<>();
        path2entidad.put(jinete, arg -> new Jinete());
        path2entidad.put(soldado, arg -> new Soldado());
        path2entidad.put(curandero, arg -> new Curandero());
        path2entidad.put(catapulta, arg -> new Catapulta());

        Function<String, Entidad> stringEntidadFunction = path2entidad.get(path);
        return stringEntidadFunction.apply("" /* unnecesary */);
    }
}