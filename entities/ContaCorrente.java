package entities;

public class ContaCorrente extends Conta {
    private double taxaManutencao;

    public ContaCorrente(int numero, Titular titular, double taxaManutencao) {
        super(numero, titular);
        this.taxaManutencao = taxaManutencao;
    }

    public double getTaxaManutencao() {
        return taxaManutencao;
    }

    public void setTaxaManutencao(double taxaManutencao) {
        this.taxaManutencao = taxaManutencao;
    }

    @Override
    public double calcularSaldo() {
        return getSaldo() - taxaManutencao;
    }
}
