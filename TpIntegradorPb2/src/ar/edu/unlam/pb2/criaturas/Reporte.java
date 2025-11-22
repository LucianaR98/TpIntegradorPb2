package ar.edu.unlam.pb2.criaturas;

import java.util.ArrayList;

public class Reporte {
	public ArrayList<Criatura> listarCriaturas(ArrayList<Maestro> maestros) {
		ArrayList<Criatura> listaDeCriaturas = new ArrayList<>();

        for (Maestro maestro : maestros) {
            for (Criatura criatura : maestro.getCriaturas().values()) {
            	listaDeCriaturas.add(criatura);
            }
        }
        return listaDeCriaturas;
	}

	public Criatura obtenerLaMayorEnergia(ArrayList<Maestro> maestros) {
		Criatura mayorEnergia = null;
		
		for(Maestro maestro : maestros) {
			for(Criatura criatura : maestro.getCriaturas().values()) {
				if(mayorEnergia == null || criatura.getNivelDeEnergia() > mayorEnergia.getNivelDeEnergia()) {
					mayorEnergia = criatura;
				}
			}
				
		}
		
		return mayorEnergia;
	}
	
	

}


