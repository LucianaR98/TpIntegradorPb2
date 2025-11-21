package ar.edu.unlam.pb2.criaturas;

import java.util.Random;

public class CriaturaSalvaje extends Criatura {

	private Random random = new Random();

	public CriaturaSalvaje(String nombre, Integer nivelDeEnergia, Afinidad afinidad) {
		super(nombre, nivelDeEnergia, afinidad);
	}

	@Override
	public void entrenar() {
		int aumento = 10 + random.nextInt(31);
		int nuevaEnergia = this.nivelDeEnergia + aumento;

		if (nuevaEnergia > 200) {
			throw new EnergiaDesbordadaException("La criatura salvaje superó el límite de energía");
		}

		this.nivelDeEnergia = nuevaEnergia;
	}
}