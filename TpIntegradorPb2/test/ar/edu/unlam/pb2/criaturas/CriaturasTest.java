package ar.edu.unlam.pb2.criaturas;

import static org.junit.Assert.*;

import org.junit.Test;

public class CriaturasTest {

	@Test
	public void queLaCriaturaSalvajeEntrenaYSubeEnergia() {
		Criatura salvaje = new CriaturaSalvaje("Lobo", 100, Afinidad.FUEGO);
		salvaje.entrenar();

		assertTrue(salvaje.getNivelDeEnergia() >= 110);
		assertTrue(salvaje.getNivelDeEnergia() <= 140);
	}

	@Test(expected = EnergiaDesbordadaException.class)
	public void queLaCriaturaSalvajeSupera200YLanzaExcepcion() {
		Criatura salvaje = new CriaturaSalvaje("Tigre", 195, Afinidad.AIRE);
		salvaje.entrenar();
	}

	@Test
	public void queLaCriaturaDomesticadaAumentaEnergiaDeFormaEstable() {
		Criatura dom = new CriaturaDomesticada("Perro", 80, Afinidad.TIERRA);
		dom.entrenar();
		assertEquals(Integer.valueOf(95), dom.getNivelDeEnergia());
	}

	@Test
	public void queLaCriaturaDomesticadaNuncaSeVuelveInestable() {
		CriaturaDomesticada dom = new CriaturaDomesticada("Gato", 50, Afinidad.AGUA);

		dom.volverInestable();

		assertEquals(Emocional.TRANQUILA, dom.getEstado());
	}

	@Test
	public void queLaCriaturaAncestralNuncaBajaDe100() {
		CriaturaAncestral anc = new CriaturaAncestral("Dragon", 120, Afinidad.FUEGO);

		anc.reducirEnergia(50);

		assertEquals(Integer.valueOf(100), anc.getNivelDeEnergia());
	}

	@Test
	public void queElEntrenamientoDeCriaturaAncestralRespetaMinimo100() {
		CriaturaAncestral anc = new CriaturaAncestral("Fenix", 90, Afinidad.AIRE);

		assertEquals(Integer.valueOf(100), anc.getNivelDeEnergia());

		anc.entrenar();
		assertEquals(Integer.valueOf(120), anc.getNivelDeEnergia());
	}

	@Test
	public void queTodaCriaturaEmpiezaTranquila() {
		Criatura c = new CriaturaSalvaje("Lobo", 50, Afinidad.FUEGO);
		assertEquals(Emocional.TRANQUILA, c.getEstado());
	}

////CAMBIOS A VERIFICAR
	@Test
	public void queUnaCriaturaSalvajeSeVuelvaInestableConEnergiaMayorA100() {
		Criatura c = new CriaturaSalvaje("Lobo", 100, Afinidad.FUEGO);
		c.entrenar();
		assertEquals(Emocional.INESTABLE, c.getEstado());
	}

	@Test
	public void queUnaCriaturaAncestralSeVuelvaInestableConEnergiaMayorA150() {
		Criatura c = new CriaturaAncestral("Samy", 150, Afinidad.FUEGO);
		c.entrenar();
		assertEquals(Emocional.INESTABLE, c.getEstado());
	}

	@Test
	public void queUnaCriaturaDomesticadaNoPuedaVolverseInestable() {
		Criatura c = new CriaturaDomesticada("Samy", 150, Afinidad.FUEGO);
		c.entrenar(); // Hice varios para demostrar que da igual cuánto entrene nunca se vuelve
						// inestable.
		c.entrenar();
		c.entrenar();
		c.entrenar();
		c.entrenar();
		assertEquals(Emocional.TRANQUILA, c.getEstado());
	}

	// Test transformaciones elementales
	@Test
	public void queUnaCriaturaAncestralAdquieraUnaBendicionDeRioDuplicandoSuEnergia() {
		Criatura criatura = new CriaturaAncestral("Samy", 101, Afinidad.AGUA);
		criatura = new BendicionDeRio(criatura);
		criatura.entrenar();
		assertEquals(Integer.valueOf(180), criatura.getNivelDeEnergia());
	}

	@Test
	public void queUnaCriaturaAncestralAdquieraDosTransformacionesDuplicandoSuEnergia() {
		Criatura criatura = new CriaturaAncestral("Rocket", 101, Afinidad.FUEGO);
		criatura = new BendicionDeRio(criatura);
		criatura = new LlamaInterna(criatura);
		criatura.entrenar();
		assertEquals(Integer.valueOf(200), criatura.getNivelDeEnergia());
	}

	@Test
	public void queUnaCriaturaAncestralQueNoEsFuegoSeVuelvaInestableConLlamaInterna() {
		Criatura criatura = new CriaturaAncestral("Samy", 101, Afinidad.AGUA);
		criatura = new BendicionDeRio(criatura);
		criatura = new LlamaInterna(criatura);
		criatura.entrenar();
		assertEquals(Emocional.INESTABLE, criatura.getEstado());
	}

	@Test
	public void queUnaCriaturaDomesticaAdquieraVinculoTerreste() {
	    Criatura c = new CriaturaDomesticada("Luna", 40, Afinidad.TIERRA);
	    c = new VinculoTerrestre(c);

	    c.reducirEnergia(100);

	    assertEquals(Integer.valueOf(50), c.getNivelDeEnergia());
	}

	@Test
	public void queUnaCriaturaDomesticaAdquieraAscensoDelViento() {
	    Criatura c = new CriaturaDomesticada("Luna", 40, Afinidad.TIERRA);
	    c = new AscensoDelViento(c);

	    assertEquals(Afinidad.AIRE, c.getAfinidad());
	}

}


