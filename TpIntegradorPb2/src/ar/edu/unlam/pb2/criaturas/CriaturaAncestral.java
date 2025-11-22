package ar.edu.unlam.pb2.criaturas;

public class CriaturaAncestral extends Criatura {

	private final int ENERGIA_MAXIMA = 200;
	private final int ENERGIA_MINIMA = 100;

	public CriaturaAncestral(String nombre, Integer nivelDeEnergia, Afinidad afinidad) {
		super(nombre, nivelDeEnergia, afinidad);
		asegurarMinimo();
	}

	private void asegurarMinimo() {
		if (this.nivelDeEnergia < ENERGIA_MINIMA) {
			this.nivelDeEnergia = ENERGIA_MINIMA;
		}
	}

	@Override
	public void entrenar() {
		Integer nuevaEnergia = this.nivelDeEnergia + 20;
		if (nuevaEnergia > ENERGIA_MAXIMA) {
			nuevaEnergia = ENERGIA_MAXIMA;
		}

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