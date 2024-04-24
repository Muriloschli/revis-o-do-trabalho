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