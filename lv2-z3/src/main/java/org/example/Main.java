package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Double>  numbers = new ArrayList<Double>();

        while ( true){
            System.out.println("Unesite broj ili rijec stop: ");
            String line = scanner.nextLine();

            if("stop".equalsIgnoreCase(line)){
                break;
            }
            try{
                Double number = Double.parseDouble(line);
                numbers.add(number);

            }catch(Exception e){
                System.out.println("Uneseni string nije broj!");
                continue;
            }

        }

        System.out.println("Rezultati: ");
        System.out.println("MIN: " + MathUtils.min(numbers));
        System.out.println("MAX: "+ MathUtils.max(numbers));
        System.out.println("MEAN: " + MathUtils.mean(numbers));
        System.out.println("STDEV: " + MathUtils.stdev(numbers));

    }
}