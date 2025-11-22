package ar.edu.unlam.pb2.criaturas;

public class CriaturaAncestral extends Criatura {

	public CriaturaAncestral(String nombre, Integer nivelDeEnergia, Afinidad afinidad) {
		super(nombre, nivelDeEnergia, afinidad);
		asegurarMinimo();
	}

	private void asegurarMinimo() {
		if (this.nivelDeEnergia < 100) {
			this.nivelDeEnergia = 100;
		}
	}

	@Override
	public void entrenar() {
		int nuevaEnergia = this.nivelDeEnergia + 20;
		if (nuevaEnergia > 200) {
			nuevaEnergia = 200;
		}
		//// CAMBIOS A VERIFICAR
		if (nuevaEnergia > 150) {
			this.volverInestable();
		}
		this.setNivelDeEnergia(nuevaEnergia);
		asegurarMinimo();
	}

	public void reducirEnergia(int cantidad) {
		this.nivelDeEnergia -= cantidad;
		asegurarMinimo();
	}

////CAMBIOS A VERIFICAR	
	@Override
	public void pacificar() {
		if (this.getEstado().equals(Emocional.INESTABLE)) {
			this.reducirEnergia(50);
			this.estado = Emocional.TRANQUILA;
		}

	}
	
	@Override
	public Boolean esCriaturaAncestral() {
	    return true;
	}
}