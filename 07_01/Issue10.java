package com.wzul.issuerealtime;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.model.io.xpp3.MavenXpp3Writer;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import java.util.Scanner;

public class Issue10 {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        String baseDir = System.getProperty("user.dir");
        List<Dependency> dependencies = new LinkedList<Dependency>();

        MavenXpp3Reader reader = new MavenXpp3Reader();
        Model model = null;
        try {
            model = reader.read(new FileInputStream(new File(baseDir, "\\pom.xml")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException ex) {
            ex.printStackTrace();
        }

        Dependency dep = new Dependency();
        System.out.print("Enter Group ID: ");
        String groupId = scan.next();
        dep.setGroupId(groupId);
        
        System.out.print("Enter Artifact ID: ");
        String artifactId = scan.next();
        dep.setArtifactId(artifactId);
        
        System.out.print("Enter Set Version: ");
        String version = scan.next();
        dep.setVersion(version);
        
        System.out.print("Set Scope: ");
        String scope = scan.next();
        dep.setScope(scope);
        
        dependencies.add(dep);
        model.addDependency(dep);
        
        MavenXpp3Writer writer = new MavenXpp3Writer();
        
        try {
            writer.write(new FileOutputStream(new File(baseDir, "\\pom.xml")), model);
        } catch (FileNotFoundException ex) {ex.printStackTrace();
        } catch (IOException ex) {ex.printStackTrace();}

    }

}