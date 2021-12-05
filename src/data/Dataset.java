package data;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.FileReader;
import java.util.List;


public class Dataset {

private double [][] data;
String path;


    public Dataset(String path) {
        this.path = path;
        readData();
    }

    public double[][] getData() {
        return data;
    }

    public void setData(double[][] data) {
        this.data = data;
    }

    public void readData() {
        try {
            FileReader filereader = new FileReader(path);
            CSVReader csvReader = new CSVReaderBuilder(filereader).build();
            List<String[]> csvData = csvReader.readAll();

            int pivotForIndex = csvData.get(0).length;

            data= new double[csvData.size()][pivotForIndex];
            for (int i = 0 ; i < csvData.size(); i++){
                for (int j=0;j<pivotForIndex;j++){
                    String[] row = csvData.get(i);
                    data[i][j] = Double.parseDouble(row[j]);

                }

            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }


    public double[][] getX(){
        double[][] x = new double[data.length][data[0].length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 1; j <data[0].length ; j++) {
                x[i][0] =1;
                x[i][j] =data[i][j-1];
            }
        }
        return x;
    }

    public double [][] getY(){

        double [][] y= new double[data.length][1];

        for(int i=0;i<y.length;i++){
            y[i][0]=data[i][data[0].length-1];
        }

        return y;
    }

    public double [] getWs(){
        double []ws =new double[getX()[0].length];
        for (int i = 0; i <ws.length ; i++) {
            ws[i] = 0.0;
        }
        return ws;

    }

    public static void print(double [][] data){
        for (int x=0; x < data.length; x++) {
            System.out.print("|");
            for (int y=0; y < data[x].length; y++) {
                System.out.print (data[x][y]);
                if (y!=data[x].length-1) System.out.print("\t");
            }
            System.out.println("|");
        }


    }

    public static void print(double[] data){
        for(int i=0;i< data.length;i++){
            System.out.print(data[i]);
            System.out.print(",");
        }
    }

}
