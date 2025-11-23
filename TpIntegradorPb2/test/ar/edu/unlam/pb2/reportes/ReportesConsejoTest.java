package ar.edu.unlam.pb2.reportes;

import static org.junit.Assert.assertEquals; 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import ar.edu.unlam.pb2.criaturas.Afinidad;
import ar.edu.unlam.pb2.criaturas.Criatura;
import ar.edu.unlam.pb2.criaturas.CriaturaAncestral;
import ar.edu.unlam.pb2.criaturas.CriaturaDomesticada;
import ar.edu.unlam.pb2.criaturas.CriaturaSalvaje;
import ar.edu.unlam.pb2.criaturas.LlamaInterna;
import ar.edu.unlam.pb2.criaturas.Maestro;

public class ReportesConsejoTest {
	
	@Test
	public void queSePuedanListarLasCriaturasAcargoDeLosMaestros() {
		Maestro maestro1 = new Maestro("Moon", 36, Afinidad.TIERRA);
		Criatura criatura = new CriaturaDomesticada("Tango", 10, Afinidad.TIERRA);
		Criatura criatura1 = new CriaturaAncestral("Samy", 120, Afinidad.FUEGO);
		maestro1.agregarCriatura(criatura);
		maestro1.agregarCriatura(criatura1);

		Maestro maestro2 = new Maestro("Aang", 40, Afinidad.AIRE);
		Criatura criaturaA = new CriaturaDomesticada("Puchi", 20, Afinidad.TIERRA);
		Criatura criaturaB = new CriaturaAncestral("Queelag", 100, Afinidad.AIRE);
		Criatura criaturaC = new CriaturaSalvaje("Zorua", 60, Afinidad.TIERRA);
		maestro2.agregarCriatura(criaturaA);
		maestro2.agregarCriatura(criaturaB);
		maestro2.agregarCriatura(criaturaC);

		ArrayList<Maestro> maestros = new ArrayList<>();
		maestros.add(maestro1);
		maestros.add(maestro2);

		ReportesConsejo reportes = new ReportesConsejo();

		ArrayList<Criatura> listaDeCriaturas = reportes.listarCriaturas(maestros);

		assertEquals(5, listaDeCriaturas.size());
	}

	@Test
	public void queSePuedaObtenerLaCriaturaConMayorEnergia() {
		Maestro maestro1 = new Maestro("Moon", 36, Afinidad.TIERRA);
		Criatura criatura = new CriaturaDomesticada("Tango", 10, Afinidad.TIERRA);
		Criatura criatura1 = new CriaturaAncestral("Samy", 120, Afinidad.FUEGO);
		maestro1.agregarCriatura(criatura);
		maestro1.agregarCriatura(criatura1);

		Maestro maestro2 = new Maestro("Aang", 40, Afinidad.AIRE);
		Criatura criaturaA = new CriaturaDomesticada("Puchi", 20, Afinidad.TIERRA);
		Criatura criaturaB = new CriaturaAncestral("Queelag", 100, Afinidad.AIRE);
		Criatura criaturaC = new CriaturaSalvaje("Zorua", 60, Afinidad.TIERRA);
		maestro2.agregarCriatura(criaturaA);
		maestro2.agregarCriatura(criaturaB);
		maestro2.agregarCriatura(criaturaC);

		ArrayList<Maestro> maestros = new ArrayList<>();
		maestros.add(maestro1);
		maestros.add(maestro2);

		ReportesConsejo reportes = new ReportesConsejo();

		Criatura resultado = reportes.obtenerLaMayorEnergia(maestros);

		assertEquals("Samy", resultado.getNombre());

	}

    @Test
    public void queEncuentreAlMaestroConMasCriaturasTransformadas() {

        Maestro m1 = new Maestro("A", 40, Afinidad.AGUA);
        Maestro m2 = new Maestro("B", 40, Afinidad.FUEGO);

        Criatura c1 = new CriaturaDomesticada("Luna", 40, Afinidad.AGUA);
        Criatura c2 = new LlamaInterna(new CriaturaDomesticada("Sol", 30, Afinidad.FUEGO));
        Criatura c3 = new LlamaInterna(new CriaturaDomesticada("Ro", 30, Afinidad.AIRE));

        m1.agregarCriatura(c1);
        m2.agregarCriatura(c2);
        m2.agregarCriatura(c3);

        Map<String, Maestro> mapa = new HashMap<>();
        mapa.put("A", m1);
        mapa.put("B", m2);

        ReportesConsejo reportes = new ReportesConsejo();

        Maestro resultado = reportes.maestroConMasCriaturasTransformadas(mapa);

        assertEquals(m2, resultado);
    }

    @Test
    public void queGenereMapaDeAfinidades() {

        Maestro m1 = new Maestro("A", 40, Afinidad.AGUA);

        m1.agregarCriatura(new CriaturaDomesticada("Luna", 40, Afinidad.AGUA));
        m1.agregarCriatura(new CriaturaAncestral("Fenix", 120, Afinidad.FUEGO));

        Map<String, Maestro> mapa = new HashMap<>();
        mapa.put("A", m1);

        ReportesConsejo reportes = new ReportesConsejo();

        Map<Afinidad, Integer> resultado = reportes.cantidadDeCriaturasPorAfinidad(mapa);

        assertEquals(Integer.valueOf(1), resultado.get(Afinidad.AGUA));
        assertEquals(Integer.valueOf(1), resultado.get(Afinidad.FUEGO));
    }
}