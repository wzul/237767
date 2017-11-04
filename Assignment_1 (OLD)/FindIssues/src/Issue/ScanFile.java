package Issue;

import Folder.Path;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;

public class ScanFile {

    String fileContent[][];
    LinkedList<String> listFileContent;

    public String[][] getFileContent(String arrayListFile[], String pathFolder) {

        fileContent = new String[arrayListFile.length][];
        listFileContent = new LinkedList();

        for (int i = 0; i < arrayListFile.length; i++) {
            readFileContent(arrayListFile[i], pathFolder, i);
        }
        return fileContent;
    }

    public void readFileContent(String fileName, String pathFolder, int fileNumber) {
        listFileContent.clear();
        File file = new File(fileName);
        try (BufferedReader br = new BufferedReader(new FileReader(Path.getPath(pathFolder) + "\\" + file))) {
            String line;

            while ((line = br.readLine()) != null) {
                listFileContent.add(line);
            }

            fileContent[fileNumber] = new String[listFileContent.size()];
            for (int b = 0; b < listFileContent.size(); b++) {
                fileContent[fileNumber][b] = listFileContent.get(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getNumberOfFiles() {
        return fileContent.length;
    }

}
