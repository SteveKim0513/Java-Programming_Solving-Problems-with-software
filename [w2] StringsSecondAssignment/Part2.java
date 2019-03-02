
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.*;


public class Part2 {

    public int howMany(String stringa, String stringb){
        
        int count = 0;
        String temp_string = stringb;
        
        
        for(int i = 0 ; i < stringb.length() ; ){

            if(temp_string.indexOf(stringa) == -1) break;
            
            count ++;
            
            int temp_index = temp_string.indexOf(stringa) + stringa.length();
            temp_string = temp_string.substring(temp_index);
            
            i = i + temp_index;
        }
    
        return count;    
    }
    
    
    
    
    public void testHowMany(){
    
        int test1 = howMany("GAA", "ATGAACGAATTGAATC");
        System.out.println("Test Result = " + test1);
    
        int test2 = howMany("AA", "ATAAAA");
        System.out.println("Test Result = " + test2);
    
        int test3 = howMany("A", "AAAAA");
        System.out.println("Test Result = " + test3);
        
    }
}
