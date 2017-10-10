//Semester: #A171
//Course: #STIW3054
//Group: #A
//Task: #Assignment2
//Matrik: #237767
//Name: #Wan Zulkarnain Bin Wan Hasbullah
package assignment2;

import Excel.SumData;
import Excel.Generate;
import FileHandler.Identify_Adapter;
import FileHandler.ScanFile;
import FolderHandler.ListFile;
import FolderHandler.Path;
import java.io.File;

public class Assignment2 {

    public static final String PATHFOLDER = "KATSINI";
    public static final String FILENAME = "output_result.xlsx";

    public static void main(String[] args) {

        File file = new File(Path.getPath(PATHFOLDER));
        ListFile listFile = new ListFile();
        String arrayListFile[] = listFile.listFilesForFolder(file).getListFile();

        ScanFile scanFile = new ScanFile();
        String fileContent[][] = scanFile.getFileContent(arrayListFile, PATHFOLDER);
        int numberOfFiles = scanFile.getNumberOfFiles();

        Identify_Adapter identify = new Identify_Adapter(fileContent);

        String name[] = identify.getName();
        String matrik[] = identify.getMatrik();
        String course = identify.getCourse();
        String group = identify.getGroup();
        String semester = identify.getSemester();
        String task = identify.getTask();

        String[] javaKeywords = identify.getJavaKeywords();
        int[][] keywordsCount = identify.getKeywordsCount();

        int[][] lineOfCode = identify.getLineOfCode();

        SumData sumdata = new SumData(name, matrik, course, group, semester, task, javaKeywords, keywordsCount, lineOfCode);
        int totalKeywords[][] = sumdata.getTotalKeywordsCount();
        String[] distinctMatrik = sumdata.getDistinctMatrik();
        int[] totalMatrik = sumdata.getTotalForEachMatrik();

        int[][] totalLOC = sumdata.getTotalLOC();
        Generate generate = new Generate(FILENAME);
        generate.setHeader(semester, course, group, task).setKeyword(javaKeywords);
        generate.setData(totalKeywords, javaKeywords, distinctMatrik, totalLOC, totalMatrik);
        generate.processDataObject().createExcel().write();

        /*
        
        This line has been commented because this program is expected to run without any output. Uncomment this code
        will display the output that passed to the excel document in terminal way.
        
        for (int i = 0; i < totalKeywords.length; i++) {
            System.out.println("Ini ialah untuk nombor matrik: " + distinctMatrik[i]);
            System.out.println("LOC: " + (totalLOC[i][0] + totalLOC[i][1] + totalLOC[i][2]));
            System.out.println("Blank Line: " + totalLOC[i][0]);
            System.out.println("Comment: " + +totalLOC[i][1]);
            System.out.println("Actual LOC: " + totalLOC[i][2]);
            for (int b = 0; b < totalKeywords[i].length; b++) {
                if (totalKeywords[i][b] != 0) {
                    System.out.println("Jumlah keyword untuk " + javaKeywords[b] + " ialah: " + totalKeywords[i][b]);
                }
            }
            System.out.println("Jumlah semua ialah: " + totalMatrik[i]);
            System.out.println("");
        }
        */

    }

}
