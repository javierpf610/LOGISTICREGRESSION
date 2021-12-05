package agents;
import calc.Helper;
import calc.LogisticRegression;
import data.Dataset;
import jade.core.behaviours.OneShotBehaviour;

public class MyAgent extends jade.core.Agent {
    private AgentGUI myGUI;
    protected void setup() {
        myGUI=new AgentGUI(this);
        myGUI.showGui();
    }

    public void executeAgentSLR(final String entrada) {
        addBehaviour(new OneShotBehaviour() {
            public void action() {


                String pathSimple="src\\data\\datasetSimple.csv";
                Dataset dtS= new Dataset(pathSimple);
                LogisticRegression slr = new LogisticRegression(dtS);

                String [] userRawValues;

                userRawValues = entrada.split(",");

                double [] inputs = new double [userRawValues.length];

                for (int i = 0; i < userRawValues.length; i++) {
                    inputs[i] = Double.parseDouble(userRawValues[i]);
                }

                System.out.println(Helper.clasification(slr.calculate(),inputs));

                //Double ans=Helper.clasification(slr.calculate(),inputs);
                //Helper.analize(ans);
                //System.out.println(ans);


            }
        } );

    }
    public void executeAgentMLR(final String entrada) {
        addBehaviour(new OneShotBehaviour() {
            public void action() {
                String pathMultiple="src\\data\\datasetMultiple.csv";
                //String pathMultiple="src\\data\\diabetes.csv";
                Dataset dtM= new Dataset(pathMultiple);
                LogisticRegression mlr = new LogisticRegression(dtM);
                String [] userRawValues;

                userRawValues = entrada.split(",");

                double [] inputs = new double [userRawValues.length];

                for (int i = 0; i < userRawValues.length; i++) {
                    inputs[i] = Double.parseDouble(userRawValues[i]);
                }

                Double ans=Helper.clasification(mlr.calculate(),inputs);
                Helper.analize(ans);
                System.out.println(ans);


            }
        } );

    }

}
