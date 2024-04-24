import java.util.*;

class Contato {
    private String nome;
    private String telefone;

    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }
}

class Agenda {
    private List<Contato> contatos;

    public Agenda() {
        contatos = new ArrayList<>();
    }

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
    }

    public Contato buscarContato(String nome) {
        for (Contato contato : contatos) {
            if (contato.getNome().equals(nome)) {
                return contato;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner scanner = new Scanner(System.in);
        String opcao = "";

        while (!opcao.equals("sair")) {
            System.out.println("Digite 'adicionar' para adicionar um contato, 'buscar' para buscar um contato por nome ou 'sair' para sair.");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "adicionar":
                    System.out.println("Digite o nome do contato:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o telefone do contato:");
                    String telefone = scanner.nextLine();
                    Contato contato = new Contato(nome, telefone);
                    agenda.adicionarContato(contato);
                    System.out.println("Contato adicionado com sucesso!");
                    break;
                case "buscar":
                    System.out.println("Digite o nome do contato que deseja buscar:");
                    nome = scanner.nextLine();
                    contato = agenda.buscarContato(nome);
                    if (contato != null) {
                        System.out.println("Nome: " + contato.getNome() + ", Telefone: " + contato.getTelefone());
                    } else {
                        System.out.println("Contato não encontrado!");
                    }
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
