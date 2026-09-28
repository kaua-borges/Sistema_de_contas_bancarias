package entities;

public class Conta {
    private int numero;
    private double saldo;
    private Titular titular;

    public Conta(int numero, Titular titular) {
        this.numero = numero;
        this.saldo = 0.0;
        this.titular = titular;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Titular getTitular() {
        return titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    public double calcularSaldo() {
        return saldo;
    }

    public double depositar(double valorDeposito) {
        this.saldo += valorDeposito;
        return this.saldo;
    }

    public double sacar(double valorSaque) {
        if (this.saldo < valorSaque) {
            throw new IllegalStateException("Nao foi possivel realizar um saque, saldo indisponivel.");
        }

        this.saldo -= valorSaque;
        return this.saldo;
    }
}