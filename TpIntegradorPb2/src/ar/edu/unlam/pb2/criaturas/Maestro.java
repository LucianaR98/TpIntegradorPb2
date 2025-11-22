package ar.edu.unlam.pb2.criaturas;
import java.util.Map;
import java.util.HashMap;

public class Maestro {

	private String nombre;
	private Integer nivelMaestria;
	private Afinidad afinidadElemental;
	private Map<String, Criatura> criaturas = new HashMap<>();

	public Maestro(String nombre, Integer nivelMaestria, Afinidad afinidadElemental) {
		this.nombre = nombre;
		this.nivelMaestria = nivelMaestria;
		this.afinidadElemental = afinidadElemental;
	}

	public void agregarCriatura(Criatura criatura) {
			this.criaturas.put(criatura.getNombre(), criatura);
	}

	public Criatura obtenerCriatura(String nombreCriatura) {
		return this.criaturas.get(nombreCriatura);
	}

	public void entrenarCriatura(Criatura criatura) throws FaltaDeMaestriaException {
		if(!maestriaValida(criatura)) {
			throw new FaltaDeMaestriaException("El maestro no tiene suficiente maestria para entrenar a esta criatura");
		}
		
		if(this.criaturas.containsKey(criatura.getNombre())) {
			criatura.entrenar();
		}
		
	}

	public Boolean maestriaValida(Criatura criatura) {	
		  while (criatura instanceof TransformacionesDecorador) {
		        criatura = ((TransformacionesDecorador) criatura).getCriaturaBase();
		    }
		Integer nivel = this.nivelMaestria;		
		if(criatura instanceof CriaturaDomesticada) {
			return nivel >= 1;
		}else if(criatura instanceof CriaturaAncestral){
			return nivel >= 35;
		}else if(criatura instanceof CriaturaSalvaje) {
			return nivel > 35 && nivel <= 50;
		}
		return false;
	}

	public void pacificarCriatura(Criatura criatura) {
		if(this.criaturas.containsKey(criatura.getNombre())) {
			criatura.pacificar();
		}
	}

	public Criatura utilizarBendicionDeRio(Criatura criatura) {
		Criatura criaturaTransformada = new BendicionDeRio(criatura);

		this.criaturas.put(criatura.getNombre(), criaturaTransformada);
		return criaturaTransformada;
	}

	public Criatura utilizarLlamaInterna(Criatura criatura) {
		Criatura criaturaTransformada = new LlamaInterna(criatura);

		this.criaturas.put(criatura.getNombre(), criaturaTransformada);
		return criaturaTransformada;
	}

	public Map<String, Criatura> getCriaturas() {
	    return this.criaturas;
	}
}