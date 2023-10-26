package ba.unsa.etf.rpr;

import  java.util.Scanner;

public class Ispis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesite prvi broj: ");
        int prvi = scanner.nextInt();
        System.out.println("Unesite drugi broj: ");
        int drugi = scanner.nextInt();

        System.out.println("Prvi: "+ prvi);
        System.out.println("Drugi: "+ drugi);

    }
}