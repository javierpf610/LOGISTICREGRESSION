package calc;

import data.dataset;
import calc.Helper;

public class LogisticRegression {
    dataset data;
    private double [][] x;
    private double [][] y;
    double[] Ws;
    private double alpha = 0.001;
    private int interation=80000;


    public LogisticRegression(dataset data) {
        this.data = data;
        x=data.getX();
        y=data.getY();
        Ws=data.getWs();
    }

    public double[] getWs() {
        return Ws;
    }

    public double[] calculate() {
        double[] ansClean = new double[x[0].length];
        for (int i = 0; i < interation; i++) {

            double[] WsNew = new double[Ws.length];
            double sigma = 0;

            for (int j = 0; j < x.length; j++) {
                for (int k = 0; k < x[0].length; k++) {

                    sigma += ((1 / ( 1 + Math.exp( - Helper.sigmoid(k,Ws,x))))- y[k][0] ) * x[j][k];


                }

                WsNew[j] = Ws[j] - (alpha * sigma);
                sigma = 0;


            }
            System.arraycopy(WsNew, 0, Ws, 0, x[0].length);
        }
        System.arraycopy(Ws, 0, ansClean, 0, ansClean.length);
        return ansClean;
    }



}

