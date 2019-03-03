
/**
 * 여기에 Part2 클래스 설명을 작성하십시오.
 * 
 * @author (작성자 이름) 
 * @version (버전번호나 날짜)
 */
     

import edu.duke.*;
import java.io.*;


public class Part2 {
    public String findSimpleGene(String dna, int startCodon, int stopCodon){
                 
        if(startCodon == -1) return "no ATG";
        
        if(stopCodon == -1) return "no TAA";
        
        if((stopCodon - startCodon) % 3 != 0) return "not multiples of 3";
        
        return dna.substring(startCodon, stopCodon+3);
    }   
        
    public Pair<Integer> UpperLower(String dna){
    
        String dna_lower = dna.toLowerCase();
        
        if(dna.equals(dna_lower)) return new Pair<Integer> (dna.indexOf("atg"), dna.indexOf("taa"));
        else return new Pair<Integer> (dna.indexOf("ATG"), dna.indexOf("TAA"));

    }
    
    public void testSimpleGene(){
        
        //ordinary case
        String dna1 = "AAAATGBBBBBBTAAAAA";
        
        Pair<Integer> pair1 = UpperLower(dna1);
        int startCodon1 = pair1.first();
        int stopCodon1 = pair1.second();
        
        String result1 = findSimpleGene(dna1, startCodon1, stopCodon1);
        System.out.println("DNA1 is " + dna1 + "\n" + "Result is " + result1);
            
        
        //no ATG
        String dna2 = "AAAAAAAAAAAAAAATTAA";
        
        Pair<Integer> pair2 = UpperLower(dna2);
        int startCodon2 = pair2.first();
        int stopCodon2 = pair2.second();
        
        String result2 = findSimpleGene(dna2, startCodon2, stopCodon2);
        System.out.println("DNA2 is " + dna2 + "\n" + "Result is " + result2);
            
        
        //no TAA
        String dna3 = "ATGAAAAAAAAAAAAA";
        
        Pair<Integer> pair3 = UpperLower(dna3);
        int startCodon3 = pair3.first();
        int stopCodon3 = pair3.second();
        
        String result3 = findSimpleGene(dna3, startCodon3, stopCodon3);
        System.out.println("DNA3 is " + dna3 + "\n" + "Result is " + result3);
            
        
        //The result is not multiple 3
        String dna4 = "ATGAATAA";
        
        Pair<Integer> pair4 = UpperLower(dna4);
        int startCodon4 = pair4.first();
        int stopCodon4 = pair4.second();
        
        String result4 = findSimpleGene(dna4, startCodon4, stopCodon4);
        System.out.println("DNA4 is " + dna4 + "\n" + "Result is " + result4);
        
        
        //lower case
        String dna5 = "aaaatgbbbbbbtaaaaa";
        
        Pair<Integer> pair5 = UpperLower(dna5);
        int startCodon5 = pair5.first();
        int stopCodon5 = pair5.second();
        
        String result5 = findSimpleGene(dna5, startCodon5, stopCodon5);
        System.out.println("DNA5 is " + dna5 + "\n" + "Result is " + result5);
           
    }
}
