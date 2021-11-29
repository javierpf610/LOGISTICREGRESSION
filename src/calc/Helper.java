package calc;

import java.util.Arrays;

public  class Helper {


    public static Double sigmoid(int position,double [] weights,double [][] x) {
        double result = weights[0];

        for (int i = 1; i < x[0].length; i++) {

            result += weights[i] * x[i][position];

        }

        return result;
    }

    public static Double clasification(double [] values,double [] inputs){
        System.out.println("Ws:");
        System.out.println(Arrays.toString(values));

        System.out.println(Arrays.toString(inputs));

        double result = values[0];
        for (int i = 1; i < values.length; i++) {
            result += values[i] * inputs[i-1];
        }
        return 1/(1 + Math.exp(-result));
    }


}


