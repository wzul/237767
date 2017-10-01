package Test_files.Issue_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HelloWorld {

    public static void main(String[] args) throws Exception {
        pbuilder("javac -d . HelloWorld.java");
        pbuilder("java Test_files.Issue_01.HelloWorld");
    }

    public static void pbuilder(String commandString) {
        try {
            ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe", "/c", "cd \"C:\\Users\\wanzu\\Desktop\\STIW3054\" && " + commandString);
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while (true) {
                line = r.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
