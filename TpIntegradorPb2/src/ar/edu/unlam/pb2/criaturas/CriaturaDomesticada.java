package ar.edu.unlam.pb2.criaturas;

public class CriaturaDomesticada extends Criatura {

	public CriaturaDomesticada(String nombre, Integer nivelDeEnergia, Afinidad afinidad) {
		super(nombre, nivelDeEnergia, afinidad);
	}

	@Override
	public void entrenar() {
		int nuevaEnergia = this.nivelDeEnergia + 15;
		if (nuevaEnergia > 200) {
			nuevaEnergia = 200;
		}
		this.nivelDeEnergia = nuevaEnergia;
	}

	public void volverInestable() {

	}
}