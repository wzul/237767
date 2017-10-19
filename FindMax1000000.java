package javaaplication5;

import static java.lang.Thread.sleep;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FindMax1000000 {

    public static void main(String[] args) throws InterruptedException {
        sleep(100);
        long startTimeSequential = System.nanoTime();
        int[] millionNumber = genMillionNumber();
        sequential(millionNumber);
        long stopTimeSequential = System.nanoTime();
        System.out.printf("Sequential Program = %.8f seconds%n", (stopTimeSequential - startTimeSequential) / 1000000000.0);

        sleep(100);
        long startTimeThread = System.nanoTime();
        ExecuterRunnable2 pt = new ExecuterRunnable2();
        pt.setMillionNumber(millionNumber);
        Thread t1 = new Thread(pt, "t1");
        Thread t2 = new Thread(pt, "t2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        //CountDownLatch test = new CountDownLatch(2);
        //test.await();

        long stopTimeThread = System.nanoTime();
        System.out.printf("Concurrent Program = %.8f seconds%n", (stopTimeThread - startTimeThread) / 1000000000.0);

    }

    public static int[] genMillionNumber() {
        int[] randomNumber = new int[1000000];

        for (int i = 0; i < randomNumber.length; i++) {
            randomNumber[i] = (int) Math.random();
        }
        return randomNumber;
    }

    public static void sequential(int randomNumber[]) {
        int maximumNumber = 0;

        for (int i = 0; i < randomNumber.length; i++) {
            if (randomNumber[i] > maximumNumber) {
                maximumNumber = randomNumber[i];
            }
        }
    }

}

class ExecuterRunnable2 implements Runnable {

    int maximum = 0;
    int[] millionNumber;

    public void setMillionNumber(int[] millionNumber) {
        this.millionNumber = millionNumber;
    }

    @Override
    public void run() {
        try {
            sleep(1000);
        } catch (InterruptedException ex) {
        }
        for (int i = 0; i < millionNumber.length; i++) {
            if (millionNumber[i] > maximum) {
                maximum = millionNumber[i];
            }
        }
    }
}
