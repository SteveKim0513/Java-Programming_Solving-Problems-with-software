
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.*;

public class Part1 {
    // There are three stop codons "TAA", "TAG" or "TGA".
    public static String[] list_stopCodon = {"TAA", "TAG", "TGA"};
    
    
    public int findStopCodon(String dna, int startIndex, String stopCodon){

        int temp_index = startIndex;
        int resultIndex = 0;
        
        while(true){
            resultIndex = dna.indexOf(stopCodon, temp_index+1);
            
            if(resultIndex == -1) return dna.length();
            
            else if((resultIndex - startIndex) % 3 == 0) break;
            
            //Find stopCodon after next index of this codon. 
            temp_index = resultIndex;
        }
        
        return resultIndex;
    }
    
    public int findClosestStopcodon(String dna, int startIndex, String[] stopCodon){
    
        int[] index = new int[stopCodon.length];
    
        //each index refer to the indexing of stopcodon "TAA", "TAG", "TGA".
        for(int i = 0 ; i < stopCodon.length ; i++){
            index[i] = findStopCodon(dna, startIndex, stopCodon[i]);
        }
        
        
        //find closest stopcodon from "ATG".
        int min = index[0];
        
        for(int i = 0 ; i < stopCodon.length ; i++){
            if(min > index[i]) min = index[i];
        }

        return min;
    }
        
    public String findGene(String dna){
    
        String resultDNA = "";
        
        int startIndex = dna.indexOf("ATG");
        if(startIndex == -1) return "";
    
        //Find closest stop codon from start codon
        int stopIndex = findClosestStopcodon(dna, startIndex, list_stopCodon);
        if(stopIndex == -1) return "";
        
        //If no Stopcodon, return NULL
        if(stopIndex == dna.length()) resultDNA = "";
        else resultDNA = dna.substring(startIndex, stopIndex+3);
        
        return resultDNA;
    }
    
    
    public void testFindGene(){
    
        //ordinary case with "TAA"
        String dna1 = "AAAATGBBBBBBTAAAA";
        String result1 = findGene(dna1);
        System.out.println("DNA1 is " + dna1 + "\n" + "Result is " + result1);        

        //ordinary case with "TAG"
        String dna2 = "AAAATGBBBBBBTAGAA";
        String result2 = findGene(dna2);
        System.out.println("DNA2 is " + dna2 + "\n" + "Result is " + result2);        

        //ordinary case with "TGA"
        String dna3 = "AAAATGBBBBBBTGAAA";
        String result3 = findGene(dna3);
        System.out.println("DNA3 is " + dna3 + "\n" + "Result is " + result3);        
        
        //ordinary case with "TAA" and "TGA"
        String dna4 = "AAAATGBBBBBBTAAAAATGA";
        String result4 = findGene(dna4);
        System.out.println("DNA4 is " + dna4 + "\n" + "Result is " + result4);        
        
        //no ATG
        String dna5 = "AAAAAAAAAAAAAAATAA";
        String result5 = findGene(dna5);
        System.out.println("DNA5 is " + dna5 + "\n" + "Result is " + result5);
        
        //no StopCodon
        String dna6 = "ATGAAAAAAAAAAAAA";
        String result6 = findGene(dna6);
        System.out.println("DNA6 is " + dna6 + "\n" + "Result is " + result6);
        
        //The result is not multiple 3
        String dna7 = "ATGAATTA";
        String result7 = findGene(dna7);
        System.out.println("DNA7 is " + dna7 + "\n" + "Result is " + result7);
    
    }
    
    public void printAllGenes_text(String dna){
    
        System.out.println("==================================== START ====================================");
        
        String resultDNA = "";
        int num_loop = dna.length();
        int count = 0;
        
        //Iterate to find all genes in File
        for(int i = 0 ; i < num_loop ; ){
            
            resultDNA = findGene(dna);
            System.out.println("DNA = " + resultDNA);
            System.out.println("DNA Length = " + resultDNA.length());
            
            //Move the index after the Gene we finding.
            int stopIndex = findClosestStopcodon(dna, dna.indexOf("ATG"), list_stopCodon);
            
            if(stopIndex == dna.length()) break;
            
            dna = dna.substring(stopIndex);
            i = stopIndex;
            
            count ++;
        }
    
        System.out.println("Num of DNA =" + count);
    }
    
    /*
    
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
    
    */
    
}
