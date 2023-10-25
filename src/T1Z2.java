import  java.util.Scanner;

public class T1Z2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Unesite broj: ");
        int broj = scanner.nextInt();

        for (int i=1; i<=broj; i++){
            if(DjeljivSaSvojomSumomCifara(i)){
                System.out.println(i);
            }
        }

    }
    private static boolean DjeljivSaSvojomSumomCifara(int broj){
        int Suma= SumaCifara(broj);
        return broj%Suma==0;
    }

    private static int SumaCifara(int broj){
        int suma=0;
        while(broj>0){
            suma+=broj%10;
            broj=broj/10;
        }
        return suma;
    }
}