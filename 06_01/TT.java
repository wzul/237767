package com.wzul.issue9;

import static java.lang.Thread.sleep;
import java.util.Random;

public class TT implements Runnable {

    public void run() {
        starting();
        while (running());
    }

    public synchronized void starting() {
        for (int i = 0; i < Issue09.xdata.length; i++) {
            Issue09.xdata[i] = Issue09.rn.nextInt(100 - 0 + 1) + 0;
            Issue09.numberx += 0.5;
            Issue09.ydata[i] = Issue09.numberx;
        }
        try {
            sleep(1000);
        }catch (Exception e){}
    }

    public synchronized boolean running() {
        try {
            sleep(10);
        }catch (Exception e){}
        for (int i = 0; i < Issue09.xdata.length - 1; i++) {
            Issue09.xdata[i] = Issue09.xdata[i + 1];
            Issue09.ydata[i] = Issue09.ydata[i + 1];
        }
        Issue09.xdata[Issue09.xdata.length - 1] = Issue09.rn.nextInt(100 - 0 + 1) + 0;
        Issue09.numberx += 0.5;
        Issue09.ydata[Issue09.ydata.length - 1] = Issue09.numberx;
        return true;
    }

}