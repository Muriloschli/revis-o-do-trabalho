import java.util.*;

class ContaBancaria {
    String numeroConta;
    String nomeTitular;
    double saldo;

   
    ContaBancaria(String numeroConta, String nomeTitular, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        this.saldo = saldoInicial;
    }

    void depositar(double valor) {
        this.saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso!");
    }

   
    void sacar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente para realizar o saque.");
        }
    }

    
    void consultarSaldo() {
        System.out.println("Saldo atual: R$" + this.saldo);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ContaBancaria> contas = new ArrayList<>();

        while (true) {
            System.out.println("1. Criar conta");
            System.out.println("2. Realizar operações");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.print("Digite o número da conta: ");
                String numeroConta = scanner.next();
                System.out.print("Digite o nome do titular: ");
                String nomeTitular = scanner.next();
                System.out.print("Digite o saldo inicial: ");
                double saldoInicial = scanner.nextDouble();

                ContaBancaria conta = new ContaBancaria(numeroConta, nomeTitular, saldoInicial);
                contas.add(conta);

            } else if (opcao == 2) {
                System.out.print("Digite o número da conta: ");
                String numeroConta = scanner.next();
                ContaBancaria conta = null;
                for (ContaBancaria c : contas) {
                    if (c.numeroConta.equals(numeroConta)) {
                        conta = c;
                        break;
                    }
                }
                if (conta == null) {
                    System.out.println("Conta não encontrada.");
                    continue;
                }

                System.out.println("1. Depositar");
                System.out.println("2. Sacar");
                System.out.println("3. Consultar saldo");
                System.out.print("Escolha uma operação: ");
                int operacao = scanner.nextInt();

                if (operacao == 1) {
                    System.out.print("Digite o valor a depositar: ");
                    double valor = scanner.nextDouble();
                    conta.depositar(valor);
                } else if (operacao == 2) {
                    System.out.print("Digite o valor a sacar: ");
                    double valor = scanner.nextDouble();
                    conta.sacar(valor);
                } else if (operacao == 3) {
                    conta.consultarSaldo();
                } else {
                    System.out.println("Operação inválida. Tente novamente.");
                }

            } else if (opcao == 3) {
                break;

            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
