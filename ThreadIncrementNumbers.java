public class Issue01 extends Thread {

    public static int count = 0;
    public static int sleepSeconds = 5000;
    public static boolean completed = false;
    public static boolean waitNext = false;
    public static String outputText = "----------AAAA-----------";

    public static void main(String[] args) {
        
        new Thread(new CheckCounting()).start();
        new Thread(new Issue01()).start();
    }

    @Override
    public void run() {
        try {
            for (; count <= 10500; count++) {
                waitNext = false;
                System.out.println(count);
                sleep(sleepSeconds);
            }
            completed = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class CheckCounting extends Thread {

    @Override
    public void run() {
        while (!Issue01.completed) {
            if ((Issue01.count % 50 == 0) && (!Issue01.waitNext) && (Issue01.count != 0)) {
                System.out.println(Issue01.outputText);
                Issue01.waitNext = true;
            }

        }
    }
}
