package AlgoChess.excepciones;

public class DineroInsuficienteException extends RuntimeException {

    public String toString(){
        return ("Te quedaste sin dinero para realizar tal accion") ;
    }

}