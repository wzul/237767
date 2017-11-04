package Issue;

import java.util.LinkedList;

public class Identify {

    private String className[][] = new String[2][];
    private String classType[] = {"class", "interface"};

    private LinkedList<Integer> listClassFileNumber = new LinkedList();
    private LinkedList<Integer> listInterfaceFileNumber = new LinkedList();

    private LinkedList<String> listClassName = new LinkedList();
    private LinkedList<String> listInterfaceName = new LinkedList();

    public void scanFileContent(String fileContent[][]) {
        int numberOfClass = 0;
        for (int i = 0; i < fileContent.length; i++) {
            for (int b = 0; b < fileContent[i].length; b++) {
                for (int c = 0; c < classType.length; c++) {
                    if (searchClassName(fileContent[i][b], classType[c])) {
                        scanClassName(fileContent[i][b], numberOfClass, i);
                        numberOfClass++;
                    }
                }
            }
        }
    }

    public boolean searchClassName(String sentence, String search) {
        if (sentence.toLowerCase().indexOf(search.toLowerCase()) != -1) {
            return true;
        }
        return false;
    }

    public void scanClassName(String line, int numberOfClass, int fileNumber) {
        String grepClassName[];
        for (int i = 0; i < classType.length; i++) {
            grepClassName = Regex.grepClassName(line, classType[i]);
            for (int b = 0; b < grepClassName.length; b++) {
                if (i == 0) {
                    listClassName.add(grepClassName[b]);
                    listClassFileNumber.add(fileNumber);
                } else {
                    listInterfaceName.add(grepClassName[b]);
                    listInterfaceFileNumber.add(fileNumber);
                }
            }
        }
    }

    public String[][] getClassName() {
        className[0] = new String[listClassName.size()];
        className[1] = new String[listInterfaceName.size()];
        for (int i = 0; i < listClassName.size(); i++) {
            className[0][i] = listClassName.get(i).toString();
        }

        for (int i = 0; i < listInterfaceName.size(); i++) {
            className[1][i] = listInterfaceName.get(i).toString();
        }

        return className;
    }

    public int[] getClassFileNumber() {
        int[] classFileNumber = new int[listClassFileNumber.size()];

        for (int i = 0; i < listClassFileNumber.size(); i++) {
            classFileNumber[i] = listClassFileNumber.get(i).intValue();
        }

        return classFileNumber;
    }

    public int[] getInterfaceFileNumber() {
        int[] interfaceFileNumber = new int[listInterfaceFileNumber.size()];

        for (int i = 0; i < listInterfaceFileNumber.size(); i++) {
            interfaceFileNumber[i] = listInterfaceFileNumber.get(i).intValue();
        }

        return interfaceFileNumber;
    }

    public static int getNumberOfClass(String[][] className) {
        int numberOfClass = 0;
        for (int i = 0; i < className.length; i++) {
            for (int b = 0; b < className[i].length; b++) {
                numberOfClass++;
            }
        }
        return numberOfClass;
    }
}
