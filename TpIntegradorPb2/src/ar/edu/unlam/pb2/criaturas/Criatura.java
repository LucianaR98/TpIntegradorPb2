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
	
	public void setNivelDeEnergia(Integer nivelDeEnergia) {
		this.nivelDeEnergia = nivelDeEnergia;
		this.ajustarEnergiaEntre0y200();
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
	
	//CAMBIOS A VERIFICAR
		public abstract void entrenar();
		
		public abstract void pacificar();

		
		public void volverInestable() {
			this.estado = Emocional.INESTABLE;
	 }

		public abstract void reducirEnergia(int cantidad);


		public Boolean esCriaturaAncestral() {
			return false;
		}
}