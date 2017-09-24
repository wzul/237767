package Issue;

public class ScanObject {

    private String[][] fileContent;
    private String[][] className;
    private int[] classFileNumber;
    private int[] interfaceFileNumber;

    public static final String[] KEYWORD = {"new", "extends", "implements"};

    public ScanObject() {
    }

    public ScanObject(String[][] fileContent, String[][] className) {
        this.fileContent = fileContent;
        this.className = className;
    }

    public ScanObject setFileContent(String[][] fileContent) {
        this.fileContent = fileContent;
        return this;
    }

    public ScanObject setClassName(String[][] className) {
        this.className = className;
        return this;
    }

    public ScanObject setClassFileNumber(int[] classFileNumber) {
        this.classFileNumber = classFileNumber;
        return this;
    }

    public ScanObject setInterfaceFileNumber(int[] interfaceFileNumber) {
        this.interfaceFileNumber = interfaceFileNumber;
        return this;
    }

    public int getIssueSolved(int numberOfFile) {
        int theClassInFile = 0;

        boolean inFileDoesHaveClass = false;

        for (int i = 0; i < className.length; i++) {
            for (int b = 0; b < className[i].length; b++) {

                if (i == 0) {// It is a class
                    theClassInFile = classFileNumber[b];
                } else if (i == 1) {
                    theClassInFile = interfaceFileNumber[b];
                }
                //b ialah benda yang kena take note

                for (int c = 0; c < fileContent.length; c++) {
                    inFileDoesHaveClass = false;
                    if (theClassInFile == c) {
                        continue;
                    }
                    for (int d = 0; d < fileContent[c].length; d++) {
                        if (grepObject(fileContent[c][d], className[i][b])) {
                            inFileDoesHaveClass = true;
                            fileContent[c][d] = "";
                            break;
                        } else {
                            inFileDoesHaveClass = false;
                        }
                    }
                    if (inFileDoesHaveClass) {
                        numberOfFile--;
                    }
                }
            }
        }

        return numberOfFile;
    }

    public boolean grepObject(String singleLine, String className) {
        String[] usageOfClass = null;
        boolean condition = false;
        for (int i = 0; i < KEYWORD.length; i++) {
            usageOfClass = Regex.grepClassName(singleLine, KEYWORD[i]);
            for (int b = 0; b < usageOfClass.length; b++) {

                if (usageOfClass.length == 0) {
                    condition = false;
                } else {
                    if (usageOfClass[b].equalsIgnoreCase(className)) {
                        return true;
                    }
                    condition = false;
                }
            }

        }

        return condition;
    }
}
