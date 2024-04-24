import java.util.*;

class Produto {
    private String nome;
    private String codigo;
    private double preco;
    private int quantidadeEmEstoque;

    public Produto(String nome, String codigo, double preco, int quantidadeEmEstoque) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }
}

public class Main {
    public static void main(String[] args) {
        Map<String, Produto> estoque = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String opcao = "";

        while (!opcao.equals("sair")) {
            System.out.println("Digite 'adicionar' para adicionar um produto, 'atualizar' para atualizar um produto, 'remover' para remover um produto, 'relatorio' para gerar um relatório do estoque ou 'sair' para sair.");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "adicionar":
                    System.out.println("Digite o nome do produto:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o código do produto:");
                    String codigo = scanner.nextLine();
                    System.out.println("Digite o preço do produto:");
                    double preco = scanner.nextDouble();
                    System.out.println("Digite a quantidade em estoque do produto:");
                    int quantidadeEmEstoque = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over
                    Produto produto = new Produto(nome, codigo, preco, quantidadeEmEstoque);
                    estoque.put(codigo, produto);
                    System.out.println("Produto adicionado com sucesso!");
                    break;
                case "atualizar":
                    System.out.println("Digite o código do produto que deseja atualizar:");
                    codigo = scanner.nextLine();
                    produto = estoque.get(codigo);
                    if (produto != null) {
                        System.out.println("Digite o novo preço do produto:");
                        preco = scanner.nextDouble();
                        System.out.println("Digite a nova quantidade em estoque do produto:");
                        quantidadeEmEstoque = scanner.nextInt();
                        scanner.nextLine(); // Consume newline left-over
                        produto.setPreco(preco);
                        produto.setQuantidadeEmEstoque(quantidadeEmEstoque);
                        System.out.println("Produto atualizado com sucesso!");
                    } else {
                        System.out.println("Produto não encontrado!");
                    }
                    break;
                case "remover":
                    System.out.println("Digite o código do produto que deseja remover:");
                    codigo = scanner.nextLine();
                    produto = estoque.remove(codigo);
                    if (produto != null) {
                        System.out.println("Produto removido com sucesso!");
                    } else {
                        System.out.println("Produto não encontrado!");
                    }
                    break;
                case "relatorio":
                    double valorTotalEmEstoque = 0.0;
                    for (Produto p : estoque.values()) {
                        System.out.println("Nome: " + p.getNome() + ", Código: " + p.getCodigo() + ", Preço: " + p.getPreco() + ", Quantidade em Estoque: " + p.getQuantidadeEmEstoque());
                        valorTotalEmEstoque += p.getPreco() * p.getQuantidadeEmEstoque();
                    }
                    System.out.println("Valor total em estoque: " + valorTotalEmEstoque);
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
