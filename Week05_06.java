package javaaplication5;

import java.util.Random;

public class Week05_06 {

    public static int randomNumber1[];
    public static int randomNumber2[];

    public static int totalRandomNumber1 = 0;
    public static int totalRandomNumber2 = 0;

    public static int total = 0;

    public static void main(String[] args) {

        randomNumber1 = new int[1000];
        randomNumber2 = new int[1000];

        Thread pt1 = new Thread_1();
        pt1.start();
        Thread pt2 = new Thread_2();
        pt2.start();
        Thread pt3 = new Thread_3();
        pt3.start();

        while (true) {
            if (total > 0) {
                System.out.println("Thread-1 = " + totalRandomNumber1);
                System.out.println("Thread-2 = " + totalRandomNumber2);
                System.out.println("Total = " + total);
                break;
            }else {
                System.out.print("");
            }
            //System.out.println(total);
        }
        System.exit(0);
    }
}

class Thread_1 extends Thread {

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < Week05_06.randomNumber1.length; i++) {
            Week05_06.randomNumber1[i] = random.nextInt(3000 - 500 + 1) + 500;
        }
        for (int i = 0; i < Week05_06.randomNumber1.length; i++) {
            Week05_06.totalRandomNumber1 += Week05_06.randomNumber1[i];
        }

        //System.out.println("First: " + Week05_06.totalRandomNumber1);
    }

}

class Thread_2 extends Thread {

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < Week05_06.randomNumber1.length; i++) {
            Week05_06.randomNumber2[i] = random.nextInt(3000 - 500 + 1) + 500;
        }
        for (int i = 0; i < Week05_06.randomNumber2.length; i++) {
            Week05_06.totalRandomNumber2 += Week05_06.randomNumber2[i];
        }
        //System.out.println("Second: " + Week05_06.totalRandomNumber2);
    }
}

class Thread_3 extends Thread {

    @Override
    public void run() {
        try {
            sleep(100);
        } catch (InterruptedException ex) {
        }

        while (true) {

            if (Week05_06.totalRandomNumber1 > Week05_06.totalRandomNumber2) {
                Week05_06.totalRandomNumber2 = Week05_06.totalRandomNumber2 + 2;
            }
            Week05_06.total = Week05_06.totalRandomNumber1 + Week05_06.totalRandomNumber2;
            if (Week05_06.totalRandomNumber1 < Week05_06.totalRandomNumber2) {
                break;
            }
        }
        //System.out.println("First " + Week05_06.totalRandomNumber1);
        //System.out.println("Second " + Week05_06.totalRandomNumber2);
        //System.out.println( Week05_06.total);
        //System.out.println("Dia berhenti");
    }

}
