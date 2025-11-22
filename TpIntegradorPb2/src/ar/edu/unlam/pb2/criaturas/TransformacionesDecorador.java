package ar.edu.unlam.pb2.criaturas;

public abstract class TransformacionesDecorador extends Criatura {
	protected Criatura criatura;

	public TransformacionesDecorador(Criatura criatura) {
		super(criatura.getNombre(), criatura.getNivelDeEnergia(), criatura.getAfinidad());
		this.criatura = criatura;
	}

	@Override
	public void entrenar() {

	}

	@Override
	public void pacificar() {

	}

	@Override
	public void reducirEnergia(int cantidad) {

	}

    public Criatura getCriaturaBase() {
        return criatura;
    }
}
