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