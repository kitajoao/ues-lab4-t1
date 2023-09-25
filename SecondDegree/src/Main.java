import plotter.BarChart;
import function.SecondDegreePush;

public class Main {
    public static void main(String[] args) {

        BarChart bc = new BarChart(true, '#');

        SecondDegreePush ret = new SecondDegreePush(1, -8, 12);

        ret.connect(bc);
        ret.present();
    }
}