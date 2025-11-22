package ar.edu.unlam.pb2.criaturas;

public class LlamaInterna extends TransformacionesDecorador {
	private Integer energiaGanada = 30;

	public LlamaInterna(Criatura criatura) {
		super(criatura);

	}

	@Override
	public void entrenar() {
		this.criatura.entrenar();

		if (this.criatura.getAfinidad().equals(Afinidad.FUEGO)) {
			Integer nuevaEnergia = this.criatura.getNivelDeEnergia() + energiaGanada;
			this.setNivelDeEnergia(nuevaEnergia);
		} else {
			this.volverInestable();
		}

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
