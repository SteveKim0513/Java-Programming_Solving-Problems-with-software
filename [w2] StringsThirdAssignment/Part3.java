
/**
 * 여기에 Part3 클래스 설명을 작성하십시오.
 * 
 * @author (작성자 이름) 
 * @version (버전번호나 날짜)
 */

import edu.duke.*;
import java.io.*;


public class Part3 {
    
    Part1 F1 = new Part1();
    Part2 F2 = new Part2();
    Test_StorageResource TS = new Test_StorageResource();
    
    public void processGenes(StorageResource sr){
    
        int count_9 = 0;
        int count_cg = 0;
        int length_gene = 0;
        
        System.out.println("Longer than 9 Char");
        for(String curr : sr.data()){
            if(curr.length() > 9){
                count_9 ++;
                System.out.println(curr);
            }
        }
        System.out.println("Number of Strings(longer than 9 characters) = " + count_9);
        
        System.out.println("\n\n");
        
        System.out.println("C-G-Ratio > 0.35");
        for(String curr : sr.data()){
            if(F2.cgRatio(curr) > 0.35){
                count_cg ++;
                System.out.println(curr);
            }
        }
        System.out.println("Number of Strings(CG Ratio > 0.35) = " + count_cg);
        
        System.out.println("\n\n");
        
        System.out.println("Length of logest Gene in SR");
        for(String curr : sr.data()){
            if(F1.findGene(curr).length() > length_gene) length_gene = F1.findGene(curr).length();
        }
        System.out.println("Result = " + length_gene);
    }
    
    
    public void test(){
    
        System.out.println("=== TEST START ===");
        
        StorageResource sr = new StorageResource();
        
        sr = TS.make_StorageResource();
        
        processGenes(sr);
    
    }
    
    
    
}
