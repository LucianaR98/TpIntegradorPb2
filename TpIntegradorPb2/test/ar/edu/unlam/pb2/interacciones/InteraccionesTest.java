package ar.edu.unlam.pb2.interacciones;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import ar.edu.unlam.pb2.criaturas.*;

public class InteraccionesTest {

	@Test
    public void queInteractuenCriaturasConMismaAfinidad() {
	    Criatura c1 = new CriaturaDomesticada("Luna", 50, Afinidad.FUEGO);
	    Criatura c2 = new CriaturaSalvaje("Zorro", 80, Afinidad.FUEGO);

	    InteraccionCriaturas interaccion = new InteraccionCriaturas();
	    interaccion.interactuar(c1, c2);

	    assertEquals(Integer.valueOf(60), c1.getNivelDeEnergia());
	    assertEquals(Integer.valueOf(90), c2.getNivelDeEnergia());
    }

    @Test
    public void queInteractuenCriaturasConAfinidadesOpuestasEnTierraYAire() {
    	Criatura criaturaTierra = new CriaturaSalvaje("Tango", 100, Afinidad.TIERRA);
    	Criatura criaturaAire = new CriaturaSalvaje("Appa", 40, Afinidad.AIRE);
    	
    	InteraccionCriaturas interaccion = new InteraccionCriaturas();
    	interaccion.interactuar(criaturaTierra, criaturaAire);

    	assertEquals(Emocional.INESTABLE, criaturaTierra.getEstado());
    	assertEquals(Emocional.INESTABLE, criaturaAire.getEstado());
    }
    
    @Test
    public void queInteractuenCriaturasConAfinidadesOpuestasEnFuegoYAgua() {
    	Criatura criaturaFuego = new CriaturaSalvaje("Samy", 50, Afinidad.FUEGO);
    	Criatura criaturaAgua = new CriaturaSalvaje("Fish", 30, Afinidad.AGUA);
    	
    	InteraccionCriaturas interaccion = new InteraccionCriaturas();
    	interaccion.interactuar(criaturaFuego, criaturaAgua);
    	
    	assertEquals(Emocional.INESTABLE, criaturaFuego.getEstado());
    	assertEquals(Emocional.INESTABLE, criaturaAgua.getEstado());
    }

    @Test
    public void queUnAncestralDomineLaInteraccionGanandoEnergiaYLaOtraCriaturaPierdeEnergia() {
    	Criatura ancestral = new CriaturaAncestral("Samy", 100, Afinidad.AGUA);
    	Criatura otraCriatura = new CriaturaDomesticada("Rocket", 40, Afinidad.AGUA);
    	
    	InteraccionCriaturas interaccion = new InteraccionCriaturas();
    	interaccion.interactuar(ancestral, otraCriatura);
    	
    	assertEquals(Integer.valueOf(130), ancestral.getNivelDeEnergia());
    	assertEquals(Integer.valueOf(35), otraCriatura.getNivelDeEnergia());
    }

}

