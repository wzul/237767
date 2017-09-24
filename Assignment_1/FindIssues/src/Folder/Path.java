package Folder;

import java.io.File;
import java.nio.file.Paths;
import java.util.LinkedList;

public class Path {
    
    /**
     * Relative folder directory is Netbeans Project Folder Must send folderName
     * with starting of /
     *
     * @param folderName
     * @return File
     */
    public static String getPath(String folderName) {
        return Paths.get("").toAbsolutePath().toString() + "\\" + folderName;
    }

}
