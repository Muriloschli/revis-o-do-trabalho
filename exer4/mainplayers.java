public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Jogador> jogadores = new ArrayList<>();

        while (true) {
            System.out.println("1. Criar jogador");
            System.out.println("2. Realizar operações");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.print("Digite o nome do jogador: ");
                String nome = scanner.next();

                Jogador jogador = new Jogador(nome);
                jogadores.add(jogador);

            } else if (opcao == 2) {
                System.out.print("Digite o nome do jogador: ");
                String nome = scanner.next();
                Jogador jogador = null;
                for (Jogador j : jogadores) {
                    if (j.nome.equals(nome)) {
                        jogador = j;
                        break;
                    }
                }
                if (jogador == null) {
                    System.out.println("Jogador não encontrado.");
                    continue;
                }

                System.out.println("1. Aumentar pontuação");
                System.out.println("2. Subir de nível");
                System.out.println("3. Exibir informações");
                System.out.print("Escolha uma operação: ");
                int operacao = scanner.nextInt();

                if (operacao == 1) {
                    System.out.print("Digite a quantidade de pontos a adicionar: ");
                    int pontos = scanner.nextInt();
                    jogador.aumentarPontuacao(pontos);
                } else if (operacao == 2) {
                    jogador.subirNivel();
                } else if (operacao == 3) {
                    jogador.exibirInfo();
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