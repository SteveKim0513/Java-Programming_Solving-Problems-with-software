
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.*;

public class Part1 {
    
    
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        
        int temp_index = 0;
        int resultIndex = 0;
        
        while(true){
            resultIndex = dna.indexOf(stopCodon, temp_index+1);
            
            if(resultIndex == -1) return dna.length();
            
            else if((resultIndex - startIndex) % 3 == 0) break;
            
            temp_index = resultIndex;
        }
        
        return resultIndex;
    }
    
    
    
    public void testFindStopCodon(){
        System.out.println("==================================================");
        
        String dna = "ATGAAAAAAAA";
        int startIndex = dna.indexOf("ATG");
        if(startIndex == -1) System.out.println("No ATG");
        
        int stopIndex = findStopCodon(dna, startIndex, "TAA");
        
        System.out.println(dna.substring(startIndex, stopIndex+3));
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public String findSimpleGene(String dna){
        int startCodon = dna.indexOf("ATG");
        int stopCodon = dna.indexOf("TAA", startCodon+3);

        if(startCodon == -1 || stopCodon == -1 || (stopCodon-startCodon) % 3 != 0) return "";
        
        return dna.substring(startCodon, stopCodon+3);
    }

    
    
    public void testSimpleGene(){
     
        //ordinary case
        String dna1 = "AAAATGBBBBBBTAAAA";
        String result1 = findSimpleGene(dna1);
        System.out.println("DNA1 is " + dna1 + "\n" + "Result is " + result1);        

        
        //no ATG
        String dna2 = "AAAAAAAAAAAAAAATAA";
        String result2 = findSimpleGene(dna2);
        System.out.println("DNA2 is " + dna2 + "\n" + "Result is " + result2);
        
        
        //no TAA
        String dna3 = "ATGAAAAAAAAAAAAA";
        String result3 = findSimpleGene(dna3);
        System.out.println("DNA2 is " + dna3 + "\n" + "Result is " + result3);
        
        
        //The result is not multiple 3
        String dna4 = "ATGAATTA";
        String result4 = findSimpleGene(dna4);
        System.out.println("DNA2 is " + dna4 + "\n" + "Result is " + result4);
        
    }
    
    

    
    
    
    
    
    
}
