public class ConversorTemperatura {
    public double converte(int Celsius){ //função que converte de Celsius (int) para Fahrenheit (double) sem arredondamento ou ajuste
        double F = Celsius*1.8 + 32; //transforma em fahrenheit
        return F;
    }

    public double converte(double F){ //função que converte Fahrenheit (double) em Celsius (double) sem arredondamento ou ajuste
        double C = (5.0/9.0) * (F - 32); //transforma em celsius
        return C;
    }

    //retorna double pq pode ser tanto inteiro quando um número com vírgula, depende se o usuário quer ou não arredondar
    public double converte(double C, int A, char B) { //função que converte Celsius (double) em Fahrenheit. A é o ajuste desejado pelo usuário e B é se ele quer ou não arredondamento
        double F = (double) (C * 1.8 + 32); //transforma em fahrenheit
    
        F = F+A; //faz o ajuste
        
        if (B == 'Y' || B == 'y') {
            return Math.round(F); //arredonda 
        }

        return F;
    }
    
    public void converte(int[] vetor, int A){ //a função recbee como argumentos o vetor q vetor q vai mudar e de quanto será o ajuste
        double F;
        double C;
        double[] R = new double[vetor.length];        
        for (int i = 0; i < vetor.length; i++) {
            if (i % 2 ==0) { //intercala entre texto amarelinho e texto normal pra deixar mais bonito e compreensível
                System.out.println("\u001B[33m"); 
            } else{
                System.out.println("\u001B[0m");
            }
            //C para F
            F = converte(vetor[i]);
            System.out.println(vetor[i] + " graus Celsius equivalem a "+ String.format("%.2f", F) + " graus Fahrenheit");

            //F para C
            C = converte(F);
            System.out.println(String.format("%.2f", F) + " graus Fahrenheit equivalem a "+ String.format("%.2f", C) + " graus Celsius");

            //C para F com arredondamento e ajuste
            R[i] = converte(C, A, 'Y');
            System.out.println(String.format("%.2f", C) + " graus Celsius equivalem a "+ R[i] + " graus Fahrenheit com ajuste de " + A + " e arredondamento.");
        }

        System.out.println("\u001B[0m"); //volta para a cor normal
    }
}
