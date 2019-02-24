
/**
 * 여기에 Part3 클래스 설명을 작성하십시오.
 * 
 * @author (작성자 이름) 
 * @version (버전번호나 날짜)
 */
public class Part3 {

    public boolean twoOccurrences(String stringa, String stringb) {
    
        String temp_str = stringb;
        int temp_num = 0;
        
        int count = 0;
        int length_a = stringa.length();
        int length_b = stringb.length();
               
        for(int i=0 ; i < stringb.length(); ){
            temp_num = temp_str.indexOf(stringa);
            
            if(temp_num == -1) break;
            
            else {
                count ++;
                temp_str = temp_str.substring(temp_num + length_a);
                i = i + temp_num + length_a;
            }
        }
        
        if (count > 1) return true;
        else return false;
    }

    public String lastPart(String stringa, String stringb) {
        int index = stringb.indexOf(stringa);
        int length_a = stringa.length();
        
        if (index == -1) return stringb;
        
        else return stringb.substring(index + length_a);    
    }
    
    
    
    public void test() {
    
        System.out.println("============================================================");
        
        // True case
        String test1a = "an";
        String test1b = "banana";
        
        boolean result_twoOccurrences1 = twoOccurrences(test1a, test1b);
        String result_lastPart1 = lastPart(test1a, test1b);
        System.out.println("Input= " + test1a + "," + test1b + "\n" + "Result= " +result_twoOccurrences1);
        System.out.println("Last Part= " + result_lastPart1);
        
        System.out.println("\n");
        
        // True case
        String test2a = "atg";
        String test2b = "atgaaabbbbbbttaatg";
        
        boolean result_twoOccurrences2 = twoOccurrences(test2a, test2b);
        String result_lastPart2 = lastPart(test2a, test2b);
        System.out.println("Input= " + test2a + "," + test2b + "\n" + "Result= " +result_twoOccurrences2);
        System.out.println("Last Part= " + result_lastPart2);
        
        System.out.println("\n");
        
        // False case
        String test3a = "c";
        String test3b = "car";
        
        boolean result_twoOccurrences3 = twoOccurrences(test3a, test3b);
        String result_lastPart3 = lastPart(test3a, test3b);
        System.out.println("Input= " + test3a + "," + test3b + "\n" + "Result= " +result_twoOccurrences3);
        System.out.println("Last Part= " + result_lastPart3);
        
        System.out.println("\n");
        
        // False case
        String test4a = "zoo";
        String test4b = "forest";
        
        boolean result_twoOccurrences4 = twoOccurrences(test4a, test4b);
        String result_lastPart4 = lastPart(test4a, test4b);
        System.out.println("Input= " + test4a + "," + test4b + "\n" + "Result= " +result_twoOccurrences4);
        System.out.println("Last Part= " + result_lastPart4);
    }
    
    
}
