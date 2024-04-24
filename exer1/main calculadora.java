public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Bem-vindo à Calculadora Java!");
    System.out.println("1. Adicionar");
    System.out.println("2. Subtrair");
    System.out.println("3. Multiplicar");
    System.out.println("4. Dividir");
    System.out.print("Escolha uma opção: ");
    int opcao = scanner.nextInt();
    System.out.print("Digite o primeiro número: ");
    double num1 = scanner.nextDouble();
    System.out.print("Digite o segundo número: ");
    double num2 = scanner.nextDouble();

    switch (opcao) {
        case 1:
            System.out.println("Resultado: " + adicionar(num1, num2));
            break;
        case 2:
            System.out.println("Resultado: " + subtrair(num1, num2));
            break;
        case 3:
            System.out.println("Resultado: " + multiplicar(num1, num2));
            break;
        case 4:
            System.out.println("Resultado: " + dividir(num1, num2));
            break;
        default:
            System.out.println("Opção inválida!");
            break;
    }
    scanner.close();
}