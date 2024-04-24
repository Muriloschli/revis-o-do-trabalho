import java.util.*;

class Livro {
    String titulo;
    String autor;
    int ano;

    // Construtor
    Livro(String titulo, String autor, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    // Método para exibir informações do livro
    void exibirInfo() {
        System.out.println("Título: " + this.titulo);
        System.out.println("Autor: " + this.autor);
        System.out.println("Ano: " + this.ano);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Livro> biblioteca = new ArrayList<>();

        while (true) {
            System.out.println("1. Adicionar livro");
            System.out.println("2. Exibir livros");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.print("Digite o título do livro: ");
                String titulo = scanner.next();
                System.out.print("Digite o autor do livro: ");
                String autor = scanner.next();
                System.out.print("Digite o ano de publicação do livro: ");
                int ano = scanner.nextInt();

                Livro livro = new Livro(titulo, autor, ano);
                biblioteca.add(livro);

            } else if (opcao == 2) {
                for (Livro livro : biblioteca) {
                    livro.exibirInfo();
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
