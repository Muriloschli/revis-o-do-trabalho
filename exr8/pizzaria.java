import java.util.*;

class Pizza {
    private String nome;
    private double valor;
    private List<String> ingredientes;

    public Pizza(String nome, double valor, List<String> ingredientes) {
        this.nome = nome;
        this.valor = valor;
        this.ingredientes = ingredientes;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }
}

class Pedido {
    private Pizza pizza;
    private String enderecoEntrega;

    public Pedido(Pizza pizza, String enderecoEntrega) {
        this.pizza = pizza;
        this.enderecoEntrega = enderecoEntrega;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Pizza> pizzas = new ArrayList<>();
        List<Pedido> pedidos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String opcao = "";

     
        pizzas.add(new Pizza("Margherita", 20.0, Arrays.asList("Molho de tomate", "Mozzarella", "Manjericão")));
        pizzas.add(new Pizza("Pepperoni", 25.0, Arrays.asList("Molho de tomate", "Mozzarella", "Pepperoni")));

        while (!opcao.equals("sair")) {
            System.out.println("Digite 'pedido' para fazer um pedido, 'relatorio' para gerar um relatório dos pedidos ou 'sair' para sair.");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "pedido":
                    System.out.println("Escolha uma pizza:");
                    for (int i = 0; i < pizzas.size(); i++) {
                        Pizza pizza = pizzas.get(i);
                        System.out.println((i + 1) + ". " + pizza.getNome() + " - " + pizza.getValor());
                    }
                    int escolha = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over
                    Pizza pizzaEscolhida = pizzas.get(escolha - 1);
                    System.out.println("Digite o endereço de entrega:");
                    String enderecoEntrega = scanner.nextLine();
                    Pedido pedido = new Pedido(pizzaEscolhida, enderecoEntrega);
                    pedidos.add(pedido);
                    System.out.println("Pedido realizado com sucesso!");
                    break;
                case "relatorio":
                    double valorTotal = 0.0;
                    for (Pedido pedido : pedidos) {
                        Pizza pizza = pedido.getPizza();
                        System.out.println("Pizza: " + pizza.getNome() + ", Endereço de Entrega: " + pedido.getEnderecoEntrega());
                        valorTotal += pizza.getValor();
                    }
                    System.out.println("Número total de pedidos: " + pedidos.size());
                    System.out.println("Valor médio dos pedidos: " + (valorTotal / pedidos.size()));
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
