
/**
 * 여기에 Part4 클래스 설명을 작성하십시오.
 * 
 * @author (작성자 이름) 
 * @version (버전번호나 날짜)
 */


import edu.duke.URLResource;


public class Part4 {

    public void main() {
        
        URLResource url = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        
        System.out.println("==================================================");
        
        
        for(String each_word : url.words()){
            
            String temp_word = each_word.toLowerCase();
            int Index_youtube = temp_word.indexOf("youtube.com");

            if(Index_youtube != -1){
                int first_index = temp_word.indexOf("\"");
                int last_index = temp_word.lastIndexOf("\"")+1;
                
                String result = each_word.substring(first_index, last_index);
                System.out.println(result + "\n");
            }
            
        }
        
        
        
        
    
    

    }
    
    
    
    
    public void test(){
    
            URLResource url = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");

            for(String each_word : url.words()){
                System.out.println(each_word);
            }
    
    }
    
    
}
