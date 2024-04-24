import java.util.Scanner;

public class Carro {
    private String marca;
    private String modelo;
    private int ano;
    private String placa;
    private int velocidadeAtual;

    public Carro(String marca, String modelo, int ano, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.velocidadeAtual = 0;
    }

    public void acelerar() {
        velocidadeAtual += 10;
    }

    public void frear() {
        if (velocidadeAtual > 0) {
            velocidadeAtual -= 10;
        }
    }

    public void exibirInformacoes() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
        System.out.println("Placa: " + placa);
        System.out.println("Velocidade Atual: " + velocidadeAtual);
    }

    public static void main(String[] args) {
        Carro carro = new Carro("Ford", "Mustang", 1968, "ABC-1234");
        Scanner scanner = new Scanner(System.in);
        String opcao = "";

        while (!opcao.equals("sair")) {
            System.out.println("Digite 'acelerar', 'frear' ou 'info' para exibir as informações do carro. Digite 'sair' para sair.");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "acelerar":
                    carro.acelerar();
                    break;
                case "frear":
                    carro.frear();
                    break;
                case "info":
                    carro.exibirInformacoes();
                    break;
                case "sair":
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }
}

