import java.util.Scanner;

//C para Celsius e F para Fahrenheit nos comentários

public class Main{
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ConversorTemperatura conversor = new ConversorTemperatura();
        int op;

        do { //pra ficar rodando até o usuário pedir pra sair
            //Menu para o usuário escolher a opção desejada
            System.out.println("1 - Converter de Celsius para Fahrenheit\n2 - Converter de Fahrenheit para Celsius\n3 - Converter de Celsius para Fahrenheit com opção de arredondamento e de ajuste\n4 - Múltiplos valores que passam por todas as funções\n5 - Sair\nInsira a opção desejada: ");
            op = teclado.nextInt();
            teclado.nextLine(); //limpa pro próximo input

            switch (op) {
                case 1: //converter de C para F
                    System.out.println("Insira o valor em graus Celsius que gostaria de converter: ");
                    int C = teclado.nextInt();
                    teclado.nextLine();
                    double F = conversor.converte(C);
                    System.out.println(C + " graus Celsius equivalem a "+ String.format("%.2f", F) + " graus Fahrenheit");
                    break;

                case 2: //converter de F para C
                    System.out.println("Insira o valor em graus Fahrenheit que gostaria de converter: ");
                    F = teclado.nextDouble();
                    teclado.nextLine();
                    double C2 = conversor.converte(F);
                    System.out.println(String.format("%.2f", F) + " graus Fahrenheit equivalem a "+ String.format("%.2f", C2) + " graus Celsius");
                    break;

                case 3: //converter de C para F com ajuste e arredondamento
                    System.out.println("Insira o valor em graus Celsius que gostaria de converter: ");
                    C2 = teclado.nextDouble();
                    teclado.nextLine();
                    System.out.println("De quanto você gostaria que fosse o ajuste extra? (Se não quiser ajuste, coloque 0): ");
                    int A = teclado.nextInt();
                    teclado.nextLine();
                    System.out.println("Gostaria de arredondar o resultado? (Y/N): ");
                    char R = teclado.next().charAt(0);
                    F = conversor.converte(C2, A, R);
                    System.out.println(String.format("%.2f", C2) + " graus Celsius equivalem a "+ F + " graus Fahrenheit com ajuste de " + A+ "\n");
                    break;

                case 4: 
                    System.out.println("Quantos valores você gostaria de inserir: ");
                    int num = teclado.nextInt();
                    teclado.nextLine();
                    int[] vetor = new int[num];
                    for (int i = 0; i < vetor.length; i++) {
                        System.out.printf("Insira o "+ (i+1) +"° valor em Celsius:");
                        vetor[i] = teclado.nextInt();
                    }
                    System.out.println("De quanto você gostaria que fosse o ajuste extra? (Se não quiser ajuste, coloque 0): ");
                    A = teclado.nextInt();
                    teclado.nextLine();

                    conversor.converte(vetor, A);
                    break;

                case 5:
                    System.out.println("\u001B[31m" + "Saindo do programa..." + "\u001B[0m"); // texto fica vermelhinho 
                    break;

                default:
                    System.out.println("A opção inserida não está entre as alternativas.");
                    break;
            }
        } while (op!=5);        
    }
}