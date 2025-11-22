package ar.edu.unlam.pb2.interacciones;

import ar.edu.unlam.pb2.criaturas.Criatura;

public class ResultadoInteraccion {

    private Criatura primero;
    private Criatura segundo;

    public ResultadoInteraccion(Criatura primero, Criatura segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }

    public Criatura getPrimero() {
        return primero;
    }

    public Criatura getSegundo() {
        return segundo;
    }
}