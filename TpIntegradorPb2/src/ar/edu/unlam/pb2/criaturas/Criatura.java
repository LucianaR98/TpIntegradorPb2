package ar.edu.unlam.pb2.criaturas;

public abstract class Criatura {

	protected String nombre;
	protected Integer nivelDeEnergia;
	protected Afinidad afinidad;
	protected Emocional estado;

	public Criatura(String nombre, Integer nivelDeEnergia, Afinidad afinidad) {
		this.nombre = nombre;
		this.nivelDeEnergia = nivelDeEnergia;
		this.afinidad = afinidad;
		this.estado = Emocional.TRANQUILA;
		ajustarEnergiaEntre0y200();
	}


	public String getNombre() {
		return nombre;
	}

	public Integer getNivelDeEnergia() {
		return nivelDeEnergia;
	}

	public Afinidad getAfinidad() {
		return afinidad;
	}

	public Emocional getEstado() {
		return estado;
	}

	protected void ajustarEnergiaEntre0y200() {
		if (this.nivelDeEnergia < 0) {
			this.nivelDeEnergia = 0;
		}
		if (this.nivelDeEnergia > 200) {
			this.nivelDeEnergia = 200;
		}
	}

	public abstract void entrenar();

	public void pacificar() {
		this.estado = Emocional.TRANQUILA;
	}
}