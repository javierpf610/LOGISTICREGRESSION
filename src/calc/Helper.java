package calc;

public  class Helper {


    public static Double sigmoid(int position,double [] weights,double [][] x) {
        double result = weights[0];

        for (int i = 1; i < x[0].length; i++) {

            result += weights[i] * x[i][position];

        }

        return result;
    }

    public static Double clasification(double [] values,double [] inputs){
        double result = values[0];
        for (int i = 1; i < values.length; i++) {
            result += values[i] * inputs[i-1];
        }
        return 1/(1 + Math.exp(-result));
    }


}


