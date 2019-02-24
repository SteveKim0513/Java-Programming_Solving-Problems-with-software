
/**
 * 여기에 Part1 클래스 설명을 작성하십시오.
 * 
 * @author (작성자 이름) 
 * @version (버전번호나 날짜)
 */
public class Part1 {

    public String findSimpleGene(String dna){
        
        int startPoint = dna.indexOf("ATG");
        if(startPoint == -1) return "no ATG";
    
        int endPoint = dna.indexOf("TTA");
        if(endPoint == -1) return "no TTA";
    
        if((endPoint - startPoint) % 3 != 0) return "not multiples of 3";
    
        return dna.substring(startPoint, endPoint+3);

    }   
    
    public void testSimpleGene(){
    
        //ordinary case
        String dna1 = "AAAATGBBBBBBTTAAAA";
        String result1 = findSimpleGene(dna1);
        System.out.println("DNA1 is " + dna1 + "\n" + "Result is " + result1);
        
        //no ATG
        String dna2 = "AAAAAAAAAAAAAAATTA";
        String result2 = findSimpleGene(dna2);
        System.out.println("DNA2 is " + dna2 + "\n" + "Result is " + result2);
        
        //no TTA
        String dna3 = "ATGAAAAAAAAAAAAA";
        String result3 = findSimpleGene(dna3);
        System.out.println("DNA2 is " + dna3 + "\n" + "Result is " + result3);
        
        //The result is not multiple 3
        String dna4 = "ATGAATTA";
        String result4 = findSimpleGene(dna4);
        System.out.println("DNA2 is " + dna4 + "\n" + "Result is " + result4);
    
    }
    
}
