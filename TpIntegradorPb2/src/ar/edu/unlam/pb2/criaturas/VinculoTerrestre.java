package ar.edu.unlam.pb2.criaturas;

public class VinculoTerrestre extends TransformacionesDecorador {

	private final Integer LIMITE_MIN_ENERGIA = 50;

	public VinculoTerrestre(Criatura criatura) {
		super(criatura);
	}

	@Override
	public void entrenar() {
		this.criatura.entrenar();
	}

	@Override
	public void pacificar() {
		this.criatura.pacificar();
	}

	@Override
	public void reducirEnergia(int cantidad) {
		this.criatura.reducirEnergia(cantidad);

		Integer energia = this.criatura.getNivelDeEnergia();

		if (energia < LIMITE_MIN_ENERGIA) {
			this.criatura.setNivelDeEnergia(LIMITE_MIN_ENERGIA);
		}

		if (this.criatura instanceof CriaturaAncestral &&
		    this.criatura.getNivelDeEnergia() < 100) {
			this.criatura.setNivelDeEnergia(100);
		}
	}
}