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
        BufferedReader br = null;
        BufferedReader br1 = null;
        try {
            br = new BufferedReader(new FileReader(new File("D:/Test1_right.txt")));
            br1 = new BufferedReader(new FileReader(new File("D:/Test1_left.txt")));
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