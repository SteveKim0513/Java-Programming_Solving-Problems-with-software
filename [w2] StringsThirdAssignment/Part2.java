
/**
 * 여기에 Part2 클래스 설명을 작성하십시오.
 * 
 * @author (작성자 이름) 
 * @version (버전번호나 날짜)
 */

import edu.duke.*;
import java.io.*;


public class Part2 {

    
    public double cgRatio(String dna){
        
        int count = 0;
        
        for( int i=0 ; i < dna.length() ; i++ ){
            
            if(dna.substring(i, i+1).equals("C") || dna.substring(i, i+1).equals("G")) count++;
                        
        }

        double result = (double)count/dna.length();
        
        return result;
    }
    
    public int countCTG(String dna){
    
        int count = 0;
        
        for( int i=0 ; i < dna.length() ; i++ ){
        
            if(dna.substring(i, i+3).equals("CTG")) count++;
            
        }
        
        return count;
    }
    
}
