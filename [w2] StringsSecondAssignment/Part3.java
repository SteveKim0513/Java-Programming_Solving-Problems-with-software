
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.*;


public class Part3 extends Part1 {
    
        public void printAllGenes_file(){
        
        //Read the text from file and change it into Uppercase, remove empty space.
        FileResource fr = new FileResource();
        String temp = fr.asString();
        String dna = temp.toUpperCase().replaceAll("\n", "");
        
        printAllGenes_text(dna);
    }
    
}
