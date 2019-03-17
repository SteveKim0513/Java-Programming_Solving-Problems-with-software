
/**
 * 여기에 Test_StorageResource 클래스 설명을 작성하십시오.
 * 
 * @author (작성자 이름) 
 * @version (버전번호나 날짜)
 */

import edu.duke.*;
import java.io.*;


public class Test_StorageResource {
    
    public StorageResource make_StorageResource(){
        
        FileResource fr = new FileResource();
        StorageResource sr = new StorageResource();
        
        for(String curr : fr.lines()){
            sr.add(curr);
        }
        
        return sr;
    }
    
}
