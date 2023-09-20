package function;
import chart.BarChart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecondDegree {
    private int exponentTwo,
            exponentOne,
            exponentZero;
    private BarChart output;

    public SecondDegree(int exponentTwo, int exponentOne, int exponentZero) {
        this.exponentTwo = exponentTwo;
        this.exponentOne = exponentOne;
        this.exponentZero = exponentZero;
        this.output = null;
    }

    public void connect(BarChart output) {
        this.output = output;
    }
    public void present() {

        double delta = determineDelta(exponentTwo, exponentOne, exponentZero);

        if (output != null) {
            if( delta > 0) {
                List<Integer> interval = determineGraphInterval(exponentTwo, exponentOne, exponentZero, delta);

                double median =  determineMedian(interval);
                double mean = (double)interval.size() / 2.00;

                if (interval.size() % 2 != 0) {
                    int valueToPlot = 1;
                    for (int i = 1; i <= interval.size(); i++){

                        if(i < mean){
                            output.plot(valueToPlot);
                            valueToPlot++;
                        }
                        else if(i > mean && i % mean == 0.5)
                            output.plot(valueToPlot);
                        else{
                            valueToPlot --;
                            output.plot(valueToPlot);
                        }
                    }
                }
                else {
                    int valueToPlot = 1;
                    for (int i = 1; i <= interval.size(); i++) {

                        if(i -median <= -1) {
                            output.plot(valueToPlot);
                            valueToPlot++;
                        }
                        else if(i -median > -1 && i -median < 0)
                        {
                            output.plot(valueToPlot);
                        }
                        else if(i -median > 0 && i -median < 1)
                        {
                            output.plot(valueToPlot);
                        }
                        else{
                            valueToPlot --;
                            output.plot(valueToPlot);
                        }
                    }
                }
            }
        }
    }

    private double determineDelta(int expTwo, int expOne, int expZero){
        return expOne*expOne - 4*expTwo*expZero;
    }
    private double determineMedian(List<Integer> list){

        Arrays.sort(new List[]{list});
        int n = list.size();
        // check for even case
        if (n % 2 != 0)
            return (double) list.get(n / 2);

        return (double)(list.get((n - 1) / 2) + list.get(n / 2)) / 2.0;
    }
    private List<Integer> determineGraphInterval(int expTwo, int expOne, int expZero, double delt) {
        List<Integer> listedRoots = new ArrayList<>();

        double val1 = (-exponentOne + Math.pow(delt, 0.5)) / (2.0 * exponentTwo);
        double val2 = (-exponentOne - Math.pow(delt, 0.5)) / (2.0 * exponentTwo);

        int res = (int) ((val2-val2%1) - (val1 - val1%1));

        if (res < 0)
            res *=-1;

        int valueToAdd = 1;
        if(res != 0) {
            for (int i = 0; i < res; i++){
                listedRoots.add(valueToAdd);
                valueToAdd++;
            }
        }
        else {
            listedRoots.add(valueToAdd);
        }
        return listedRoots;
    }

}