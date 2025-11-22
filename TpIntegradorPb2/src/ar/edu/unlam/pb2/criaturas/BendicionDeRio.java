package ar.edu.unlam.pb2.criaturas;

public class BendicionDeRio extends TransformacionesDecorador {

	public BendicionDeRio(Criatura criatura) {
		super(criatura);

	}

	@Override
	public void entrenar() {
		this.criatura.entrenar();

		Integer nuevaEnergia = this.criatura.getNivelDeEnergia() * 2;

		if (nuevaEnergia > 180) {
			nuevaEnergia = 180;
		}

		this.setNivelDeEnergia(nuevaEnergia);

	}

	@Override
	public void pacificar() {
		criatura.pacificar();

	}

	@Override
	public void reducirEnergia(int cantidad) {
		criatura.reducirEnergia(cantidad);

	}

}
