package gumtree_xml;

import java.io.*;
import java.io.BufferedReader;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.custommonkey.xmlunit.DetailedDiff;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Assert;

public class GumTree_XML {
    public static void main(String[] args) throws IOException {
        int update = 0;
        int insert = 0;
        int delete = 0;
        BufferedReader br = null;
        BufferedReader br1 = null;
        int x = 0;
        int x1 = 0;
        try {
            br = new BufferedReader(new FileReader(new File("1st File Destination")));
            br1 = new BufferedReader(new FileReader(new File("2nd File Destination")));
            String s = "";
            String s1 = "";
            String text = "";
            String text1 = "";
            //save all the file in a string
            while ((s = br.readLine()) != null) {
                text += s + "\n";
            }   //remove empty lines with a regex
            while ((s1 = br1.readLine()) != null) {
                text1 += s1 + "\n";
            }
            String withoutEmptyLines = text.replaceAll("(?m)^[ \t]*\r?\n", "");
            String withoutEmptyLines1 = text1.replaceAll("(?m)^[ \t]*\r?\n", "");
            //lines of code = text with newline characters length - text without newline characters length
            int linesOfCode = withoutEmptyLines.length() - withoutEmptyLines.replaceAll("\n", "").length();
            int linesOfCode1 = withoutEmptyLines1.length() - withoutEmptyLines1.replaceAll("\n", "").length();
            //System.out.println("Lines: "+linesOfCode);
            if(linesOfCode == linesOfCode1){
                System.out.println("There is No Modifications in The Lines Number");
                System.out.println("Number of Lines: "+linesOfCode);
            }
            else{
                if(linesOfCode == linesOfCode1){
                    while ((s = br.readLine()) != null && (s1 = br1.readLine()) != null) {
                        if(s != s1)
                            update++;
                    }
                }
                else if(linesOfCode > linesOfCode1){
                    insert = linesOfCode - linesOfCode1;
                }
                else if(linesOfCode < linesOfCode1){
                    delete = linesOfCode1 - linesOfCode;
                }
                System.out.println("-----Summary-----");
                System.out.println("Number of Inserts: " + insert);
                System.out.println("Number of Updates: " + update);
                System.out.println("Number of Deletes: " + delete);
                String ss = null;
                String ss1 = null;
                String ss2 = null;
                String ss3 = null;
                while ((s = br.readLine()) != null) {
                    ss = s;
                    if(ss != null){
                        ss1 = s;
                        break;
                    }
                }
                while ((s1 = br1.readLine()) != null) {
                    ss2 = s;
                    if(ss2 != null){
                        ss3 = s;
                        break;
                    }
                }
                if(ss == ss2)
                    x = 0;
                else if(ss == ss3)
                    x = 1;
                else if(ss1 == ss2)
                    x = 2;
                else
                    x = 3;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GumTree_XML.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
                br1.close();
            } catch (IOException ex) {
                Logger.getLogger(GumTree_XML.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
