package javaapplication5;

public class JavaApplication5 extends Thread {

    public static int nombor = 1;
    public static char huruf = 'A';

    public static void main(String[] args) {
        new Thread(new JavaApplication5()).start();
        new Thread(new PrintA()).start();
    }

    @Override
    public void run() {
        try {
            for (; JavaApplication5.nombor <= 10; JavaApplication5.nombor++) {
                if (JavaApplication5.nombor == 6) {
                    sleep(100);
                }
                System.out.print(JavaApplication5.nombor + " ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class PrintA extends Thread {

    @Override
    public void run() {
        while (true) {
            if (JavaApplication5.nombor == 6) {
                for (int i = 0; i < 10; i++) {
                    System.out.print(JavaApplication5.huruf);
                }
                System.out.print(" ");
                break;
            }
        }
    }
}
