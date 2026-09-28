import entities.Conta;
import entities.ContaCorrente;
import entities.ContaPoupanca;
import entities.Titular;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Banco {
    public static void main(String[] args) {
        // Garante o uso de ponto (.) para casas decimais no console
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        // Primeira conta corrente instanciada
        Titular titularCorrente1 = new Titular("guilherme", 90123240189L);
        ContaCorrente contaCorrente1 = new ContaCorrente(21231241, titularCorrente1, 30);

        // Segunda conta corrente
        Titular titularCorrente2 = new Titular("Joao gabriel", 80830120801L);
        ContaCorrente contaCorrente2 = new ContaCorrente(23124121, titularCorrente2, 30);

        // Primeira conta poupanca instanciada
        Titular titularPoupanca1 = new Titular("Marcos henrrique", 90127865412L);
        var contaPoupanca1 = new ContaPoupanca(24121232, titularPoupanca1, 0.004);

        // Segunda conta poupanca
        Titular titularPoupanca2 = new Titular("Jose dos campos", 21231132143L);
        var contaPoupanca2 = new ContaPoupanca(64564574, titularPoupanca2, 0.004);

        List<Conta> contas = new ArrayList<>();

        contas.add(contaCorrente1);
        contas.add(contaCorrente2);
        contas.add(contaPoupanca1);
        contas.add(contaPoupanca2);

        contaCorrente1.depositar(1000);
        contaCorrente1.sacar(500);

        contaCorrente2.depositar(3000);
        contaCorrente2.sacar(1500);

        contaPoupanca1.depositar(1000);
        contaPoupanca1.sacar(500);

        contaPoupanca2.depositar(300);

        boolean valido = false;
        System.out.print("Digite um valor para sacar: ");
        while (!valido) {
            try {
                double valorSaque = Double.parseDouble(scanner.nextLine());
                contaPoupanca2.sacar(valorSaque);
                valido = true;
            } catch (IllegalStateException ex) {
                System.out.print("Entrada invalida: " + ex.getMessage() + " Tente novamente: ");
            } catch (NumberFormatException ex) {
                System.out.print("Valor invalido (digite um numero). Tente novamente: ");
            }
        }

        System.out.println("\n=== RELATÓRIO DE CONTAS ===");
        for (Conta conta : contas) {
            System.out.println("Número da Conta: " + conta.getNumero());
            System.out.println("Titular: " + conta.getTitular().getNome() + " | CPF: " + conta.getTitular().getCpf());
            System.out.printf("Saldo Base (em conta): R$ %.2f%n", conta.getSaldo());

            // Chama o método calcularSaldo() polimórfico de cada classe filha
            double saldoCalculado = conta.calcularSaldo();
            System.out.printf("Saldo Calculado (com taxa/rendimento): R$ %.2f%n", saldoCalculado);
            System.out.println("-----------------------------------");
        }

        scanner.close();
    }
}