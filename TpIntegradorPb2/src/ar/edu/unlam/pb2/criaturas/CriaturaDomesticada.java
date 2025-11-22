package ar.edu.unlam.pb2.criaturas;

public class CriaturaDomesticada extends Criatura {

	private final int ENERGIA_MAXIMA = 200;

	public CriaturaDomesticada(String nombre, Integer nivelDeEnergia, Afinidad afinidad) {
		super(nombre, nivelDeEnergia, afinidad);
	}

	@Override
	public void entrenar() {
		int nuevaEnergia = this.nivelDeEnergia + 15;
		if (nuevaEnergia > ENERGIA_MAXIMA) {
			nuevaEnergia = ENERGIA_MAXIMA;
		}
		this.setNivelDeEnergia(nuevaEnergia);
	}

	public void volverInestable() {

	}

	@Override
	public void pacificar() {

	}

	@Override
	public void reducirEnergia(int cantidad) {
		this.nivelDeEnergia -= 1;
	}
}