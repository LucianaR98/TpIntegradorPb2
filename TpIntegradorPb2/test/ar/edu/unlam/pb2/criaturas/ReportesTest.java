package ar.edu.unlam.pb2.criaturas;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ReportesTest {

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

		Reporte reportes = new Reporte();

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

		Reporte reportes = new Reporte();

		Criatura resultado = reportes.obtenerLaMayorEnergia(maestros);

		assertEquals("Samy", resultado.getNombre());

	}

}
