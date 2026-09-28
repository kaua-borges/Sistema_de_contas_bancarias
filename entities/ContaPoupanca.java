package entities;

public class ContaPoupanca extends Conta {
    private double percentualRendimento;

    public ContaPoupanca(int numero, Titular titular, double percentualRendimento) {
        super(numero, titular);
        this.percentualRendimento = percentualRendimento;
    }

    public double getPercentualRendimento() {
        return percentualRendimento;
    }

    public void setPercentualRendimento(double percentualRendimento) {
        this.percentualRendimento = percentualRendimento;
    }

    @Override
    public double calcularSaldo() {
        return getSaldo() + (getSaldo() * percentualRendimento);
    }
}
