import chart.BarChart;
import function.SecondDegree;

public class Main {
    public static void main(String[] args) {

        BarChart bc = new BarChart(true, '#');

        SecondDegree ret = new SecondDegree(1, -8, 12);

        ret.connect(bc);
        ret.present();
    }
}