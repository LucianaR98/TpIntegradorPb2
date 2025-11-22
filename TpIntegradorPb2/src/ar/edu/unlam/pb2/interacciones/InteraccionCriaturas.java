package ar.edu.unlam.pb2.interacciones;

import ar.edu.unlam.pb2.criaturas.Criatura;

public class InteraccionCriaturas implements Interaccion{

	@Override
	public void interactuar(Criatura c1, Criatura c2) {
		if(AfinidadesOpuestas.sonOpuestas(c1.getAfinidad(), c2.getAfinidad())) {
			c1.volverInestable();
			c2.volverInestable();
		}

		if (c1.esCriaturaAncestral() || c2.esCriaturaAncestral()) {
			interaccionConAncestral(c1, c2);
		}

	}

	private void interaccionConAncestral(Criatura c1, Criatura c2) {
		Criatura ancestral;
		if (c1.esCriaturaAncestral()) {
		    ancestral = c1;
		} else {
		    ancestral = c2;
		}
		
		Criatura otraCriatura;
		if (ancestral == c1) {
		    otraCriatura = c2;
		} else {
		    otraCriatura = c1;
		}
		
		ancestral.setNivelDeEnergia(ancestral.getNivelDeEnergia() + 20);
		otraCriatura.setNivelDeEnergia(otraCriatura.getNivelDeEnergia() - 15);
	}
}

