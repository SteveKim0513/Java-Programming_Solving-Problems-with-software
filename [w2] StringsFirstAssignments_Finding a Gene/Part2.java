
/**
 * 여기에 Part2 클래스 설명을 작성하십시오.
 * 
 * @author (작성자 이름) 
 * @version (버전번호나 날짜)
 */

import edu.duke.*;
import java.io.*;

public class Part2 {
    public String findSimpleGene(String dna){
        
        Pair<Integer> pair = UpperLower(dna);
        int startCodon = pair.first();
        int stopCodon = pair.second();
        
        
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

        String result1 = findSimpleGene(dna1);
        System.out.println("DNA1 is " + dna1 + "\n" + "Result is " + result1);

        
        //no ATG
        String dna2 = "AAAAAAAAAAAAAAATTAA";

        String result2 = findSimpleGene(dna2);
        System.out.println("DNA2 is " + dna2 + "\n" + "Result is " + result2);

        
        //no TAA
        String dna3 = "ATGAAAAAAAAAAAAA";

        String result3 = findSimpleGene(dna3);
        System.out.println("DNA3 is " + dna3 + "\n" + "Result is " + result3);

        
        //The result is not multiple 3
        String dna4 = "ATGAATAA";

        String result4 = findSimpleGene(dna4);
        System.out.println("DNA4 is " + dna4 + "\n" + "Result is " + result4);

        
        //lower case
        String dna5 = "aaaatgbbbbbbtaaaaa";
        
        String result5 = findSimpleGene(dna5);
        System.out.println("DNA5 is " + dna5 + "\n" + "Result is " + result5);

    }
}
