package ar.edu.unlam.pb2.criaturas;

public abstract class TransformacionesDecorador extends Criatura {
	protected Criatura criatura;

	public TransformacionesDecorador(Criatura criatura) {
		super(criatura.getNombre(), criatura.getNivelDeEnergia(), criatura.getAfinidad());
		this.criatura = criatura;
	}

	@Override
    public Integer getNivelDeEnergia() {
        return criatura.getNivelDeEnergia();
    }

    @Override
    public void setNivelDeEnergia(Integer energia) {
        criatura.setNivelDeEnergia(energia);
    }

    @Override
    public Afinidad getAfinidad() {
        return criatura.getAfinidad();
    }

    @Override
    public Emocional getEstado() {
        return criatura.getEstado();
    }

    @Override
    public void volverInestable() {
        criatura.volverInestable();
    }

    public Criatura getCriaturaBase() {
        return criatura;
    }
}