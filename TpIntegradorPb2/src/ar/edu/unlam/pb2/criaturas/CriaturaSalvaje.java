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

		// Nuevo if
		if (nuevaEnergia > 100) {
			this.volverInestable();
		}

		this.setNivelDeEnergia(nuevaEnergia);
	}
	
////CAMBIOS A VERIFICAR
	
	@Override
	public void reducirEnergia(int cantidad) {
		this.nivelDeEnergia -= cantidad;
	}
	
	@Override
	public void pacificar() {
		if (this.getEstado().equals(Emocional.INESTABLE)) {
		this.reducirEnergia(50);
		this.estado = Emocional.TRANQUILA;
		}
	}
}