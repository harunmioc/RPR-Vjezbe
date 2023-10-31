import java.util.Scanner;
public class LV2_Z1 {

    public static double Sinus (double broj){
        return Math.sin(broj);
    }

    public static long Faktorijel (double broj){
        if (broj<0)
            throw new IllegalArgumentException("Faktorijel se ne može izračunati za negativan broj.");

        if(broj==0 || broj==1)
            return 1;
        else{
            long faktorijel=1;
            for(int i=2; i<= broj; i++){
                faktorijel=faktorijel * i;
            }
        return faktorijel;
        }
    }

    public static void main(String[] args) {

        for(int i=0; i<args.length; i++){
            String br=args[i];
            int broj =Integer.parseInt(args[i]);

            System.out.println("sin("+ br + ")= " + Sinus(broj));
            System.out.println(broj+ "! = " + Faktorijel(broj));
        }
    }

}