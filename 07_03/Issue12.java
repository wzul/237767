package com.wzul.issuerealtime;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHUser;
import org.kohsuke.github.GitHub;

public class Issue12 {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        GitHub github = GitHub.connectAnonymously();
        System.out.print("Insert Github Username: ");
        String userid = scan.next();
        GHUser user = github.getUser(userid); //Change parameter to any valid user ID
        String readableName = user.getName();

        Map<String, GHRepository> map = user.getRepositories();

        Set repoNames = map.keySet();
        int repoCount = repoNames.size();

        Object[] names = repoNames.toArray();

        System.out.println("Total repository number for " + readableName + " is: " + repoCount);
        System.out.println("\nBelow are all the " + userid + "'s repositories:");
        for (int i = 0; i < repoCount; i++) {
            System.out.println((i + 1) + ". " + names[i]);
        }
    }
}