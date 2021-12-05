package calc;

import data.Dataset;

public class LogisticRegression {
    Dataset data;
    private double [][] x;
    private double [][] y;
    double[] Ws;
    //Multiple
   // private double alpha = 0.0005;
    //private int interation=10000;
    //
    private double alpha = 0.0005;
    private int interation=8000;

    public LogisticRegression(Dataset data) {
        this.data = data;
        x=data.getX();
        y=data.getY();
        Ws=data.getWs();
    }

    public double[] calculate() {
        double[] ansClean = new double[x[0].length];
        for (int i = 0; i < interation; i++) {

            double[] WsNew = new double[Ws.length];
            double sigma = 0;

            for (int j = 0; j < x[0].length; j++) {
                for (int k = 0; k < x.length; k++) {

                    sigma += ((1 / ( 1 + Math.exp( - Helper.sigmoid(k,Ws,x))))- y[k][0] ) * x[k][j];
                    //sigma += ((1 / ( 1 + (Math.exp( - sigmoid(k)))))- y[k][0] ) * x[k][j];

                }

                WsNew[j] = Ws[j] - (alpha * sigma);
                sigma = 0;
                //System.arraycopy(WsNew, 0, Ws, 0, x[0].length);
            }
            System.arraycopy(WsNew, 0, Ws, 0, x[0].length);


        }
        System.arraycopy(Ws, 0, ansClean, 0, ansClean.length);
        return ansClean;
    }
    public  Double sigmoid(int position) {
        double result = Ws[0];

        for (int i = 1; i < x[0].length; i++) {

            result += Ws[i] * x[position][i];

        }

        return result;
    }


}

