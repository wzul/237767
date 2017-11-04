package findissues;

import Folder.ListFile;
import Folder.Path;
import Issue.Identify;
import Issue.ScanFile;
import Issue.ScanObject;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

public class FindIssues {

    public static final String PATHFOLDER = "KATSINI";

    public static void main(String[] args) {

        File file = new File(Path.getPath(PATHFOLDER));
        ListFile listFile = new ListFile();
        String arrayListFile[] = listFile.listFilesForFolder(file).getListFile(); //validated. betul
        
        ScanFile scanFile = new ScanFile();
        String fileContent[][] = scanFile.getFileContent(arrayListFile, PATHFOLDER);
        int numberOfFiles = scanFile.getNumberOfFiles();

        Identify identify = new Identify();
        identify.scanFileContent(fileContent);

        String className[][] = identify.getClassName();
        int totalClassName = Identify.getNumberOfClass(className);
        int classFileNumber[] = identify.getClassFileNumber();
        int interfaceFileNumber[] = identify.getInterfaceFileNumber();
        
        ScanObject scanObject = new ScanObject(fileContent, className);
        scanObject.setClassFileNumber(classFileNumber);
        scanObject.setInterfaceFileNumber(interfaceFileNumber);
        int issueSolved = scanObject.getIssueSolved(numberOfFiles);
        
        System.out.println("Number of Java Files = " + numberOfFiles);
        System.out.println("Number of Issues = " + issueSolved);
      
    }

}
