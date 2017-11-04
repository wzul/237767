package com.wzul.issue9;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

/**
 * Creates a simple real-time chart
 */
public class Issue09 {

    public static double[] xdata = new double[1000]; //xdata
    public static double[] ydata = new double[1000];// ydata
    public static double numberx = 0.5;
    public static Random rn = new Random();

    public static void main(String[] args) throws Exception {

        Thread t1 = new Thread((Runnable) new TT());
        t1.start();
        
        // Create Chart
        final XYChart chart = QuickChart.getChart("Issue 09", "Counter", "Number", "Data", ydata, xdata);

        // Show it
        final SwingWrapper<XYChart> sw = new SwingWrapper<XYChart>(chart);
        sw.displayChart();

        while (true) {
            Thread.sleep(1000);
            chart.updateXYSeries("Data", ydata, xdata, null);
            sw.repaintChart();
        }

    }

}