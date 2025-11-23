package ar.edu.unlam.pb2.reportes;

import java.util.HashMap;
import java.util.Map;

import ar.edu.unlam.pb2.criaturas.Afinidad;
import ar.edu.unlam.pb2.criaturas.Criatura;
import ar.edu.unlam.pb2.criaturas.Maestro;
import ar.edu.unlam.pb2.criaturas.TransformacionesDecorador;

public class ReportesConsejo {

    public Maestro maestroConMasCriaturasTransformadas(Map<String, Maestro> maestros) {

        Maestro maestroMax = null;
        int maxTransformadas = 0;

        for (Maestro maestro : maestros.values()) {

            int cantidad = 0;

            for (Criatura criatura : maestro.getCriaturas().values()) {
                if (criatura instanceof TransformacionesDecorador) {
                    cantidad++;
                }
            }

            if (cantidad > maxTransformadas) {
                maxTransformadas = cantidad;
                maestroMax = maestro;
            }
        }

        return maestroMax;
    }

    public Map<Afinidad, Integer> cantidadDeCriaturasPorAfinidad(Map<String, Maestro> maestros) {

        Map<Afinidad, Integer> mapa = new HashMap<>();

        for (Maestro maestro : maestros.values()) {

            for (Criatura criatura : maestro.getCriaturas().values()) {

                Afinidad afinidad = criatura.getAfinidad();

                if (!mapa.containsKey(afinidad)) {
                    mapa.put(afinidad, 0);
                }

                mapa.put(afinidad, mapa.get(afinidad) + 1);
            }
        }

        return mapa;
    }
}