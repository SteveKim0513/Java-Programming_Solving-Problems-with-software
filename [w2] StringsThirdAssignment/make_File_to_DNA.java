
/**
 * 여기에 make_File_to_DNA 클래스 설명을 작성하십시오.
 * 
 * @author (작성자 이름) 
 * @version (버전번호나 날짜)
 */

import edu.duke.*;
import java.io.*;


public class make_File_to_DNA {
    
    public String FileToDNA(){
        
        System.out.println("===== Make DNA string from File =====");
        //Read the text from file and change it into Uppercase, remove empty space.
        FileResource fr = new FileResource();
        String temp = fr.asString();
        String dna = temp.toUpperCase().replaceAll("\n", "");
        
        return dna;
    }
    
}
