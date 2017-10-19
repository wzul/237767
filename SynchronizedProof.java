package javaaplication5;

import static java.lang.Thread.sleep;
import java.util.concurrent.atomic.AtomicInteger;

class SynchronizedProof {

    public static void main(String[] args) throws InterruptedException {

        sleep(500);
        normalIssue();
        sleep(500);
        synchronizedIssue();

    }

    public static void normalIssue() throws InterruptedException {
        CountProblemNormal pt = new CountProblemNormal();
        Thread t1 = new Thread(pt, "t1");
        Thread t2 = new Thread(pt, "t2");
        long startTimeT1 = System.nanoTime();
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        while (pt.getCount() != 2000) {
            //Busy Waiting until it complete increment
        }
        long endTimeT1 = System.nanoTime();

        System.out.printf("Normal thread = %.8f seconds%n", (endTimeT1 - startTimeT1) / 1000000.0);
    }

    public static void synchronizedIssue() throws InterruptedException {
        CountProblemSynchronized pt = new CountProblemSynchronized();
        Thread t1 = new Thread(pt, "t1");
        Thread t2 = new Thread(pt, "t2");
        long startTimeT1 = System.nanoTime();
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        while (pt.getCount() != 2000) {
            //Busy Waiting until it complete increment
        }
        long endTimeT1 = System.nanoTime();

        System.out.printf("Synchronized thread = %.8f seconds%n", (endTimeT1 - startTimeT1) / 1000000.0);
    }
}

class CountProblemNormal implements Runnable {

    private static AtomicInteger atomicCounter = new AtomicInteger(0);
    private static int count;

    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            count = atomicCounter.incrementAndGet();
        }
    }

    public int getCount() {
        return this.count;
    }
}

class CountProblemSynchronized implements Runnable {

    private static AtomicInteger atomicCounter = new AtomicInteger(0);
    private static int count;

    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            synchronized (this) {
                count = atomicCounter.incrementAndGet();
            }
        }
    }

    public int getCount() {
        return this.count;
    }
}