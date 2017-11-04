package com.wzul.issuerealtime;

import java.io.File;
import java.util.LinkedList;

public class Issue11 {

    public static final String PATHFOLDER = "KATSINI";
    public static LinkedList<String> listOfFileName = new LinkedList<>();

    public static String getPath(String folderName) {
        return System.getProperty("user.dir") + File.separator + folderName;
    }

    public static void listFilesForFolder(final File folder) {

        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                if (checkJavaExtension(fileEntry.getName())) {
                    listOfFileName.add(fileEntry.getName());
                }
            }
        }
    }

    public static boolean checkJavaExtension(String extName) {
        try {
            if (extName.substring(extName.length() - 5).equalsIgnoreCase("class")) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public static void main(String[] args) {

        File file = new File(getPath(PATHFOLDER));
        listFilesForFolder(file);
        for (int i = 0; i < listOfFileName.size(); i++) {
            System.out.println(listOfFileName.get(i));
        }

    }
}