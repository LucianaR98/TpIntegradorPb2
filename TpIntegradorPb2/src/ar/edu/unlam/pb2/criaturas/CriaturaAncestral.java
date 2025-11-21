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
		this.nivelDeEnergia = nuevaEnergia;
		asegurarMinimo();
	}

	public void reducirEnergia(int cantidad) {
		this.nivelDeEnergia -= cantidad;
		asegurarMinimo();
	}
}