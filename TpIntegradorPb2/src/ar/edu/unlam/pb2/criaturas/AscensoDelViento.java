package ar.edu.unlam.pb2.criaturas;

public class AscensoDelViento extends TransformacionesDecorador {

    private Afinidad afinidadOriginal;

    public AscensoDelViento(Criatura criatura) {
        super(criatura);
        this.afinidadOriginal = criatura.getAfinidad();
    }

    @Override
    public Afinidad getAfinidad() {
        return Afinidad.AIRE;
    }

    @Override
    public void entrenar() {
        criatura.entrenar();
    }

    @Override
    public void pacificar() {
        criatura.pacificar();
    }

    @Override
    public void reducirEnergia(int cantidad) {
        criatura.reducirEnergia(cantidad);
    }

    public Afinidad getAfinidadOriginal() {
        return this.afinidadOriginal;
    }
}