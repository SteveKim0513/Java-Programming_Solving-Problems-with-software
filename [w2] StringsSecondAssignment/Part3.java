
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
    
        System.out.println("==================================== START ====================================");
        
        //Read the text from file and change it into Uppercase, remove empty space.
        FileResource fr = new FileResource();
        String temp = fr.asString();
        String dna = temp.toUpperCase().replaceAll("\n", "");
        
        String resultDNA = "";
        int count = 0;
        
        //Iterate to find all genes in File
        for(int i = 0 ; i < dna.length() ; ){
            
            resultDNA = findGene(dna);
            System.out.println("DNA = " + resultDNA);
            System.out.println("DNA Length = " + resultDNA.length());
            
            //Move the index after the Gene we finding.
            int stopIndex = findClosestStopcodon(dna, dna.indexOf("ATG"), list_stopCodon);
            dna = dna.substring(stopIndex);
            i = stopIndex;
            
            count ++;
        }
    
        System.out.println("Num of DNA =" + count);
    }
    
}
