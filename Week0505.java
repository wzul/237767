package javaaplication5;

import java.util.Collections;
import java.util.List;

public class Week0505 extends Thread {

    public static int[] randomNumber = new int[1000000];

    public static void main(String[] args) {
        for (int i = 0; i < randomNumber.length; i++) {
            randomNumber[i] = (int) (Math.round(Math.random()*1000000));
        }

        new Thread() {
            double sum = 0;

            public void run() {
                for (int i = 0; i < randomNumber.length; i++) {
                    sum += randomNumber[i];
                }
                double mean = (double) sum / (double) randomNumber.length;
                System.out.println("MIN = " + mean);
            }
        }.start();

        new Thread() {
            int mod = 0;

            public void run() {
                for (int i = 0; i < randomNumber.length; i++) {
                    if (mod < randomNumber[i]) {
                        mod = randomNumber[i];
                    }
                }
                System.out.println("MOD = " + mod);
            }
        }.start();

        new Thread() {
            public void run() {
                int temp = 0;
                for (int i = 0; i < randomNumber.length; i++) {
                    for (int j = i + 1; j < randomNumber.length; j++) {
                        if (randomNumber[i] > randomNumber[j]) {
                            temp = randomNumber[i];
                            randomNumber[i] = randomNumber[j];
                            randomNumber[j] = temp;
                        }
                    }
                }

                int median = 0;
                if (randomNumber.length % 2 == 0) {
                    int firstIndex = randomNumber.length % 2;
                    int secondIndex = firstIndex + 1;

                    median = (randomNumber[firstIndex] + randomNumber[secondIndex]) / 2;
                } else {
                    median = randomNumber[randomNumber.length / 2];
                }
                System.out.println("MEDIAN = " + median);
            }
        }.start();

    }
}
