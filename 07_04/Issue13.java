package com.wzul.issuerealtime;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.kohsuke.github.GHContent;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHUser;
import org.kohsuke.github.GitHub;

public class Issue13 {

    public static LinkedList<String> jumlahFile = new LinkedList<>();
    public static LinkedList<String> jumlahFolder = new LinkedList<>();
    public static GHRepository ghRepository;
    public static GHUser user;

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        GitHub github = GitHub.connectAnonymously();
        System.out.print("Insert Github Username: ");
        String userid = "zhamri";
        System.out.print("Insert Repository Name: ");
        String reponame = "STIW3054-RT-Programming";

        user = github.getUser(userid);

        checkDirectoryFirst("");

        System.out.println("Jumlah semua fail dan folder ialah: " + (jumlahFile.size() + jumlahFolder.size()));
        System.out.println("Ini ialah senarai file:\n");
        for (int i = 0; i < jumlahFile.size(); i++) {
            System.out.println((i + 1) + ". " + jumlahFile.get(i));
        }
        System.out.println("Ini ialah senarai folder:\n");
        for (int i = 0; i < jumlahFolder.size(); i++) {
            System.out.println((i + 1) + ". " + jumlahFolder.get(i));
        }

    }

    public static void checkDirectoryFirst(String dir) {
        System.out.println("Scanning Folder: " + dir);
        try {
            ghRepository = user.getRepository("STIW3054-RT-Programming");
        } catch (Exception e) {
        }
        List<GHContent> directoryContent = null;
        try {
            directoryContent = ghRepository.getDirectoryContent(dir);
        } catch (Exception e) {
        }
        for (GHContent contentEntry : directoryContent) {
            if (contentEntry.isFile()) {
                jumlahFile.add(contentEntry.getName());
            } else if (contentEntry.isDirectory()) {
                jumlahFolder.add(contentEntry.getName());
                checkDirectoryFirst(contentEntry.getPath());
            }
        }

    }
}