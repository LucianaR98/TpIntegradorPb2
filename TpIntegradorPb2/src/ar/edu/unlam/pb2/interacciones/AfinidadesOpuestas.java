package ar.edu.unlam.pb2.interacciones;

import ar.edu.unlam.pb2.criaturas.Afinidad;

public class AfinidadesOpuestas {

    public static boolean sonOpuestas(Afinidad a1, Afinidad a2) {
        return  (a1 == Afinidad.AGUA && a2 == Afinidad.FUEGO) ||
                (a1 == Afinidad.FUEGO && a2 == Afinidad.AGUA) ||
                (a1 == Afinidad.AIRE && a2 == Afinidad.TIERRA) ||
                (a1 == Afinidad.TIERRA && a2 == Afinidad.AIRE);
    }
}