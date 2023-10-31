package org.example;
import java.util.List;

public class MathUtils {

    public static Double min (List <Double> numbers){
        double min = Double.MAX_VALUE;
        for (Double num : numbers){
            if(num.doubleValue() < min){
                min = num.doubleValue();
            }
        }
        return min;
    }

    public static Double max (List<Double> numbers){
        double max = Double.MIN_VALUE;
        for(Double num : numbers){
            if(num.doubleValue() > max){
                max= num.floatValue();
            }
        }
        return max;
    }

    public static Double mean ( List<Double> numbers){
        double sum=0;
        for(Double num : numbers){
            sum+= num.doubleValue();
        }
        return sum/numbers.size();
    }

    public static Double stdev ( List <Double> numbers){
        Double mean = MathUtils.mean(numbers);
        float standDev=0;
        for(Double num: numbers){
            standDev+=Math.pow(num-mean,2);
        }
        return Math.sqrt(standDev/numbers.size());
    }

 }


