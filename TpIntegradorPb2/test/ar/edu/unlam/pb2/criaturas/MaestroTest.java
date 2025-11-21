package ar.edu.unlam.pb2.criaturas;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaestroTest {

	@Test
	public void queSePuedaCrearUnMaestro() {
		Maestro maestro = new Maestro("Moon", 20, Afinidad.FUEGO);
		assertNotNull(maestro);
	}

	@Test
	public void queSePuedaAgregarUnaCriaturaACargoDelMaestro() {
		Maestro maestro = new Maestro("Moon", 40, Afinidad.TIERRA);
		Criatura criatura = new CriaturaDomesticada("Tango", 10, Afinidad.TIERRA);
		maestro.agregarCriatura(criatura);
		assertEquals(criatura, maestro.obtenerCriatura("Tango"));
	}

	@Test
	public void quePuedaEntrenarUnaCriaturaQueEstaASuCargoYCambieSuEnergia() throws FaltaDeMaestriaException {
		Maestro maestro = new Maestro("Moon", 40, Afinidad.TIERRA);
		Criatura criatura = new CriaturaAncestral("Samy", 100, Afinidad.FUEGO);
		maestro.agregarCriatura(criatura);
		maestro.entrenarCriatura(criatura);
		assertEquals(Integer.valueOf(120), criatura.getNivelDeEnergia());
	}

	@Test(expected = FaltaDeMaestriaException.class)
	public void queAlNoTenerSuficienteMaestriaSeObtengaUnaExcepcion() throws FaltaDeMaestriaException {
		Maestro maestro = new Maestro("Moon", 10, Afinidad.TIERRA);
		Criatura criatura = new CriaturaAncestral("Samy", 100, Afinidad.FUEGO);
		maestro.agregarCriatura(criatura);
		maestro.entrenarCriatura(criatura);
	}

	@Test
	public void quePuedaPacificarUnaCriaturaAncestralInestable() throws FaltaDeMaestriaException {
		Maestro maestro = new Maestro("Moon", 40, Afinidad.TIERRA);
		Criatura criatura = new CriaturaAncestral("Samy", 150, Afinidad.FUEGO);
		maestro.agregarCriatura(criatura);
		maestro.entrenarCriatura(criatura);

		assertEquals(Emocional.INESTABLE, criatura.getEstado());
		
		maestro.pacificarCriatura(criatura);
		assertEquals(Emocional.TRANQUILA, criatura.getEstado());
	}
	
	@Test
	public void quePuedaPacificarUnaCriaturaSalvajeInestable() throws FaltaDeMaestriaException {
		Maestro maestro = new Maestro("Moon", 40, Afinidad.TIERRA);
		Criatura criatura = new CriaturaSalvaje("Zorua", 150, Afinidad.FUEGO);
		maestro.agregarCriatura(criatura);
		maestro.entrenarCriatura(criatura);

		assertEquals(Emocional.INESTABLE, criatura.getEstado());
		
		maestro.pacificarCriatura(criatura);
		assertEquals(Emocional.TRANQUILA, criatura.getEstado());
	}

	@Test
	public void quePuedaTransformarUnaCriaturaConRitualesEspeciales() {

	}

}